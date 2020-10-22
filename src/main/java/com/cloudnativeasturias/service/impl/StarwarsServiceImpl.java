package com.cloudnativeasturias.service.impl;

import com.cloudnativeasturias.client.StarwarsApiClient;
import com.cloudnativeasturias.service.StarwarsService;
import io.micronaut.http.HttpResponse;

import javax.inject.Singleton;

@Singleton
public class StarwarsServiceImpl implements StarwarsService {

    private StarwarsApiClient starwarsApiClient;

    public StarwarsServiceImpl(StarwarsApiClient starwarsApiClient) {
        this.starwarsApiClient = starwarsApiClient;
    }

    @Override
    public HttpResponse<String> getAllCharacters() {
        return starwarsApiClient.getAllCharacters();
    }
}
