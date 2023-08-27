# SpringBoot Integration Demo
A Spring Boot project demonstrating the use of Spring Integration's file adapter. This example showcases copying files from one directory to another, with added file extension filtering for selective copying

## Steps to Setup

**1. Clone the Application**

```bash
git clone https://github.com/attrayadas/springboot-integration-demo
```

**2. Configure Application Properties**

Open the `src/main/resources/application.properties` file in the project directory. Update the following properties:

+ `source.directory`: Set the absolute path to the folder containing files of different extensions that you want to copy.
+ `target.directory`: Set the absolute path to the folder where you want the destination folder to be automatically created.
