package com.edu.rest.routers;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class GetByIdRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet")
                .host("localhost")
                .bindingMode(RestBindingMode.auto)
                .port(8082);

        from("direct:getBy-router")
                .routeId("get-byId-router")
                .marshal().json(JsonLibrary.Jackson)
                .log("${body}")
//                .setHeader("id", () -> "1")
//                .setBody(simple("oi meu caro ${header.name}"))
//                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("rest:get:user/{id}?bridgeEndpoint=true")
                .log("${body}")
                .unmarshal().json(JsonLibrary.Jackson)
                .log("${body}");
    }
}
