FROM python:3.4

RUN groupadd -r uwsgi && useradd -r -g uwsgi uwsgi
RUN pip install Flask==0.10.1

WORKDIR /app
COPY app /app
COPY start.sh /

EXPOSE 5000
USER uwsgi

CMD ["/start.sh"]