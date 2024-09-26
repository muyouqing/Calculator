
# Calculator Service
A Java-based calculator service that supports basic arithmetic operations such as addition, 
subtraction, multiplication, division, and chaining multiple operations in sequence. And this 
calculator allow new operations to be added in the future.

##assumption
assume this calculator only support BiOperator mode so far
##design decision
for added new operation, add new enum operation add new case into calculate function in CalculateServiceImp

###TODO
MonoOperator Mode
Exposed endpoint to external environment


Prerequisites

Java 8 or above
Maven 3.x
How to Build

Make sure you have Maven installed and properly set up. In the root directory of your project (where pom.xml is located), run:

bash
Copy code
mvn clean install
This will clean the project, install dependencies, and build the project.

How to Run

After building the project, you can run the application with:

bash
Copy code
mvn spring-boot:run
Alternatively, you can run the CalculatorApplication class directly from your IDE as a Java application.

How to Run Tests

To execute the unit tests, run:

bash
Copy code
mvn test
This will run all JUnit 5 tests located in the src/test directory.

# Calculator
