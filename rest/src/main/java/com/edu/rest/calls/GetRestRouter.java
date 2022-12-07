package com.edu.rest.calls;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class GetRestRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        rest()
                .get("/user")
                .routeId("get-rest-call")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .outType(String.class)
//                .param()
//                .name("name")
//                .type(RestParamType.query)
//                .endParam()
                .to("direct:get-router");
    }
}
