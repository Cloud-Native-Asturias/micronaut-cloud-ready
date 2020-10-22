package com.cloudnativeasturias.service;

import io.micronaut.http.HttpResponse;

public interface StarwarsService {

    public HttpResponse<String> getAllCharacters();
}
