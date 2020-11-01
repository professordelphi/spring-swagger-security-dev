FROM openjdk
WORKDIR /app

COPY target/sbestudo.jar /app/spring-app.jar

ENTRYPOINT ["java", "-jar", "spring-app.jar"]