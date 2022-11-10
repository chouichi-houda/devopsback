FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:admin123 -o achat-1.2.0.jar "http://192.168.1.17:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0.1/tpAchatProject-1.0.1.jar" -L
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.1.jar"]
EXPOSE 8089


