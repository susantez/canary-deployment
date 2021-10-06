FROM alpine/git as clone
WORKDIR /app
RUN git clone -b secondary https://github.com/susantez/canary-deployment.git

FROM maven:3.8.2-openjdk-11-slim as build
WORKDIR /app
COPY --from=clone /app/canary-deployment /app
RUN  mvn -DskipTests package -q

FROM openjdk:11-jre-slim
ARG artifactid=sample-app
ARG version=0.0.1
ENV artifact ${artifactid}-${version}.jar
WORKDIR /app
COPY --from=build /app/target/${artifact} /app
EXPOSE 8080
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar ${artifact}"]