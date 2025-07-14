FROM maven:3.8.8-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /action
COPY --from=builder /app/target/pr-labeler.jar ./pr-labeler.jar
ENTRYPOINT ["java","-jar","/action/pr-labeler.jar"]
