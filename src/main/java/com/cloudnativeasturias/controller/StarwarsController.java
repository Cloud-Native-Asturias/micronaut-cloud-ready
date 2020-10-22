package com.cloudnativeasturias.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/starwars/v1")
public class StarwarsController {

    @Get("/characters")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<String> index() {
        return HttpResponse.ok("all good");
    }
}
