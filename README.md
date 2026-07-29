# 🚀 Real-Time Ad Serving Platform

A backend application built with **Java 17** and **Spring Boot** that simulates a real-time advertisement serving system. The platform manages advertising campaigns and serves the highest-priority advertisement based on user demographics such as **country** and **age**.

---

## 📌 Features

- Campaign Management (CRUD APIs)
- Real-Time Ad Serving API
- Campaign Priority Selection
- PostgreSQL Database Integration
- Swagger (OpenAPI) Documentation
- Docker Support
- Global Exception Handling
- Layered Architecture (Controller → Service → Repository)

---

## 🛠 Tech Stack

- Java 17
- Spring Boot 3.5
- Spring Data JPA
- PostgreSQL
- Docker
- Swagger (OpenAPI)
- Maven
- Lombok
- Git & GitHub

---

## 🏗 Architecture

> *(Add `architecture.png` here after creating the screenshots folder.)*

```text
Client
   │
   ▼
Spring Boot REST API
   │
   ▼
Campaign Service
   │
   ├── PostgreSQL
   └── Ad Selection Logic
```

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/campaigns` | Create Campaign |
| GET | `/api/campaigns` | Get All Campaigns |
| GET | `/api/campaigns/{id}` | Get Campaign by ID |
| PUT | `/api/campaigns/{id}` | Update Campaign |
| DELETE | `/api/campaigns/{id}` | Delete Campaign |
| GET | `/api/campaigns/ads` | Serve Best Matching Advertisement |

---

## 📷 Screenshots

### Architecture

![alt text](<realTime ad serving platform.png>)

### Swagger UI

![alt text](swagger-ad.png)

### Create Campaign

![alt text](image.png)

### Ad Serving API

_![alt text](serve-ad.png)


---

## 🚀 Future Enhancements

- Redis Caching
- JWT Authentication
- Campaign Analytics
- Click & Impression Tracking
- Kubernetes Deployment

---

## 👨‍💻 Author

**Pavithra**

GitHub: https://github.com/Pavithrajeni