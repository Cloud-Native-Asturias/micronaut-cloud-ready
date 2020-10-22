package com.cloudnativeasturias.controller;

import com.cloudnativeasturias.service.StarwarsService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/starwars/v1")
public class StarwarsController {

    private final StarwarsService starwarsService;

    public StarwarsController(StarwarsService starwarsService) {
        this.starwarsService = starwarsService;
    }

    @Get("/characters")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<String> index() {
        return starwarsService.getAllCharacters();
    }
}
