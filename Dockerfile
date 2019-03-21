FROM openjdk:8-jdk-alpine
COPY target/listener-0.0.1-SNAPSHOT.jar listener.jar
ENTRYPOINT ["java","-jar","/listener.jar"]