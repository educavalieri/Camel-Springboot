package com.camelexample.camela.route.rest;

import org.apache.camel.builder.RouteBuilder;


import org.apache.camel.model.rest.RestBindingMode;

import org.springframework.stereotype.Component;

//@Component
public class CallRestRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .port(8081)
                .host("localhost")
                .bindingMode(RestBindingMode.auto);

        rest("/life")
                .get("/usuario")
                .routeId("rest-usurario")
                .to("direct:callApi")
                .to("log:callApi");

//        from("direct:callApi")
//                .routeId("call-rest-usuario")
//                .removeHeader("CamelHttp*")
//                .to("rest:get:/user")
//                .log("${body}");

    }
}
