package com.edu.rest.routers;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
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
                .marshal().json(JsonLibrary.Jackson)
//                .setBody(simple("oi meu caro ${header.name}"))
                .log("${body}")
                .to("rest:get:/user?bridgeEndpoint=true")
                .unmarshal().json(JsonLibrary.Jackson)
                .log("${body}");

//            from("direct:get-router")
//                .marshal().json(JsonLibrary.Jackson)
//                .setHeader("Content-Type", constant("application/json"))
//                .setHeader("Accept", constant("application/json"))
//                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
//                .removeHeader(Exchange.HTTP_PATH)
//                    .log("${body}")
//                .recipientList(simple("http://localhost:8082/user" +
//                        "?bridgeEndpoint=true"))
//                .unmarshal().json(JsonLibrary.Jackson)
//                    .log("${body}");


    }
}
