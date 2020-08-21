# Meter Readings
This is Typeqast techincal task application that was developed using Java 1.8 and Spring Boot 2.3.3.
It provides APIs for retrieving Meter Readings as well as inserting Meter Readings.
Application uses H2 in memory database for data persistence and Swagger UI for clear 
APIs overview and easy APIs usage. Please check Notes.txt for additional explanation of
development and application usage.

#Running application
Application can be started using command:

    mvn spring-boot:run

#Running tests
Application tests can be started using command:

    mvn test
    
#Database
When application is started, access to database is available via link:

    http://localhost:8080/h2-console
    
Credentials for accessing database can be found in:

    application.yml
    
There is initial data import each time application is started.
Data location is in folder:

    /src/main/resources/liquibase
  
#Swagger
Application APIs can be overviewed and tested by using Swagger. Each endpoint is described along with parameters
 it uses. Once application is started,
Swagger UI is available on link:
 
     http://localhost:8080/swagger-ui.html
