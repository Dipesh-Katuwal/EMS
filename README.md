# Employee Management System

A small full-stack revision project for practicing how a React frontend communicates with a Java backend. The app supports basic employee management, with most of the project structure and learning focus on the backend.

## What it does

- Lists employees and lets you create, view, update, and delete employee records.
- Sends JSON requests from React to a REST API built with Spring Boot.
- Stores employee data in MySQL through Spring Data JPA.

## Tech stack

| Area     | Technologies |
| Backend  | Java 25, Spring Boot, Spring Web MVC, Spring Data JPA, Maven |
| Database | MySQL |
| Frontend | React, Vite, React Router, Axios, Tailwind CSS |

## Project structure

```text
.
├── spring_backend/       # Spring Boot REST API and persistence layer
└── react_frontend/       # React user interface
```

The backend is organized into a simple controller → service → repository flow:

- **Controller** handles HTTP requests and returns API responses.
- **Service** contains employee operations and maps between DTOs and entities.
- **Repository** uses Spring Data JPA to access the database.
- **Entity and DTO** represent the persisted employee and the API data shape.

## Run locally

### 1. Prepare MySQL

Create a MySQL database:

```sql
CREATE DATABASE ems;
```

The backend connects to `jdbc:mysql://localhost:3306/ems` by default. Configure your local database username and password before starting the backend. Prefer environment variables or a local, uncommitted configuration file for credentials; do not push passwords to GitHub.

Spring Boot environment variable names:

```text
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
```

### 2. Start the backend

Requirements: JDK 25 and MySQL.

From the repository root, in PowerShell:

```powershell
cd spring_backend
.\mvnw.cmd spring-boot:run
```

The API runs at `http://localhost:8080` by default.

### 3. Start the frontend

Requirements: Node.js and npm.

Open another terminal:

```powershell
cd react_frontend
npm install
npm run dev
```

Open the local URL printed by Vite (usually `http://localhost:5173`). The frontend's API client currently targets `http://localhost:8080/api`.

For frontend-specific setup and scripts, see [react_frontend/README.md](./react_frontend/README.md).

## Employee API

All endpoints are prefixed with `/api/employees`. The API uses the `EmployeeDto` JSON shape:

```json
{
  "id": 1,
  "firstName": "Ada",
  "lastName": "Lovelace",
  "email": "ada@example.com"
}
```

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/api/employees/getEmployees` | List employees |
| `GET` | `/api/employees/getEmployee/{id}` | Get one employee |
| `POST` | `/api/employees/createEmployee` | Create an employee |
| `PUT` | `/api/employees/updateEmployee/{id}` | Update an employee |
| `DELETE` | `/api/employees/deleteEmployee/{id}` | Delete an employee |

Example create request:

```json
{
  "firstName": "Ada",
  "lastName": "Lovelace",
  "email": "ada@example.com"
}
```

## Useful commands

Run backend tests:

```powershell
cd spring_backend
.\mvnw.cmd test
```

Build and lint the frontend:

```powershell
cd react_frontend
npm run build
npm run lint
```

## Learning goals

- Build REST endpoints with Spring MVC.
- Separate controller, service, repository, entity, and DTO responsibilities.
- Persist data with Spring Data JPA and MySQL.
- Connect a React app to a backend API using Axios.
- Practice end-to-end CRUD flows across a frontend and backend.
