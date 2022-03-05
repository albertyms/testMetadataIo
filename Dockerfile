FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8081
ADD target/metadatatest-0.0.1-SNAPSHOT.jar metadatatest-0.0.1.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/metadatatest-0.0.1.jar"]