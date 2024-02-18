# Task System Application

## Simplify Backend Challenge

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Render](https://img.shields.io/badge/Render-%46E3B7.svg?style=for-the-badge&logo=render&logoColor=white)



This project is an API built using **Java, Java Spring, and PostgreSQL**.

The API was developed with the aim of applying the studies and demonstrating how to solve the [Simplify Backend Challenge](https://github.com/simplify-tec/desafio-junior-backend-simplify), but after meeting the requirements it was continued in order to improve and apply the new studies that I am obtaining. 

Going beyond, documentation was also carried out using **Swagger** and deployment testing with [Render](https://render.com) through the [Docker image](). 

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/pvRosendo/task-system-application.git
```

2. Install dependencies and construct the project with Maven

```
$ ./mvnw clean package
```
3. Executar a aplicação:

```
$ java -jar /task-system-api/target/toDoList-0.0.1-SNAPSHOT.jar
```

4. Create a configuration with your runtime environment variables that are used in `application.properties`

```properties
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
```

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080
3. The API documentation will be accessible at http://localhost:8080/swagger-ui.html

## API Endpoints
The API provides the following endpoints:

**API PRODUCT**
```markdown
POST /api/tasks - Create a new task
GET /api/tasks - Retrieve all tasks
GET /api/tasks/{id} - Get a unique task
PUT /api/tasks/{id} - Updates a task
DELETE /api/tasks/{id} - Delete a task
```

| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET :8080/api/tasks</kbd>      | retrieves task info, see [response details](#get-detail)
| <kbd>POST :8080/api/tasks</kbd>     |  insert task into the api, see [request details](#post-detail)
| <kbd>PUT :8080/api/tasks/{id}</kbd>      |  update task into the api, see [request details](#put-detail)
| <kbd>DELETE :8080/api/tasks/{id}</kbd>   | delete task, see [request details](#delete-detail)


<h3 id="get-detail">GET</h3>

**RESPONSE**
```json
{ 
  "nameTask": "string",
  "description": "string",
  "priority": integer,
  "status": "string"
}
```

<h3 id="post-detail">POST</h3>

**REQUEST**
```json
{
  "nameTask": "string",
  "description": "string",
  "priority": integer,
  "status": "string"
}
```

<h3 id="put-detail">PUT</h3>

**REQUEST**
https://localhost:8080/api/tasks/{id}
```json
{
  "nameTask": "string",
  "description": "string",
  "priority": integer,
  "status": "string"
}
```

**RESPONSE**
```json
{
  "nameTask": "string2",
  "description": "string2",
  "priority": integer,
  "status": "string2"
}
```

<h3 id="delete-detail">DELETE</h3>

**REQUEST**
```
https://localhost:8080/api/tasks/{id}
```
## Deploy on Render

Both services were hosted on Render in order to test and train application deployments. A dockerization of the application was used and its image was used for the api.

![image](https://github.com/pvRosendo/task-system-application/assets/111819809/8fe17885-e338-4169-99ef-e4d6aaefd364)

## Contributing

If you find any issues or have suggestions for improvements, please open a suggestion.
