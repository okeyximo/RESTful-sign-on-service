#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim as build

#Information around who maintains the image
MAINTAINER okeyx.hashnode.dev

# Add the application's jar to the container
COPY target/SystemSpecsTask-0.0.1-SNAPSHOT.jar SystemSpecsTask-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/SystemSpecsTask-0.0.1-SNAPSHOT.jar"]