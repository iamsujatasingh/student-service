# 🧑‍🎓 Student Service - Spring Boot App

This Spring Boot microservice manages students and their courses.

---

## 🚀 API Endpoints

| Method | Path              | Description                                 |
|--------|-------------------|---------------------------------------------|
| GET    | `/api/join`       | Fetch students with JOIN (lazy loading)     |
| GET    | `/api/join-fetch` | Fetch students with JOIN FETCH (eager load) |
| GET    | `/api/lock/test1` | Simulate pessimistic locking (Thread 1)     |
| GET    | `/api/lock/test2` | Simulate pessimistic locking (Thread 2)     |

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Lombok

---

## 🧪 Build & Run

```bash
mvn clean package
docker build -t student-app .
docker run -p 8080:8080 student-app
