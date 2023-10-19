FROM openjdk:17
ARG JAR_FILE=target/TopEducation.jar
COPY ${JAR_FILE} TopEducation.jar
ENTRYPOINT ["jar","-jar","/TopEducation.jar"]