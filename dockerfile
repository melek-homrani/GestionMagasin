FROM openjdk

WORKDIR /app

COPY . .

COPY mvnw .
COPY mvnw.cmd .

RUN chmod +x mvnw

RUN ./mvnw package

CMD ["java", "-jar", "target/gestionmagasin.jar"]
