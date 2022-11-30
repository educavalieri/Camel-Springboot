package com.edu.rest.routers;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class RestRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .host("localhost")
                .port(8082);

        from("timer:timer-router?period=1000")
                .routeId("timer-router")
                .log("${body}")
                .to("rest:get:/user")
                .log("${body}");

    }
}
