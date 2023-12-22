FROM openjdk:17-jdk

WORKDIR /app

COPY build/libs/weather-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "weather-0.0.1-SNAPSHOT.jar"]