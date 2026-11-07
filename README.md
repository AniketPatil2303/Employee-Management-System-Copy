# Employee Management System - Spring Boot

REST API for employee CRUD operations.

## Stack
Java 17, Spring Boot 3, Spring Web, Spring Data JPA, Hibernate, PostgreSQL and Maven.

## Requirements and setup
1. Install JDK 17+, Maven and PostgreSQL.
2. Create database: `CREATE DATABASE employee_db;`
3. Set `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` environment variables, or adjust `application.properties` for local use. Do not commit real credentials.
4. Run: `mvn spring-boot:run`
5. API base URL: `http://localhost:8080/api/employees`

## Endpoints
- `GET /api/employees` - list all employees
- `GET /api/employees/{id}` - get one employee
- `POST /api/employees` - create
- `PUT /api/employees/{id}` - update
- `DELETE /api/employees/{id}` - delete

Example POST JSON:
```json
{"name":"Aarav Patil","email":"aarav@example.com","department":"Engineering","salary":35000}
```
Test endpoints with Postman. This is a learning project; add authentication, authorization and automated tests before production use.
