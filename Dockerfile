FROM openjdk:19
EXPOSE 8080
ADD target/SpringAngular-0.0.1-SNAPSHOT.jar SpringAngular-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/SpringAngular-0.0.1-SNAPSHOT.jar"]
#CMD java -Djava.security.egd=file:/dev/./urandon --jar app.jar