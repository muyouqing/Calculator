
# Calculator Service

A Java-based calculator service that supports basic arithmetic operations such as addition, subtraction, multiplication, division, and chaining multiple operations in sequence. This calculator is designed to allow new operations to be added easily in the future.

## Assumptions

- The calculator currently only supports **Bi-Operator Mode** (operations involving two operands, such as addition, subtraction, etc.).

## Design Decisions
- use Spring framework to implement IOC
- To add a new operation:
  1. Add a new `enum` value in the `Operation` enum.
  2. Add a corresponding `case` in the `calculate()` function in `CalculateServiceImp`.

## TODO

- **Mono-Operator Mode**: Implement support for operations that only require one operand (e.g., square root).
- **Exposed Endpoints**: Create endpoints to expose the calculator service to external environments (e.g., REST API).

## Prerequisites

- **Java 8** or above
- **Maven 3.x**

## How to Build

Make sure you have Maven installed and properly set up. In the root directory of your project (where `pom.xml` is located), run the following command to build the project:

```bash
mvn clean install
mvn spring-boot:run
mvn test

