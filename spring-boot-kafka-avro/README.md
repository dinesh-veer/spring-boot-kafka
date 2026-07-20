# Spring Boot Kafka Protobuf

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Apache Kafka](https://img.shields.io/badge/Apache-Kafka-black.svg)](https://kafka.apache.org/)
[![Protocol Buffers](https://img.shields.io/badge/Protocol-Buffers-blue.svg)](https://protobuf.dev/)
[![Schema Registry](https://img.shields.io/badge/Confluent-Schema%20Registry-blue.svg)](https://docs.confluent.io/platform/current/schema-registry/)
[![Docker](https://img.shields.io/badge/Docker-Ready-blue.svg)](https://www.docker.com/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

A Spring Boot sample demonstrating **Apache Kafka** integration with **Google Protocol Buffers (Protobuf)** and **Confluent Schema Registry**. This project showcases publishing and consuming **String** and **Protobuf** messages using Spring for Apache Kafka with automatic schema registration and validation.

---

## Features

- Apache Kafka Producer & Consumer
- Google Protocol Buffers Integration
- Confluent Schema Registry
- Kafka UI Support
- String Message Producer
- Protobuf Message Producer
- String Message Consumer
- Protobuf Message Consumer
- Automatic Schema Registration
- REST API Integration
- DTO to Protobuf Mapping
- Docker Compose Support
- Production Ready Configuration
- Maven Build Support

---

## Technology Stack

- Java 21
- Spring Boot
- Spring for Apache Kafka
- Apache Kafka
- Google Protocol Buffers
- Confluent Schema Registry
- Docker & Docker Compose
- Kafka UI
- Maven

---

## Project Structure

```text
spring-boot-kafka-protobuf
│
├── docker-compose.yml
├── pom.xml
├── README.md
├── HELP.md
│
├── docs
│   ├── postman
│   └── screenshots
│
├── src
│   ├── main
│   │
│   ├── java
│   │   └── com.dinesh.springbootkafkaprotobuf
│   │       ├── config
│   │       ├── consumer
│   │       ├── controller
│   │       ├── dto
│   │       ├── model
│   │       ├── producer
│   │       └── SpringBootKafkaProtobufApplication.java
│   │
│   ├── proto
│   │   └── order.proto
│   │
│   └── resources
│       └── application.properties
│
└── target
```

---

## Architecture

```text
                REST Client
                     │
                     ▼
        Spring Boot Application
                     │
      ┌──────────────┴──────────────┐
      │                             │
      ▼                             ▼
 String Producer             Protobuf Producer
      │                             │
      └──────────────┬──────────────┘
                     ▼
               Apache Kafka
                     │
                     ▼
            Schema Registry
                     │
                     ▼
      String & Protobuf Consumers
```

---

## Protobuf Schema

The project uses Google Protocol Buffers for efficient binary serialization.

```proto
syntax = "proto3";

package com.dinesh.springbootkafkaprotobuf.model;

message OrderMessage {

  string orderId = 1;

  string product = 2;

  int32 quantity = 3;

}
```

---

## REST APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/?message=Hello Kafka` | Send String Message |
| POST | `/json` | Send Protobuf Message |

---

## Sample Requests

### Send String Message

```http
GET /?message=Hello Kafka
```

### Send Protobuf Message

```http
POST /json
Content-Type: application/json

{
  "orderId": "ORD-1001",
  "product": "Laptop",
  "quantity": 2
}
```

---

## Kafka Topics

| Topic | Description |
|---------|-------------|
| demo-topic | String Messages |
| protobuf-topic | Protobuf Messages |

---

## Default URLs

| Service | URL |
|----------|-----|
| Spring Boot | http://localhost:8080 |
| Kafka UI | http://localhost:8090 |
| Schema Registry | http://localhost:8081 |

---

## Running the Project

### Clone Repository

```bash
git clone https://github.com/dinesh-veer/spring-boot-kafka.git
```

### Start Kafka Environment

```bash
docker compose up -d
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

---

# Screenshots

## Kafka UI Dashboard

![Dashboard](screenshots/apache-kafka-ui-dashboard.png)

---

## Kafka Topics

![Topics](screenshots/apache-kafka-ui-topic-dashboard.png)

---

## Schema Registry

![Schema Registry](screenshots/schema-registry-for-avro.png)

---

## String message sending and receiving

![String Message](screenshots/string-message-sending-receiving.png)

---
## Json message sending

![Json Message](screenshots/json-message-sending-receiving.png)

---

## Repository Highlights

- Spring Boot Kafka Integration
- Google Protocol Buffers
- Confluent Schema Registry
- Kafka Producer
- Kafka Consumer
- REST APIs
- Docker Ready
- Kafka UI
- Automatic Schema Registration
- Schema Evolution Support
- Clean Project Structure
- Easy to Extend

---

## Documentation

Additional documentation is available in the **docs** folder.

- HELP.md
- Docker Configuration
- Postman Collection
- Screenshots
- Protobuf Schema

---

## Contributing

Contributions are welcome.

1. Fork the repository
2. Create a feature branch

```bash
git checkout -b feature/new-feature
```

3. Commit your changes

```bash
git commit -m "Add new feature"
```

4. Push to GitHub

```bash
git push origin feature/new-feature
```

5. Open a Pull Request.

---

## Contact

**Dinesh Veer**

- GitHub: https://github.com/dinesh-veer
- Email: dveer123@hotmail.com

---

## License

Distributed under the MIT License. See the **LICENSE** file for more information.

---

⭐ If you found this project helpful, please consider giving it a **Star** on GitHub!
