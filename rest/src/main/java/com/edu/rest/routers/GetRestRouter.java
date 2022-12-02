package com.edu.rest.routers;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class GetRestRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//
//        restConfiguration()
//                .component("servlet")
//                .port(8080)
//                .host("localhost")
//                .bindingMode(RestBindingMode.auto);

        rest()
                .get("/user")
                .routeId("get-rest-router")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
//                .produces(MediaType.APPLICATION_JSON_VALUE)
                .produces("text/plain")
                .outType(String.class)
                .param()
                .name("name")
                .type(RestParamType.query)
                .endParam()
                .to("direct:end-rest");

        from("direct:end-rest")
                .routeId("end-rest")
                .setBody(simple("oi meu caro ${header.name}"))
                .log("${body}");

    }
}
