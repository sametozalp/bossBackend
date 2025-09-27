# BossBackend

## 📌 About the Project
BossBackend is a backend application developed with **Java 21** and **Spring Boot**.  
It features **JWT-based authentication**, **role-based authorization**, a **layered architecture**, and uses **PostgreSQL** as the database.

---

## 🛠️ Technologies Used
- **Java 21**
- **Spring Boot** (Web, Data JPA, Security, Validation)
- **PostgreSQL**
- **JWT** (`io.jsonwebtoken`)
- **Lombok**
- **Springdoc OpenAPI** (Swagger UI)
- **Maven**

---

## 📂 Project Structure
- **api/controllers** → REST API endpoints  
- **business** → Business logic and services  
- **dataAccess** → Repositories and database access  
- **entities** → Entity classes  
- **common** → Shared utilities, helpers, security  
- **exception/handler** → Exception handling  

---

## 📖 API Documentation
- Swagger UI:  
  - `/swagger-ui.html`  
  - `/swagger-ui/index.html`  

---

## 🔑 Core API Flows
- User registration, login, and token refresh  
- Role-based authorization  
- Secure endpoint access with JWT  
