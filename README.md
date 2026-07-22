# Spring Boot Kafka Examples

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk" />
  <img src="https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/Apache-Kafka-black?style=for-the-badge&logo=apachekafka" />
  <img src="https://img.shields.io/badge/Docker-Compose-blue?style=for-the-badge&logo=docker" />
  <img src="https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven" />
  <img src="https://img.shields.io/badge/License-MIT-green?style=for-the-badge" />
</p>

A collection of **Spring Boot Kafka** examples demonstrating different message serialization techniques using **Apache Kafka**, **Spring for Apache Kafka**, and **Docker Compose**.

This repository contains multiple independent sample applications ranging from simple String/JSON messaging to enterprise-grade serialization using **Google Protocol Buffers (Protobuf)** and **Apache Avro** with **Confluent Schema Registry**.

---

# Repository Modules

| Project | Description |
|----------|-------------|
| **spring-boot-kafka-simple** | Kafka Producer & Consumer using String and JSON messages |
| **spring-boot-kafka-protobuf** | Kafka integration using Google Protocol Buffers (Protobuf) and Schema Registry |
| **spring-boot-kafka-avro** | Kafka integration using Apache Avro and Confluent Schema Registry |

---

# Features

- Apache Kafka Producer
- Apache Kafka Consumer
- Spring Boot REST APIs
- String Message Publishing
- JSON Message Publishing
- Google Protocol Buffers
- Apache Avro
- Confluent Schema Registry
- Docker Compose Setup
- Kafka UI Dashboard
- AKHQ Dashboard
- Schema Evolution Examples
- Serialization & Deserialization
- Multiple Kafka Templates
- Multiple Consumer Factories
- Production Ready Configuration
- Maven Build Support

---

# Technology Stack

| Technology | Version |
|------------|----------|
| Java | 21 |
| Spring Boot | 4.x |
| Spring Kafka | Latest |
| Apache Kafka | Latest |
| Google Protocol Buffers | Latest |
| Apache Avro | Latest |
| Confluent Schema Registry | Latest |
| Docker Compose | Latest |
| Maven | Latest |

---

# Repository Structure

```text
spring-boot-kafka
│
├── spring-boot-kafka-simple
│   ├── README.md
│   ├── HELP.md
│   ├── compose.yaml
│   └── src
│
├── spring-boot-kafka-protobuf
│   ├── README.md
│   ├── HELP.md
│   ├── docker-compose.yml
│   └── src
│
├── spring-boot-kafka-avro
│   ├── README.md
│   ├── HELP.md
│   ├── docker-compose.yml
│   └── src
│
└── README.md
```

---

# Project Overview

## 1. Spring Boot Kafka Simple

A beginner-friendly Kafka example demonstrating:

- String Producer & Consumer
- JSON Producer & Consumer
- Spring Boot REST APIs
- Docker Compose
- Kafka UI
- AKHQ Dashboard

📂 **Project:** `spring-boot-kafka-simple`

---

## 2. Spring Boot Kafka Protobuf

Demonstrates Kafka integration using **Google Protocol Buffers**.

Features include:

- Protobuf Serialization
- Protobuf Deserialization
- Confluent Schema Registry
- Kafka Producer
- Kafka Consumer
- DTO to Protobuf Mapping
- Kafka UI

📂 **Project:** `spring-boot-kafka-protobuf`

---

## 3. Spring Boot Kafka Avro

Demonstrates Kafka integration using **Apache Avro**.

Features include:

- Apache Avro Serialization
- Apache Avro Deserialization
- Confluent Schema Registry
- Kafka Producer
- Kafka Consumer
- Avro Schema Management
- Kafka UI

📂 **Project:** `spring-boot-kafka-avro`

---

# Serialization Comparison

| Feature | Simple | Protobuf | Avro |
|----------|:------:|:--------:|:----:|
| String Messages | ✅ | ❌ | ❌ |
| JSON Messages | ✅ | ❌ | ❌ |
| Google Protocol Buffers | ❌ | ✅ | ❌ |
| Apache Avro | ❌ | ❌ | ✅ |
| Schema Registry | ❌ | ✅ | ✅ |
| Kafka Producer | ✅ | ✅ | ✅ |
| Kafka Consumer | ✅ | ✅ | ✅ |
| Docker Support | ✅ | ✅ | ✅ |
| Kafka UI | ✅ | ✅ | ✅ |
| REST APIs | ✅ | ✅ | ✅ |

---

# Architecture

```text
                REST Client
                     │
                     ▼
          Spring Boot Applications
                     │
        ┌────────────┼────────────┐
        │            │            │
        ▼            ▼            ▼
     Simple      Protobuf      Avro
        │            │            │
        └────────────┼────────────┘
                     ▼
               Apache Kafka
                     │
          ┌──────────┴──────────┐
          ▼                     ▼
     Schema Registry        Kafka UI
                     │
                     ▼
                Kafka Consumers
```

---

# Running the Projects

Clone the repository

```bash
git clone https://github.com/dinesh-veer/spring-boot-kafka.git
```

Navigate to any project

```bash
cd spring-boot-kafka/spring-boot-kafka-simple
```

or

```bash
cd spring-boot-kafka/spring-boot-kafka-protobuf
```

or

```bash
cd spring-boot-kafka/spring-boot-kafka-avro
```

Start Kafka services

```bash
docker compose up -d
```

Build

```bash
mvn clean install
```

Run

```bash
mvn spring-boot:run
```

---

# Documentation

Each project contains its own documentation.

| Project | Documentation |
|----------|---------------|
| spring-boot-kafka-simple | README.md, HELP.md |
| spring-boot-kafka-protobuf | README.md, HELP.md |
| spring-boot-kafka-avro | README.md, HELP.md |

---

# Screenshots

Each module contains screenshots demonstrating:

- Kafka UI Dashboard
- AKHQ Dashboard
- Kafka Topics
- Schema Registry
- Producer Logs
- Consumer Logs
- REST API Execution

Example location:

```text
docs/
└── screenshots/
```

---

# Future Enhancements

- Kafka Streams
- Kafka Connect
- Dead Letter Queue (DLQ)
- Retry Mechanism
- Batch Consumers
- Transactions
- Exactly Once Delivery
- Kafka Security (SSL/SASL)
- Micrometer Metrics
- OpenTelemetry Tracing
- Grafana Monitoring
- Prometheus Integration

---

# Contributing

Contributions are welcome!

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

# Support

If you found this repository useful:

⭐ Star this repository

🐛 Report Issues

💡 Suggest Improvements

---

# Contact

## Dinesh Veer

- GitHub: https://github.com/dinesh-veer
- Email: dveer123@hotmail.com

---

# License

This project is licensed under the MIT License.

See the **LICENSE** file for more information.