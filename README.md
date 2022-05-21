# Expenses Registry Service

The intention of this project is to show some competences regarding software development and just to have fun! :grin: :computer:

The service is written in Kotlin using the Spring Boot framework. Its purpose is to listen on expenses related events and handle them.

## Building the application

The project uses [Gradle](https://gradle.org) as a build tool. It already contains
`./gradlew` wrapper script, so there's no need to install gradle.

To build the project execute the following command:

```bash
  ./gradlew build
```

## Running the application

You can run the service either in a docker container or locally in your IDE.

### Docker container
To run in the docker container execute the following command:

```bash
  docker run -p 8080:8080 --name expenses-registry expenses-registry:0.1
```

### IDE - IntelliJ IDEA
Create a Spring Boot Run Configuration with Active Profiles set to `local`.

## Health checks

In order to monitor the status of the application, `spring boot actuator` mechanism is used.

List of exposed endpoints:
* status page - /manage/status
* info page - /manage/info

## Docker

### Build an image
To build a new docker image run the command `./bin/build-docker.sh -c -v VERSION_OF_THE_IMAGE`.

What does mean the flags:

* The flag `-c` cleans the gradle directory.
* The flag `-v` is mandatory and sets the version of the docker image.
* The flag `-h` prints the help.

### Run docker-compose
To run all necessary services for the expenses-registry application just run `docker-compose up` command.

## Plugins

Description of some plugins that were used in the project:

* [Jacoco](https://docs.gradle.org/current/userguide/jacoco_plugin.html)

  Provides code coverage metrics for Java code. You can create the report by running the following command:

  ```bash
    ./gradlew jacocoTestReport
  ```

  The report will be created in `build/reports` subdirectory in your project directory.


* [OWASP Dependency Check](https://jeremylong.github.io/DependencyCheck/dependency-check-gradle/index.html)

  Finds known vulnerabilities in dependencies that are used by the service. You can run the check by running the following command:

  ```bash
    ./gradlew dependencyCheck
  ```