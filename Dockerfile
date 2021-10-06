FROM alpine/git as clone
WORKDIR /app
RUN git clone -b primary https://github.com/susantez/canary-deployment.git

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/canary-deployment /app
RUN  mvn -DskipTests package -q

FROM adoptopenjdk/openjdk11
WORKDIR /app
COPY --from=build /app/target/sample-app-0.0.1.jar /app
EXPOSE 8080
CMD ["java -jar sample-app-0.0.1.jar"]