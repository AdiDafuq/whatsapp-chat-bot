# WhatsApp Bot Simulator

A simple WhatsApp chatbot backend simulation built using Java, Spring Boot, and Maven.

## Project Overview

This project simulates a WhatsApp chatbot backend.

The application exposes REST API endpoints that receive messages and return intelligent predefined responses.

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Maven
- SLF4J Logging
- VS Code
- Postman
- GitHub
- Render

## API Endpoints

### GET /

Health check endpoint.

#### Response

```text
WhatsApp Bot Simulator is running!
```

---

### POST /webhook

Receives incoming messages and returns a chatbot response.

#### Request Body

```json
{
  "sender": "Adi",
  "message": "Hi"
}
```

#### Sample Response

```json
{
  "reply": "Hi there! How can I help?",
  "timestamp": "2026-04-26T02:29:37.921880241"
}
```

---

### GET /webhook

Webhook verification endpoint used by WhatsApp Cloud API.

Example:

```text
/webhook?hub.mode=subscribe&hub.verify_token=mySecretToken&hub.challenge=123
```

Response:

```text
123
```

## Chatbot Logic

### Greeting Messages

Input:

```text
hi
hello
```

Possible Replies:

```text
Hey! What's up?
Hi there! How can I help?
Hello! Need something?
```

### Help Messages

Input:

```text
help
```

Reply:

```text
You can say hi, ask questions, or just chat.
```

### Suggestion Messages

Input:

```text
what to do
tell me
```

Reply:

```text
Try saying 'hi' or ask me something simple. I'm still learning.
```

### Default Response

For all other messages:

```text
You said: <message>. I'm still learning.
```

## Running Locally

### Clone Repository

```bash
git clone <repository-url>
```

### Navigate to Project

```bash
cd whatsapp-bot-simulator
```

### Run Application

```bash
mvn spring-boot:run
```

Application runs at:

```text
http://localhost:8080
```

## Testing with Postman

### URL

```text
POST http://localhost:8080/webhook
```

### Headers

```text
Content-Type: application/json
```

### Body

```json
{
  "sender": "Adi",
  "message": "hello"
}
```

### Response

```json
{
  "reply": "Hello! Need something?",
  "timestamp": "2026-04-26T02:29:37.921880241"
}
```

## Deployment

The application has been deployed on Render using Docker.

### Live URL

```text
https://whatsapp-chat-bot-j6m7.onrender.com
```

### Test Endpoint

```text
POST https://whatsapp-chat-bot-j6m7.onrender.com/webhook
```

## WhatsApp Cloud API Integration

The project was connected with Meta WhatsApp Cloud API.

Implemented:

- Webhook verification endpoint
- Public callback URL deployment
- WhatsApp Cloud API webhook configuration
- Message receiving infrastructure

## Logging

Incoming messages and generated replies are logged.

Example:

```text
Received message from Adi: hello
Reply sent to Adi: Hi there! How can I help?
```

## Assignment Requirements Covered

- REST API Endpoint
- JSON Request Handling
- Response Generation
- Logging
- GitHub Repository
- Public Deployment
- Webhook Verification
- Postman Testing
- WhatsApp Cloud API Integration

## Author

Aditya Pratap

Built as part of an internship assignment using Java Spring Boot.
