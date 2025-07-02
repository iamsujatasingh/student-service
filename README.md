# 🧑‍🎓 Student Service - Spring Boot Microservice

This Spring Boot microservice manages students and their enrolled courses. It supports JPA relationships and demonstrates lazy vs eager loading, as well as pessimistic locking.

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
- GitHub Actions (CI/CD)
- Lombok

---

## 🧪 Build & Run Locally

```bash
# Build JAR
mvn clean package

# Build Docker image
docker build -t student-app .

# Run the container
docker run -p 8080:8080 student-app
📦 Docker Hub

Image is published to Docker Hub:
👉 iamsujata/student-app

Pull it directly:

docker pull iamsujata/student-app
docker run -p 8080:8080 iamsujata/student-app
🔁 CI/CD

CI/CD pipeline is configured using GitHub Actions. On every push to main, it:

Builds the project
Creates a Docker image
Pushes it to Docker Hub
See .github/workflows/ci-cd.yml for details.