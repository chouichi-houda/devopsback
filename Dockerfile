FROM openjdk:11-jdk-alpine
EXPOSE 8082
ADD target/tpAchatProject-1.0 tpAchatProject-1.0
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0"]
