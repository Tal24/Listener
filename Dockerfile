FROM openjdk:8-jdk-alpine
COPY target/*.jar listener.jar
ENTRYPOINT ["java","-jar","/listener.jar"]