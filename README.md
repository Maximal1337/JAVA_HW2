# HW_2 - Network Programming Assignment

Java networking assignment implementing TCP and UDP client-server applications.

## Project Structure
```
HW_2/
└── src/
    ├── TCP/
    │   ├── CalculatorTCPClient.java
    │   └── CalculatorTCPServer.java
    └── UDP/
        ├── QuoteUDPClient.java
        └── QuoteUDPServer.java
```

## Components

### TCP Calculator
A simple calculator application using TCP protocol for client-server communication.

- **CalculatorTCPServer.java** - Server that accepts mathematical operations
- **CalculatorTCPClient.java** - Client that sends calculations to the server

### UDP Quote Server
A quote delivery system using UDP protocol.

- **QuoteUDPServer.java** - Server that sends random motivational quotes
- **QuoteUDPClient.java** - Client that requests quotes from the server

## How to Run

### TCP Calculator
1. Run the server: `java TCP.CalculatorTCPServer`
2. Run the client: `java TCP.CalculatorTCPClient`

### UDP Quote Server
1. Run the server: `java UDP.QuoteUDPServer`
2. Run the client: `java UDP.QuoteUDPClient`

## Requirements

- Java 8 or higher
- JRE System Library [JavaSE-21]
