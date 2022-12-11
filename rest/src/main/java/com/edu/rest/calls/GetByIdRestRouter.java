package com.edu.rest.calls;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class GetByIdRestRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        rest()
                .get("/user/{id}")
                .routeId("get-byId-rest-call")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .to("direct:getBy-router");

    }
}
