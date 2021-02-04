FROM adoptopenjdk/openjdk11:alpine
ADD /build/libs/calculator.jar calculator.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "calculator.jar"]