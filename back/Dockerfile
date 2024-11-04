FROM maven:3.9.9-eclipse-temurin-21-alpine as maven-builder

# Copy the source code and pom.xml
COPY src /app/src
COPY pom.xml /app

# Build the application
RUN mvn -f /app/pom.xml clean package -DskipTests

# Use OpenJDK for the runtime image
FROM openjdk:21-jdk-slim

# Set default environment variables
ENV SERVER_PORT=8080

# Copy the built JAR from the maven-builder stage
COPY --from=maven-builder /app/target/somosafac-0.0.1-SNAPSHOT.jar /app-service/somosafac-0.0.1-SNAPSHOT.jar

WORKDIR /app-service

# Expose the port your application runs on
EXPOSE ${SERVER_PORT}

# Command to run the application
ENTRYPOINT ["java","-jar","somosafac-0.0.1-SNAPSHOT.jar"]