# Etapa 1: compilar o projeto
FROM maven:3.9-eclipse-temurin-26 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: executar a aplicação
FROM eclipse-temurin:26-jre

WORKDIR /app

COPY --from=build /app/target/taskforge-0.0.1-SNAPSHOT.jar app.jar

# OTIMIZAÇÃO CRUCIAL PARA CONTAINERS PEQUENOS (512MB RAM):
# Limita a RAM para 75%, usa SerialGC (menos memória) e diminui o tamanho da thread stack
ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=75.0 -XX:+UseSerialGC -Xss512k -XX:ReservedCodeCacheSize=48m"

# O SnapDeploy usa a porta 10000 por padrão, mas o Spring Boot vai ler a variável PORT.
EXPOSE 10000

ENTRYPOINT ["java", "-jar", "app.jar"]