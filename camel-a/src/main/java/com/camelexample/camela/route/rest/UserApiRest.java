package com.camelexample.camela.route.rest;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

//@Component
public class UserApiRest extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .port(8082)
                .host("localhost")
                .bindingMode(RestBindingMode.auto);

        from("direct:callApi")
                .routeId("call-rest-usuario")
                .removeHeader("CamelHttp*")
                .to("rest:get:/user")
//                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
//                .to("http://localhost:8082/user")
                .log("${body}");

    }
}
