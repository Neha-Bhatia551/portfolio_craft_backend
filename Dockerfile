FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/portfoliocraft-0.0.1-SNAPSHOT.jar portfoliocraft-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","portfoliocraft-0.0.1-SNAPSHOT.jar"]
