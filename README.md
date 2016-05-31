This project is comprehended by the following:
* Spring Boot REST controller
* Apache Shiro (1.2.4) session-management with MySQL-based authorizing realm
* Hazelcast (3.5.1) powered session distributed persistence
* MySQL Database with JPA and Hibernate
* Swagger Rest API Doc with Spring Fox plugin

# Pre-requisites

* JDK 8
* Maven 3.2.3 or newer
* MySQL 

# Run

```
mvn clean package spring-boot:run
```

# Swagger Rest Doc
```
https://localhost:9000/swagger-ui.html 
```

# Testing

## Automatically

```mvn clean test```

## Manually

### Initialize test scenario

```
curl -i -H "Accept: application/json" -X PUT https://localhost:9000/users
```

### Access protected method without being authenticated

```
curl -i -H "Accept: application/json" -X GET https://localhost:9000/users
```

You should get a ```401 Unauthorized``` response status.

### Log-in

```
curl -i -c cookie.txt -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"username":"test@test.com","password":"test"}' https://localhost:9000/users/auth
```

You should get a ```200 OK``` response status and have a valid cookie stored in ```cookie.txt```.

### Access protected method again

```
curl -i -b cookie.txt -H "Accept: application/json" -X GET https://localhost:9000/users
```

You should get a ```200 OK``` response status and some JSON representing existing users.

