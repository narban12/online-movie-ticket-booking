FROM openjdk:21
COPY target/movie-ticket-platform.jar movie-ticket-platform.jar
ENTRYPOINT ["java", "-jar", "movie-ticket-platform.jar"]
