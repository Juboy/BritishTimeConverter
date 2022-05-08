# SmartBear British Time Converter
The application transforms time in 24 hours to British spoken words.

The application takes in an Input in 24 hours format (e.g 14:00) and converts it into british spoken words. For example
- 14:00 - two o'clock
- 13:50 - ten to two
- 12:05 - five minutes past twelve
- 01:30 - half past one
- 03:15 - quarter past three
- 03:45 - quarter to four


## Getting Started

### Project Description
The project is a simple maven application. This allows me to use the maven build tool to pull dependencies and configure build parameters.

The source code can be found in the ````src/main/java````  while tests written with JUnit5 can be found in the ````src/test/java```` package.


### Tools
Here are the tools required to start the application:

* Java 8 - This project uses java 8. You need to have this installed on your machine.


### Starting the Application

* Clone the project
* On the project's root folder, run the following command
    ````./mvnw package````. This will bundle the project into a jar archive using the maven wrapper provided in the project root. To run the tests alone, 
    run the command ````./mvnw test````.
* After this successfully runs, a ````/target```` directory is created. Simply run the command
````java -jar target/smartbear-1.0-SNAPSHOT.jar```` on the project root. Then follow the instructions to displayed on the console.

