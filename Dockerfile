FROM bellsoft/liberica-openjdk-alpine-musl
COPY /target/ticketSaleSystems-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","ticketSaleSystems-0.0.1-SNAPSHOT.jar"]