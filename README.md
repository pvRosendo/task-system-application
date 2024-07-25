# Task System Application

## Simplify Backend Challenge

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Render](https://img.shields.io/badge/Render-%46E3B7.svg?style=for-the-badge&logo=render&logoColor=white)



Este projeto é uma API construída, principalmente, usando **Java, Java Spring e PostgreSQL**.

A API foi desenvolvida com o objetivo de aplicar os estudos e demonstrar como resolver o [Simplify Backend Challenge](https://github.com/simplify-tec/desafio-junior-backend-simplify). Após atender a todos os requisitos fui melhorando e aplicando novas funcionalidades para aprimorar e visualizar os conhecimentos que obtive através dos estudos.

Além disso, avançando ainda mais, também foi realizada documentação utilizando **Swagger** e teste de deploy no [Render](https://render.com) com Docker.

## Table of Contents

- [Instalação](#instalação)
- [Uso](#uso)
- [Endpoints da API](#endpoints-da-api)

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/pvRosendo/task-system-application.git
```

2. Instale as dependências e faça o build do projeto com Maven

```
$ ./mvnw clean package
```
3. Crie uma configuração com as variáveis de ambiente de tempo de execução usadas no `application.properties`

```properties
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
```
4. Execute a aplicação:

```
$ java -jar /task-system-api/target/toDoList-0.0.1-SNAPSHOT.jar
```

## Uso

1. Start a aplicação com Maven;
2. A API vai estar acessível no host pré-determinado;
3. A documentação da API vai estar acessível adicionando "/swagger-ui.html" no path.

## Endpoints da API
A API possui os seguintes endpoints:

| rota               | descrição                                          
|----------------------|-----------------------------------------------------
| <kbd>GET :8080/api/tasks</kbd>      |  Retorna todas as tasks (issue: sem paginação)
| <kbd>GET :8080/api/tasks/{id}</kbd>      |  Retorna uma única task
| <kbd>POST :8080/api/tasks</kbd>     |  Cria uma nova tarefa
| <kbd>PUT :8080/api/tasks/{id}</kbd>      |   Atualiza uma tarefa
| <kbd>DELETE :8080/api/tasks/{id}</kbd>   |  Deleta uma tarefa


## Deploy no Render

Ambos os serviços foram hospedados no Render para testar e treinar deploy de aplicativos. Foi utilizada uma dockerização da aplicação e sua imagem foi utilizada para a API.

![image](https://github.com/pvRosendo/task-system-application/assets/111819809/8fe17885-e338-4169-99ef-e4d6aaefd364)
