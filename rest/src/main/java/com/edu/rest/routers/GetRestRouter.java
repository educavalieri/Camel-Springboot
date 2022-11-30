package com.edu.rest.routers;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class GetRestRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .host("localhost")
                .port(8081)
                .bindingMode(RestBindingMode.auto);

        rest("/home")
                .get("/user")
                .routeId("get-rest-router")
                .to("direct:end-rest");

        from("direct:end-rest")
                .routeId("end-rest")
                .log("${body}");

    }
}
