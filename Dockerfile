FROM openjdk:8-jdk-alpine
ARG artifactId
ARG version
COPY target/${artifactId}-${version}.jar listener.jar
ENTRYPOINT ["java","-jar","/listener.jar"]