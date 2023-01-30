FROM amazoncorretto:19

COPY target/DTtest-0.0.1-SNAPSHOT.jar DTtest.jar

ENTRYPOINT ["java", "-jar", "DTtest.jar"]
