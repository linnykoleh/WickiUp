FROM java:8

ADD start.sh /SimpleMicroservices/Client/start.sh
ADD target/Client-1.0-SNAPSHOT.jar /SimpleMicroservices/Client/Client.jar

WORKDIR /SimpleMicroservices/Client

RUN chmod +x /SimpleMicroservices/Client/start.sh
RUN chmod +x /SimpleMicroservices/Client/Client.jar

CMD ["./start.sh"]
