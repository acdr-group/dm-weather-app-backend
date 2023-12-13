# syntax=docker/dockerfile:1

# Stage 1: Build the application
FROM gradle:8.5-jdk-jammy as build
WORKDIR /dm-weather-app-backend/
COPY . .
RUN gradle build --no-daemon


# Stage 2: Create a minimal JRE image
FROM eclipse-temurin:21-jre-jammy
ENV JAR_NAME=app.jar
ENV APP_HOME=/dm-weather-app-backend/
WORKDIR /dm-weather-app-backend/
EXPOSE 8080
COPY --from=build $APP_HOME .
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME




