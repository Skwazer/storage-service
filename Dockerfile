FROM amazoncorretto:11-alpine-jdk
ADD web/build/libs/*SNAPSHOT.jar storage-service.jar
ENTRYPOINT ["java","-jar","storage-service.jar"]