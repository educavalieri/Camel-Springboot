package com.edu.rest.routers;

import com.edu.rest.components.UserBean;
import com.edu.rest.dtos.UserRequest;
import com.edu.rest.dtos.UserResponse;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.HttpMethods;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.Media;

@Component
public class PostRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet")
                .host("localhost")
                .bindingMode(RestBindingMode.auto)
                .port(8082);

        from("direct:post-router")
                .routeId("post-router")
                .log("${body}")
                .setHeader(Exchange.HTTP_METHOD, HttpMethods.POST)
                .setHeader(Exchange.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_VALUE))
                .removeHeader("CamelHttp*")
                .marshal().json(JsonLibrary.Jackson)
                .log("${body}")
                .to("rest:post:/user/insert?bridgeEndpoint=true")
//                .unmarshal().json(JsonLibrary.Jackson)
                .log("${body}")
                .unmarshal().json(UserResponse.class)
                .log("${body}")
                .bean(new UserBean(), "returnUser")

                .log("${body}");

    }
}
