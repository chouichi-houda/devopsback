FROM maven:3.8.2-jdk-8
ADD target/tpAchatProject-1.0.jar tpAchatProject.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","/tpAchatProject.jar","--server.port=8089"]
