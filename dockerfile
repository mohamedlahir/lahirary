FROM openjdk
COPY /target Lahir-0.0.1-SNAPSHOT.war
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/Lahir-0.0.1-SNAPSHOT.war"]