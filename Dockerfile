FROM openjdk:22-jdk
WORKDIR /app
# Встановлюємо Maven
RUN apt-get update && apt-get install -y maven
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/universityapp-0.0.1-SNAPSHOT.jar"]