# Real-Time Banking

A Spring Boot microservice project for real-time banking operations using Kafka, PostgreSQL, Docker, and supporting tools.

## Features

- **Account Service**: Java Spring Boot REST API for account management.
- **Kafka & Zookeeper**: Real-time event streaming and messaging.
- **PostgreSQL**: Persistent data storage.
- **Kafka UI**: Web interface to monitor Kafka topics and messages.
- **pgAdmin**: Web interface to manage PostgreSQL.
- **Docker Compose**: Orchestrates all services for local development.

## Architecture

- `accountservice`: Spring Boot app exposing REST endpoints and producing/consuming Kafka events.
- `postgres`: Database for storing account data.
- `kafka` & `zookeeper`: Messaging backbone.
- `kafka-ui`: Web UI for Kafka.
- `pgadmin`: Web UI for PostgreSQL.

## Prerequisites

- Docker & Docker Compose
- Java 17+
- Git

## Getting Started

1. **Clone the repository**

   ```sh
   git clone https://github.com/raghul-das/Real-Time-Banking.git
   cd Real-Time-Banking

2. **Build and start all services**  
    ```sh
   docker-compose up --build

3. **Access the services**

   - Account Service API: [http://localhost:8080](http://localhost:8080)
   - Kafka UI: [http://localhost:8081](http://localhost:8081)
   - pgAdmin: [http://localhost:5050](http://localhost:5050)
   - PostgreSQL: Connect using pgAdmin with host `postgres`, port `5432`

## API Documentation

### Create Account

- **Endpoint:** `POST /api/accounts`
- **Request Body:**
  ```json
  {
    "accountNumber": "1234567890",
    "accountHolder": "Raghul Das",
    "balance": 150000.0
  }
- **Response:** Created account object

### Get All Accounts
- **Endpoint:** `GET /api/accounts`
- **Response:** List of accounts

### Get Account by ID
- **Endpoint:** `GET /api/accounts/{id}`
- **Response:** Account object

### Update Account
- **Endpoint:** `PUT /api/accounts/{id}`
- **Request Body:** Same as create
- **Response:** Updated account object

### Delete Account
- **Endpoint:** `DELETE /api/accounts/{id}`
- **Response:** HTTP 204 No Content

## Technical Details

- **Spring Boot**: Handles REST API and Kafka integration.
- **Kafka**: Used for event-driven communication.
- **PostgreSQL**: Stores account data.
- **Docker Compose**: Manages multi-container setup.

---

## Pushing Changes to Docker Hub


1. **Login to Docker Hub**
   ```sh
   docker login
2. **Build the Docker image**
   ```sh
   docker tag real-time-banking-app <your-dockerhub-username>/real-time-banking-app:latest
3. **Push the image to Docker Hub**
   ```sh
   docker push <your-dockerhub-username>/real-time-banking-app:latest