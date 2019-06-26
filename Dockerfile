FROM openjdk:8
ADD target/transport-V1.jar transport-V1.jar
EXPOSE 8081
ENTRYPOINT ["java", "jar", "transport-V1.jar"]