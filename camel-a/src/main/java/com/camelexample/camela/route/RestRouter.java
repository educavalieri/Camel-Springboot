package com.camelexample.camela.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .port(8082)
                .host("localhost");

        from("timer:timer-rest?period=1000")
                .log("${body}")
                .to("rest:get:/user")
                .log("${body}");


    }
}
