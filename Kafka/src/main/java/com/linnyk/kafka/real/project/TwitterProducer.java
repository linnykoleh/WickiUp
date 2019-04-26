package com.linnyk.kafka.real.project;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TwitterProducer {

    private static final String CONSUMER_KEY = "YmNLGxU73g1Pn32tAVMTlpmWA";
    private static final String CONSUMER_SECRET = "wOF4FMRvUi1XLX2xQNO8ZsQrSqixn5NMN0Rw4xEPZdt75ot3zV";
    private static final String TOKEN = "995365795856338945-j6upUCPEhVUCHJNQJquK4zvBC8eK44b";
    private static final String SECRET = "YOH6P9MelUawjMkY72sXNyXULyF9UVaO6yU8n58pqcln0";

    private static final ArrayList<String> TERMS = Lists.newArrayList("java", "kafka", "russia", "putin ");
    private static final String TOPIC = "twitter_tweets";

    public static void main(String[] args) {
        System.out.println("Hello twitter producer");

        new TwitterProducer().run();

    }

    private void run() {
        // 1 create twitter client
        BlockingQueue<String> msgQueue = new LinkedBlockingQueue<>(1000);

        Client hosebirdClient = createTwitterClient(msgQueue);
        hosebirdClient.connect();

        // 2 create twitter producer
        KafkaProducer<String, String> kafkaProducer = createKafkaProducer();

        // 3 loop to send tweets to kafka
        while (!hosebirdClient.isDone()) {
            String msg = null;
            try {
                msg = msgQueue.poll(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                hosebirdClient.stop();
            }
            if (Objects.nonNull(msg)) {
                System.out.println(msg);
                kafkaProducer.send(new ProducerRecord<>(TOPIC, null, msg), (recordMetadata, e) -> {
                    if (e != null) {
                        System.out.println("Error: " + e);
                    }
                });
            }
        }
    }


    private Client createTwitterClient(BlockingQueue<String> msgQueue) {
        Hosts hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
        StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();
        hosebirdEndpoint.trackTerms(TERMS);

        Authentication hosebirdAuth = new OAuth1(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, SECRET);

        ClientBuilder builder = new ClientBuilder()
                .name("Hosebird-Client-01")
                .hosts(hosebirdHosts)
                .authentication(hosebirdAuth)
                .endpoint(hosebirdEndpoint)
                .processor(new StringDelimitedProcessor(msgQueue));

        return builder.build();
    }

    private KafkaProducer<String, String> createKafkaProducer() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // safe producer
        properties.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");
        properties.setProperty(ProducerConfig.RETRIES_CONFIG, Integer.toString(Integer.MAX_VALUE));
        properties.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5");

        // high throughput producer
        properties.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
        properties.setProperty(ProducerConfig.LINGER_MS_CONFIG, "20");
        properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, Integer.toString(32 * 1024)); //32 KB


        return new KafkaProducer<>(properties);
    }
}
