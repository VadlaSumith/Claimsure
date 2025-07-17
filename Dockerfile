# Step 1: Use Maven image to build the project
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight JDK to run the app
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/claimsure-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

