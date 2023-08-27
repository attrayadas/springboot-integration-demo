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

**3. Configure Spring Integration**

Open the `src/main/java/com/attraya/SpringIntegrationConfig.java` file. Locate the `filter.addFilter()` method call within the `FileReadingMessageSource` method and adjust the extension as per your choice:
```bash
filter.addFilter(new SimplePatternFileListFilter("*.gif"));
```

**4. Run the Spring Boot Application**

Run the Spring Boot application using the following command:
```bash
mvn spring-boot:run
```

## Usage

Once the Spring Boot application is up and running, it will automatically scan the source directory for files with the specified extension and copy them to the destination directory. The destination folder will be created if it doesn't exist.
