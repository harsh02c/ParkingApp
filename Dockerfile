FROM openjdk:8
EXPOSE 8080
ADD target/parkingapp.jar parkingapp.jar
ENTRYPOINT ["java","-jar","parkingapp.jar"]