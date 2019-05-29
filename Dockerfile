FROM openjdk:8-jre-alpine
COPY mall-account/target/*.jar mall-account.jar
CMD ["java","-jar","/mall-account.jar"]
