FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:admin123 -o achat-1.0.2.jar "http://192.168.1.17:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0.2/tpAchatProject-1.0.2.jar" -L
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.2.jar"]
EXPOSE 8089


