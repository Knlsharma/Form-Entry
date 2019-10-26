# CRUD SPA (Single Page Application) with Angular 7.0 and Spring Boot 2.1

Application contains two modules:
* client - frontend generated using Angular CLI (https://cli.angular.io)
* server - backend generated using Spring IO (https://start.spring.io)


## Technology stack:

* Java 8
* Angular 7.0
* Angular Material
* Angular CLI
* Spring Boot 2.1
* Maven 3+
* PostgresSQL 11


## Prerequisites:

* Java 8
* Node.js 8+


## Getting Started

To install this example application, run the following commands:

```bash
git clone https://github.com/Knlsharma/registration_module.git
cd registration_module
```

To run the server, cd into the `server` folder and run:
 
```bash
mvn registration_module
```

To run the client, cd into the `client` folder and run:
 
```bash
npm install && npm start
```

Exposed ports:
```bash
CLIENT  : 4200
SERVER  : 8080
```

## Development

To build the application and start a web server (auto update during development)
 
```bash
ng serve -o
```
