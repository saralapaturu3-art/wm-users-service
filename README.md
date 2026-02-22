# wm-users-service

Spring Boot + MySQL REST API for table `wm_users`.

## 1) Database
```sql
CREATE DATABASE wm_db;

CREATE TABLE wm_users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE,
    phone_number VARCHAR(20) NOT NULL,
    password VARCHAR(255) NOT NULL
);
```

Update `src/main/resources/application.yml` with your MySQL username/password.

## 2) Run
```bash
mvn spring-boot:run
```

## 3) API Endpoints
Base: `http://localhost:8080/api/v1/users`

### Create user
```bash
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{
    "firstName":"Chandra",
    "lastName":"Gulla",
    "email":"sekhar@example.com",
    "phoneNumber":"2145551234",
    "password":"MySecret@123"
  }'
```

### Get user by id
```bash
curl http://localhost:8080/api/v1/users/1
```

### List users
```bash
curl http://localhost:8080/api/v1/users
```

### Delete user
```bash
curl -X DELETE http://localhost:8080/api/v1/users/1
```

## Notes
- Password is stored as BCrypt hash.
- API never returns password.
