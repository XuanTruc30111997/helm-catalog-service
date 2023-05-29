FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8081
ARG JAR_FILE=target/*.jar
ARG SPRING_PROFILES_ACTIVE
COPY ${JAR_FILE} catalog-service-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}","/catalog-service-1.0.0-SNAPSHOT.jar"]
