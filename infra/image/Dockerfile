FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
WORKDIR "/task-system-api"
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:17-jdk-alpine

EXPOSE 80

COPY --from=build /task-system-api/target/toDoList-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]