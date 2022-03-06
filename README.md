# Metadata Challenge


### Stack used
- Java 8
- MySQL 8
- Apache Maven 3.5
- Spring Boot 2.6.4
- Junit and Mock
- Docker
- Docker Compose

### Instrucciones para instalación local
- Download and install [Java SDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html?ssSourceSiteId=otnes)
- Download and install [Apache Maven](https://maven.apache.org/download.cgi). 

+ **With Docker:**
    + Compile the component with maven using the command: mvn clean install -DskipTests
    + Run the command: docker-compose up --build (Docker must be installed).

+ **Springboot/Maven:**
    + NOTE: To run with this option it is necessary to have a MySQL 8 database with a database called "metadataio" and change the connection string to the database in the application.properties file so that the creation scripts of the application can be executed table.
    + Edit the file properties.application and comment this line ```spring.datasource.url=jdbc:mysql://mysqldb:3306/metadataio?createDatabaseIfNotExist=true``` and uncomment ```spring.datasource.url=jdbc:mysql://localhost:3306/metadataio?createDatabaseIfNotExist=true```
    + Compile the project with the command: mvn clean install
    + Move to project root folder: cd C:\Users\user\aldeamoTest\target
    + Run the command: mvn spring-boot:run


### Uso
Once the application is up and running, the API endpoints can be tested locally using a client
REST [Postman](https://www.getpostman.com/) or from the console if you have cURL installed.

API Students
-----
#### Create
```
POST localhost:8081/api/student
{
    "fullName": "Albert Medina",
    "numberId": 12345678
}
```
```
Response: 200 - OK
```
#### Update
```
PUT localhost:8081/api/student/update/2
{
    "fullName": "Albert Yoel Medina",
    "numberId": 12345555
}
```
```
Response: 200 - OK
```
#### Get student
```
GET localhost:8081/api/student/1
```
```
Response: 200 - OK

{
    "id": 1,
    "fullName": "Albert Yoel Medina",
    "numberId": 12345555
}
```
#### Get all students
```
GET localhost:8081/api/student
```
```
Response: 200 - OK
[
    {
        "id": 1,
        "fullName": "Albert Yoel Medina",
        "numberId": 12345555
    },
    {
        "id": 2,
        "fullName": "Albert Medina",
        "numberId": 1324345
    }
]
```
#### Delete student
```
DELETE localhost:8081/api/student/delete/1
```
```
Response: 200 - OK
{
    "id": 1,
    "fullName": "Albert Yoel Medina",
    "numberId": 12345555
}
```

API Course
-----
#### Create
```
POST localhost:8081/api/course
{
    "nameCourse": "Art 1",
    "codeCourse": "ART1"
}
```
```
Response: 200 - OK
```
#### Update
```
PUT localhost:8081/api/course/update/1
{
    "nameCourse": "Arts 1",
    "codeCourse": "ARTS1"
}
```
```
Response: 200 - OK
```
#### Get Course
```
GET localhost:8081/api/course/1
```
```
Response: 200 - OK

{
    "id": 1,
    "nameCourse": "Grammar",
    "codeCourse": "Grammar-4593",
    "numberStudent": 1
}
```
#### Get all Course
```
GET localhost:8081/api/student
```
```
Response: 200 - OK
[
    {
        "id": 1,
        "nameCourse": "Grammar",
        "codeCourse": "Grammar-4593",
        "numberStudent": 1
    },
    {
        "id": 2,
        "nameCourse": "Art",
        "codeCourse": "Art-4454",
        "numberStudent": 1
    }
]
```
#### Delete student
```
DELETE localhost:8081/api/course/delete/1
```
```
Response: 200 - OK
{
    "id": 1,
    "nameCourse": "Grammar",
    "codeCourse": "Grammar-4593",
    "numberStudent": 1
}
```
API Students - Courses
-----
#### Create
```
POST localhost:8081/api/student-course
{
    "idStudent": 1,
    "idCourse": 1
}
```
```
Response: 200 - OK
```
#### Get Students by Course
```
GET localhost:8081/api/student-course/student-by-course/1
```
```
Response: 200 - OK

[
    {
        "id": 1,
        "fullName": "Lauren Bretland",
        "numberId": 3584576361857078
    }
]
```
#### Get Courses by Student
```
GET localhost:8081/api/student-course/course-by-student/1
```
```
Response: 200 - OK

[
    {
        "id": 1,
        "nameCourse": "Grammar",
        "codeCourse": "Grammar-4593",
        "numberStudent": 1
    },
    {
        "id": 2,
        "nameCourse": "German",
        "codeCourse": "German-3578",
        "numberStudent": 1
    },
    {
        "id": 3,
        "nameCourse": "Economics",
        "codeCourse": "Economics-7911",
        "numberStudent": 1
    }
]
```
----




