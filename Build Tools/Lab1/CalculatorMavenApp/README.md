
Steps:-
1. Check Java and Maven
java -version
mvn -version
2. Run Unit Tests
mvn test
Result: BUILD SUCCESS.
3. Build the Application
mvn package
Output: target/calculator.jar
4. Run the Application
java -jar target/calculator.jar
5. Test the Calculator
Input:
First number: 1
Second number: 2
Output:
Sum: 3.0
Subtract: -1.0
Multiply: 2.0
Divide: 0.5

