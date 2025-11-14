# nations-backend
Spring Boot REST API for visualizing country, region, and population data from the nations database.

Apache Maven 3.9.11

Java version: 1.8.0_472

Build the application with 
mvn clean install -DDB_USERNAME=\${DB_USERNAME}-DDB_PASSWORD=\${DB_PASSWORD} -DDB_URL=${DB_URL}

Start the service
java -DDB_USERNAME=\${DB_USERNAME} -DDB_PASSWORD=\${DB_PASSWORD} -DDB_URL=${DB_URL}

${DB_URL} = The full jdbc url of the nation schema in Maria DB

${DB_USERNAME} = The username of the nation schema in Maria DB

${DB_PASSWORD} = The password of the nation schema in Maria DB