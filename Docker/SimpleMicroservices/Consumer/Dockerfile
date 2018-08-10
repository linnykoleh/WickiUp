FROM java:8

MAINTAINER linnikoleh <linnik@oleh.com>

ADD start.sh /SimpleMicroservices/Consumer/start.sh
ADD target/Consumer-1.0-SNAPSHOT.jar /SimpleMicroservices/Consumer/Consumer.jar

WORKDIR /SimpleMicroservices/Consumer

RUN chmod +x /SimpleMicroservices/Consumer/start.sh
RUN chmod +x /SimpleMicroservices/Consumer/Consumer.jar

EXPOSE 8080

ENTRYPOINT ["./start.sh"]
