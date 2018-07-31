FROM debian:wheezy

MAINTAINER Linnyk Oleh <linnyk@oleh.com>
RUN apt-get update && apt-get install -y cowsay fortune

COPY entrypoint.sh /entrypoint-image.sh
RUN chmod +x /entrypoint-image.sh

VOLUME /data-image

ENTRYPOINT ["/entrypoint-image.sh"]