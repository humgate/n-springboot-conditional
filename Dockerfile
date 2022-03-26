FROM openjdk:8-jdk-alpine
# set to 8080 for dev, 8081 for prod before building the image
EXPOSE 8081
# set ADD source to springboot-conditional-app-0.1-dev.jar before building the image
ADD target/springboot-conditional-app-0.1-prod.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]