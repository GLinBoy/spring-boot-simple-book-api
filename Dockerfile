FROM eclipse-temurin:20-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY build/libs/SpringBootBook-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
