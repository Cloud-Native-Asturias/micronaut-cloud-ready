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
During development, it's very important test and test fast, not only the application but also how it will work when it's
deployed in production. For that, it's important to test via Docker container and, for doing so, we can use a docker-compose
file.

The `docker-compose.yml` file will run:
- Container with the last assembled version of this micronaut-cloud-ready app
- Container with [Prometheus](https://prometheus.io/) service, to scrape the metrics exposed by the app
- Container with [Grafana](https://grafana.com/) service, to visualize the metrics scraped by Prometheus from the app

### Run docker-compose
```shell script
$ ./gradlew clean assemble && docker-compose up
```
- Prometheus is available on http://localhost:9090. Perform some tests on the app API (see chapter above) and wait 30s to query for some metric such as `http_server_requests_seconds_count`

To stop the docker-compose, just type `Ctrl+c`. To remove the containers created, run `docker-compose down`.

### Setup Grafana
When you run the Grafana container for the first time, you have to set up the datasource Prometheus. Here the few steps
to achieve this.
1. Open your browser on http://localhost:3000 and login with user `admin` and password `admin`.
2. Go to `Configuration > Data Sources` and click on button `Add data source`
3. Select Time Series Database `Prometheus`
4. Fill in the fiels as follows
    - In URL field, add your local IP (no `localhost`) and port `9090`, for example, `http://192.168.1.15:9090`
5. Click on `Save & Test` button to confirm the dara source is working

From here, you can test this going to `Explore` menu and running a simple query over metric `http_server_requests_seconds_count`.

**PLEASE NOTE** that, if you run `docker-compose down` this configuration will be lost, and next time you get up the
containers you should follow the same steps again. 

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
#### Build Docker image
First, let's create the fat Jar
```shell script
./gradlew clean assemble
```
Now, let's build the docker image
```shell script
docker build . -t micronaut-cloud-ready:latest
```
Let's confirm it's created
```shell script
$ docker images | grep micronaut-cloud-ready
REPOSITORY                    TAG                 IMAGE ID            CREATED              SIZE
micronaut-cloud-ready         latest              48306ce0f2c7        53 seconds ago      355MB
```
#### Run via Docker container
```shell script
$ docker run -it --rm --name my-micronaut-cloud-ready -p 8080:8080 micronaut-cloud-ready:latest
```
And you will get something like this
```shell script
10:27:41.717 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 1222ms. Server Running: http://2ccd601578e6:8080
```
Type `Ctrl+c` to exit and remove the container.
### Kubernetes
TODO

## ChangeLog
### 1.0.0
#### New Features
- Add endpoint to retrieve people from Star Wars movies
- Add Dockerfile and instructions to run it
#### Changes
N/A
#### Bug fixes
N/A
