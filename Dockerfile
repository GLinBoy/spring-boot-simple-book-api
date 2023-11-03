FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /workspace/app

COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY src src

RUN ./gradlew build -x test
RUN mkdir -p build/libs/dependency && (cd build/libs/dependency; jar -xf ../SpringBootBook-*.jar)


FROM eclipse-temurin:20-jre-alpine AS runner
VOLUME /tmp

RUN addgroup -S app && adduser -S spring-app -G app
USER spring-app

ARG DEPENDENCY=/workspace/app/build/libs/dependency
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.glinboy.test.springboot.book.SpringBootBookApplicationKt"]
