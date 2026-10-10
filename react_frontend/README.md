# React Frontend

The React client for the Employee Management System. It uses Vite for local development and Axios to call the Spring Boot API.

## Requirements

- Node.js and npm
- The Spring Boot backend running at `http://localhost:8080`
- A MySQL database configured for the backend

## Install and run

From this directory:

```powershell
npm install
npm run dev
```

Open the local URL printed by Vite (usually `http://localhost:5173`).

The Axios client currently uses `http://localhost:8080/api` as its base URL. Employee API calls are defined in `src/api/employeeAPI.js`.

## Available scripts

| Command | Description |
| --- | --- |
| `npm run dev` | Start the Vite development server |
| `npm run build` | Build the frontend for production |
| `npm run preview` | Preview the production build locally |
| `npm run lint` | Run Oxlint |

For backend setup, API endpoints, and the full-stack run instructions, see the [project README](../README.md).
