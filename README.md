# micronaut-cloud-ready
Scaffolding of Micronaut project ready to be deployed on Kubernetes cluster

This project contains all the basic elements to deploy a Micronaut app (like this) on a Kubernetes cluster, following
some best practices, offering observability and resources to work during the development time.

## Micronaut
- Version 2.1.2. More info at [Micronaut 2.1.2](https://github.com/micronaut-projects/micronaut-core/releases/tag/v2.1.2)
- [Official documentation](https://docs.micronaut.io/latest/guide/index.html)

## Application Logic
This application will bring information about the Star Wars Public API

## Endpoints
|Endpoint|Desciption|
---------|----------|
|/metrics|Metrics information in JSON format|
|/prometheus|Metrics information in Prometheus format|
|/health|Status health of the service in JSON format|


## Metrics
TODO

## Development
TODO

## Run
### Gradle
```shell script
./gradlew clean run
```
And the app will run in the default port set on the `application.yaml`

### Docker
TODO

### Kubernetes
TODO

## ChangeLog
### 1.0.0
#### New Features
TODO
#### Changes
N/A
#### Bug fixes
N/A
