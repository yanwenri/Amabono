FROM openjdk:8-jre-alpine
COPY target/*.jar mall.jar
CMD ["java","-jar","/mall.jar"]
