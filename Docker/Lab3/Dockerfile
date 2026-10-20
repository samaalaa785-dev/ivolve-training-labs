FROM maven:3.9-eclipse-temurin-17

WORKDIR /app

RUN useradd -m appuser

ENV HOME=/home/appuser

COPY --chown=appuser:appuser . .

USER appuser

RUN mvn package

CMD ["java", "-jar", "target/calculator.jar"]
