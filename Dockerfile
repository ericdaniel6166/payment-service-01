# ---------- Runtime stage ---------------
FROM amazoncorretto:17-alpine-jdk
ARG JAR=target/*.jar

COPY /${JAR} /app.jar

EXPOSE 5001
ENTRYPOINT ["java","-jar","/app.jar"]
