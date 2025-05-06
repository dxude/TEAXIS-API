FROM eclipse-temurin:17-jdk-jammy AS build

# Etapa de build - Acessa a subpasta TEAXIS-API/
WORKDIR /workspace
COPY TEAXIS-API/pom.xml .
COPY TEAXIS-API/src src
RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]