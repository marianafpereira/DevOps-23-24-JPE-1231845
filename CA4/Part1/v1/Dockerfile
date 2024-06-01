FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

RUN apt-get update 
RUN apt-get install -y openjdk-17-jre-headless 


RUN chmod +x gradlew

EXPOSE 8080

CMD ["./gradlew", "runServer"]