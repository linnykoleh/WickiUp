FROM java:8

MAINTAINER linnikoleh <linnik@oleh.com>

ADD start.sh /ConsulServices/start.sh
ADD target/ConsulServices-1.0-SNAPSHOT.jar /ConsulServices/ConsulServices.jar

WORKDIR /ConsulServices

RUN chmod +x /ConsulServices/start.sh
RUN chmod +x /ConsulServices/ConsulServices.jar

EXPOSE 8081

ENTRYPOINT ["./start.sh"]
