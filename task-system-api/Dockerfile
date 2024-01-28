#FROM openjdk:17-jdk-alpine
#RUN mvn clean package -DskipTests
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]


# Use an official Maven image as the build stage
FROM maven:3.8.4-openjdk-17 AS build

# Copy the pom.xml file to download dependencies
COPY pom.xml .
RUN mvn -B dependency:resolve dependency:resolve-plugins

# Copy the source code and build the application
COPY src ./src
RUN mvn package

# Create the final image using a lightweight base image
FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar

# Copy the generated JAR file from the build stage
COPY --from=build /app/${JAR_FILE} app.jar

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]