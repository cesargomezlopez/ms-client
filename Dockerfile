FROM openjdk:8-jdk-slim
COPY "./target/ms-client-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "app.jar"]