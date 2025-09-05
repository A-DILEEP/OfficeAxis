# Step 1: Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build

LABEL authors="DILEEP"

WORKDIR /app

# Copy everything including pom.xml and src
COPY . .

# Run Maven build (skip tests to avoid test-related failures)
RUN mvn clean package -DskipTests

# Step 2: Runtime stage
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy jar file from previous stage
COPY --from=build /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
