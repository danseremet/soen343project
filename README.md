### Development Setup
1. Get Intellij Ultimate Edition

2. Import salonapp as maven project
- Set to import maven projects automatically
- Java version >= 8
- Add lombok plugin to Intellij

### REST APIs
Run server & go to: localhost:8081/swagger-ui.html

### Frontend

Install dependencies:
```
cd salon_frontend
npm install
```
Run dev server on localhost:3000
```
npm run dev
```

### Run backend in production
In root directory (salonapp):\
Build the backend:
```
mvn clean install
```
Run the backend server:
```
java -jar target/salonapp-0.0.1-SNAPSHOT.jar
```

### Authors

Claudia Guerreiro\
Dan Seremet \
Joey Abou Chaker\
Gurinder Dheer\
Jonathan Perez\
Gwendolyne Legate\
Michael Garner\
Kevin Trinh \
Robert Drury\
Keegan Woods\
Moataz Mohamed
