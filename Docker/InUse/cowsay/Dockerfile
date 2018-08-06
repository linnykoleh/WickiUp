FROM debian:wheezy

MAINTAINER linnykoleh <linnik@oleh.com>
RUN apt-get update && apt-get install -y cowsay fortune

COPY entrypoint.sh /entrypoint-image.sh
RUN chmod +x /entrypoint-image.sh

ENV MY_VERSION 1.3

VOLUME /data-image

ENTRYPOINT ["/entrypoint-image.sh"]