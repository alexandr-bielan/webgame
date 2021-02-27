FROM maven:3.5.2-jdk-11-alpine AS MAVEN_BUILD

MAINTAINER Brian Hannaway

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:11-jre-alpine

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/docker-boot-intro-0.1.0.jar /app/
ENTRYPOINT ["java","-jar", "-Xmx128M","/webserv.war"]