FROM openjdk:17-jdk-slim

MAINTAINER stephenfu

COPY target/users-0.0.1-SNAPSHOT.jar users-microservice.jar

ENTRYPOINT ["java", "-jar", "users-microservice.jar"]