FROM eclipse-temurin:20-jre-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/SpringBootBook-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]
