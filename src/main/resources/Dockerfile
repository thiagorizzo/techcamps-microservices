FROM openjdk:18-jdk-alpine
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
COPY application.properties application.properties
ENTRYPOINT ["java","-jar","/app.jar", "--spring.config.location=file:application.properties"]