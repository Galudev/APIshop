# syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13
EXPOSE 8080
ADD /build/libs/shop-0.0.1-SNAPSHOT.jar apishop.jar
ENTRYPOINT ["java", "-jar", "apishop.jar"]