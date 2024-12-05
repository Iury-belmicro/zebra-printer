FROM openjdk:17-alpine
WORKDIR /opt
ENV PORT 8080
ENV TZ="America/Sao_Paulo"
EXPOSE 8080
COPY app.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
