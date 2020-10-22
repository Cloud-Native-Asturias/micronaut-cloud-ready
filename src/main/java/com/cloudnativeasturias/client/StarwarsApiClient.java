package com.cloudnativeasturias.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("https://swapi.dev/api")
public interface StarwarsApiClient {

    @Get("/people/")
    HttpResponse<String> getAllCharacters();
}
