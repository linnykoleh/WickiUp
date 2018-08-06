FROM python:3.4

MAINTAINER linnykoleh <linnik@oleh.com>

RUN groupadd -r uwsgi && useradd -r -g uwsgi uwsgi
RUN pip install Flask==0.10.1 requests==2.5.1 redis==2.10.3

WORKDIR /app
COPY app /app
COPY start.sh /

EXPOSE 5000 6379
USER uwsgi

CMD ["/start.sh"]