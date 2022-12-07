package com.edu.rest.routers;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class GetRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet")
                .host("localhost")
                .bindingMode(RestBindingMode.auto)
                .port(8082);

          from("direct:get-router")
                .routeId("get-router")
//                .setBody(simple("oi meu caro ${header.name}"))
                .log("${body}")
                .to("rest:get:/user");


    }
}
