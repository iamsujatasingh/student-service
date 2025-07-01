# Use OpenJDK as base image
FROM openjdk:17-alpine
# Set app directory
WORKDIR /app

# Copy jar file
#COPY target/*.jar app.jar
COPY target/student-app-0.0.1-SNAPSHOT.jar student-app.jar
COPY application-docker.properties application.properties

# Expose port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "student-app.jar"]
