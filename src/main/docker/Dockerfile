FROM openjdk:11-jre-slim

WORKDIR /app/

COPY startApp.sh startApp.sh
RUN chmod u+x startApp.sh
CMD ["bash", "./startApp.sh"]

ENV PORT 8001

ADD *.jar app.jar
