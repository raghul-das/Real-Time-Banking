# Step 1: Use a lightweight Java base image
FROM eclipse-temurin:17-jdk

# Step 2: Set the working directory
WORKDIR /Real-Time-Banking

# Step 3: Copy the JAR file into the image
COPY target/Real-Time-Banking-0.0.1-SNAPSHOT.jar real-time-banking-app.jar

USER root
RUN apt-get update && apt-get install -y ca-certificates && rm -rf /var/lib/apt/lists/*
RUN useradd -ms /bin/bash app
USER app

# Step 4: Command to run the app
RUN java -version
ENTRYPOINT ["java", "-jar", "real-time-banking-app.jar"]