Steps Performed

1. Clone the Project

Cloned the Calculator Gradle project from GitHub.

git clone https://github.com/Ibrahim-Adel15/CalculatorGradleApp.git

2. Install SDKMAN

Installed SDKMAN to manage Java development tools.

curl -s "https://get.sdkman.io" | bash

Loaded SDKMAN in the current terminal:

source "$HOME/.sdkman/bin/sdkman-init.sh"

3. Install Java

Installed Java 17 using SDKMAN.

sdk install java 17.0.20-tem

Verified the Java installation:

java -version

4. Install Gradle

Installed Gradle using SDKMAN.

sdk install gradle 9.8.2

Verified the Gradle installation:

gradle -version

5. Run Unit Tests

Executed the project's unit tests.

gradle test

Result: Tests passed successfully.

6. Build the Application

Built the application and generated the JAR file.

gradle build

Result: Build completed successfully.

7. Run the Application

Executed the generated JAR file.

java -jar build/libs/calculator.jar

Tested the calculator with inputs 1 and 5.

Output:

Sum: 6.0

Subtract: -4.0

Multiply: 5.0

Divide: 0.2
