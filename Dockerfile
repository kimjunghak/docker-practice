FROM openjdk:11 AS builder
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw clean package -Dmaven.test.skip=true

FROM openjdk:11
COPY --from=builder target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]