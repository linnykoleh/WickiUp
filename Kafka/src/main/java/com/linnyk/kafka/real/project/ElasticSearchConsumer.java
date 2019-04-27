package com.linnyk.kafka.real.project;

import com.google.gson.JsonParser;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ElasticSearchConsumer {

    private final static JsonParser JSON_PARSER = new JsonParser();

    private static RestHighLevelClient createClient() {
        String hostname = "https://kafkabylinnykoleh-2650153943.eu-central-1.bonsaisearch.net/";
        String username = "rdulo3fmwr";
        String password = "op930a71gv";

        // dont do if you run a local ES
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));

        RestClientBuilder builder = RestClient.builder(
                new HttpHost(hostname, 443, "https"))
                .setHttpClientConfigCallback(httpClientBuilder ->
                        httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
        return new RestHighLevelClient(builder);
    }

    private static KafkaConsumer<String, String> createKafkaConsumer() {
        // 1. Create consumer configuration
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "my_fifth_application");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // earliest/latest/none
        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false"); // disable auto commit

        // 2. Create consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // 3. Subscribe on topic(s)
        consumer.subscribe(Collections.singletonList("my_topic"));

        return consumer;
    }

    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = createClient();
        KafkaConsumer<String, String> kafkaConsumer = createKafkaConsumer();

        while (true) {
            final ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));

            System.out.println("Received: " + records.count() + " records");
            for (ConsumerRecord<String, String> record : records) {
                String jsonString = record.value();

                // 2 strategies

                // 1 kafka generic ID strategy
                String id1 = record.topic() + "_" + record.partition() + "_" + record.offset();

                // 2 twitter feed specific ID
                String id2 = extractIdFromTweet(jsonString);

                IndexRequest indexRequest = new IndexRequest(
                        "twitter",
                        "tweets",
                        id2 // this is to make consumer idempotent
                ).source(jsonString, XContentType.JSON);

                IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
                System.out.println(indexResponse.getId());
            }
            System.out.println("Committing offset...");
            kafkaConsumer.commitSync();
            System.out.println("Offset have been committed");
        }
    }

    private static String extractIdFromTweet(String value) {
        return JSON_PARSER.parse(value)
                .getAsJsonObject()
                .get("id_str")
                .getAsString();
    }
}
