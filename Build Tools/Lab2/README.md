# Lab 2 - Gradle Calculator

## Overview
This lab contains a Java Calculator application built with Gradle.

## Features
- Addition
- Subtraction
- Multiplication
- Division
- Unit tests using JUnit

## Project Structure
- `build.gradle`: Gradle build configuration
- `settings.gradle`: Project settings
- `src/main`: Application source code
- `src/test`: Unit tests

## Requirements
- Java 17 or later
- Gradle

## Run Tests
```bash
gradle test
gradle build
java -jar build/libs/calculator.jar

## 4. راجعي الـ structure النهائي

```bash
find "Build Tools" -type f \
  ! -path "*/target/*" \
  ! -path "*/build/*" \
  ! -path "*/.gradle/*" | sort
