FROM amazoncorretto:19-alpine-jdk

COPY target/DTtest-0.0.1-SNAPSHOT.jar DTtest.jar

ENTRYPOINT ["java", "-jar", "DTtest.jar"]