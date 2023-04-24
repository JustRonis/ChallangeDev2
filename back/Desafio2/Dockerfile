FROM mcr.microsoft.com/java/jdk:17-zulu-ubuntu


WORKDIR /app


COPY  /target/Desafio2-0.0.1-SNAPSHOT.jar /app/app.jar


EXPOSE 8080


CMD ["java", "-jar", "app.jar"]