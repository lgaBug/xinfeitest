FROM openjdk:11
MAINTAINER yanxin
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Spring-boot-demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Spring-boot-demo-0.0.1-SNAPSHOT.jar"]