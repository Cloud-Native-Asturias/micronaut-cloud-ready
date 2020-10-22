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
### Business
|Endpoint|Return Format|Desciption|
---------|-------------|----------|
|/starwars/v1/characters|`application/json`|List of people on Star Wars movies|

### Metrics
|Endpoint|Desciption|
---------|----------|
|/metrics|Metrics information in JSON format|
|/prometheus|Metrics information in Prometheus format|
|/health|Status health of the service in JSON format|

## Development
TODO

## Manual Testing
Here some examples about how to test the API
```shell script
$ curl -vvv http://localhost:8080/starwars/v1/characters
{"count":82,"next":"http://swapi.dev/api/people/?page=2","previous":null,"results":[{"name":"Luke Skywalker","height":"172","mass":"77","hair_color":"blond","skin_color":"fair","eye_color":"blue","birth_year":"19BBY","gender":"male","homeworld":"http://swapi.dev/api/planets/1/","films":["http://swapi.dev/api/films/1/","http://swapi.dev/api/films/2/","http://swapi.dev/api/films/3/","http://swapi.dev/api/films/6/"],"species":[],"vehicles":["http://swapi.dev/api/vehicles/14/","http://swapi.dev/api/vehicles/30/"],"starships":["http://swapi.dev/api/starships/12/","http://swapi.dev/api/starships/22/"],"created":"2014-12-09T13:50:51.644000Z","edited":"2014-12-20T21:17:56.891000Z","url":"http://swapi.dev/api/people/1/"},{"name":"C-3PO","height":"167","mass":"75","hair_color":"n/a","skin_color":"gold","eye_color":"yellow","birth_year":"112BBY","gender":"n/a","homeworld":"http://swapi.dev/api/planets/1/","films":["http://swapi.dev/api/films/1/","http://swapi.dev/api/films/2/","http://swapi.dev/api/films/3/","http://swapi.dev/api/films/4/","http://swapi.dev/api/films/5/","http://swapi.dev/api/films/6/"],"species":["http://swapi.dev/api/species/2/"],"vehicles":[],"starships":[],"created":"2014-12-10T15:10:51.357000Z","edited":"2014-12-20T21:17:50.309000Z","url":"http://swapi.dev/api/people/2/"},{"name":"R2-D2","height":"96","mass":"32","hair_color":"n/a","skin_color":"white, blue","eye_color":"red","birth_year":"33BBY","gender":"n/a","homeworld":"http://swapi.dev/api/planets/8/","films":["http://swapi.dev/api/films/1/","http://swapi.dev/api/films/2/","http://swapi.dev/api/films/3/","http://swapi.dev/api/films/4/","http://swapi.dev/api/films/5/","http://swapi.dev/api/films/6/"],"species":["http://swapi.dev/api/species/2/"],"vehicles":[],"starships":[],"created":"2014-12-10T15:11:50.376000Z","edited":"2014-12-20T21:17:50.311000Z","url":"http://swapi.dev/api/people/3/"},{"name":"Darth Vader","height":"202","mass":"136","hair_color":"none","skin_color":"white","eye_color":"yellow","birth_year":"41.9BBY","gender":"male","homeworld":"http://swapi.dev/api/planets/1/","films":["http://swapi.dev/api/films/1/","http://swapi.dev/api/films/2/","http://swapi.dev/api/films/3/","http://swapi.dev/api/films/6/"],"species":[],"vehicles":[],"starships":["http://swapi.dev/api/starships/13/"],"created":"2014-12-10T15:18:20.704000Z","edited":"2014-12-20T21:17:50.313000Z","url":"http://swapi.dev/api/people/4/"},
....
```

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
