package com.edu.rest.calls;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class GetParamRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        rest()
                .get("/test")
                .routeId("get-param-rest-call")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .param()
                    .name("id")
                    .type(RestParamType.query)
                .endParam()
                .to("direct:param-router");

    }
}
