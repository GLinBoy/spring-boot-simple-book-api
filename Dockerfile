FROM eclipse-temurin:20-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/SpringBootBook-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
