FROM openjdk:14-alpine
COPY build/libs/micronaut-cloud-ready-*-all.jar micronaut-cloud-ready.jar
CMD ["java", "-Xmx128m", "-jar", "micronaut-cloud-ready.jar"]
