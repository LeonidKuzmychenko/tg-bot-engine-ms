FROM openjdk:11
MAINTAINER Leonid
COPY target/tg-serials-server-0.1.jar app.jar
EXPOSE 8095
ENTRYPOINT ["java", "-jar", "/app.jar"]
