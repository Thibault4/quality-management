# Java builder
FROM eclipse-temurin:17-jdk-alpine as builder

COPY . /app
WORKDIR /app
RUN apk update && apk add dos2unix
RUN dos2unix mvnw && chmod 700 mvnw
RUN ./mvnw clean install package -DskipTests

# Java server
FROM eclipse-temurin:17-jdk-alpine

ARG JARSRC=tournament-manager-0.0.1-SNAPSHOT.jar
ENV JARDST /app/app.jar

RUN apk update && apk add curl jq

COPY --from=builder /app/target/$JARSRC $JARDST

HEALTHCHECK --interval=10s --timeout=15s --start-period=30s \
    CMD curl --silent --fail http://localhost:8080/actuator/health  |jq --exit-status '.status == "UP"'|| exit 1  

ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=prod,actuator -jar $JARDST

EXPOSE 8080
ENV DATABASE_HOST DATABASE_USERNAME DATABASE_PASSWORD DATABASE_PORT DATABASE_NAME