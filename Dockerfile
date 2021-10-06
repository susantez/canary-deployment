FROM adoptopenjdk/openjdk11
COPY target/*.jar /dfx-inventory-0.0.1.jar
ENTRYPOINT ["java","-jar","/dfx-inventory-0.0.1.jar"]