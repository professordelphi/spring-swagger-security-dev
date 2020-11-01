FROM openjdk
WORKDIR /app

COPY target/sbestudo.jar /app/spring-app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "spring-app.jar"]

