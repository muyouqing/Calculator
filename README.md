
# Calculator Service

A Java-based calculator service that supports basic arithmetic operations such as addition, subtraction, multiplication, division, modulus, and chaining multiple operations in sequence. This calculator allows new operations to be added in the future.

## Assumptions

- Currently, the calculator only supports **Bi-Operator Mode** (operations with two operands).

## Design Decisions

- To add a new operation(example: MOD):
  - Add a new enum value to the `Operation` enum.
  - Add a new case in the `calculate()` method in `CalculateServiceImp`.

### TODO

- Implement **Mono-Operator Mode** (for operations like square root).
- Expose the calculator service via an external API.

## Prerequisites

- **Java 8** or above
- **Maven 3.x**

## How to Build

Ensure Maven is installed and properly configured. In the project root directory (where `pom.xml` is located), run:

```bash
mvn clean install
```

## How to Run

After building the project, run the application with:

```bash
mvn spring-boot:run
```

Alternatively, run the `CalculatorApplication` class directly from your IDE.

## How to Run Tests

To execute the unit tests, run:

```bash
mvn test
```

## Example Usage

### Basic Operations

#### Addition (`ADD`)
```java
CalculateServiceImp calculator = new CalculateServiceImp();
Number result = calculator.calculate(Operation.ADD, 5, 3);
System.out.println("Addition result: " + result);  // Output: 8
```

#### Subtraction (`SUBTRACT`)
```java
Number result = calculator.calculate(Operation.SUBTRACT, 5, 3);
System.out.println("Subtraction result: " + result);  // Output: 2
```

#### Multiplication (`MULTIPLY`)
```java
Number result = calculator.calculate(Operation.MULTIPLY, 5, 3);
System.out.println("Multiplication result: " + result);  // Output: 15
```

#### Division (`DIVIDE`)
```java
Number result = calculator.calculate(Operation.DIVIDE, 6, 3);
System.out.println("Division result: " + result);  // Output: 2
```

#### Modulus (`MOD`)
```java
Number result = calculator.calculate(Operation.MOD, 10, 3);
System.out.println("Modulus result: " + result);  // Output: 1
```

### Sequential Operations

You can also perform multiple operations in sequence.

```java
List<ChainElement> chain = new ArrayList<>();
chain.add(new ChainElement(Operation.ADD, 5));        // Initial value + 5
chain.add(new ChainElement(Operation.MULTIPLY, 2));   // Result * 2
Number result = calculator.calculateSequential(3, chain);
System.out.println("Sequential operations result: " + result);  // Output: 16
```
