package com.edu.rest.calls;

import com.edu.rest.dtos.UserRequest;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class PostRestRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        rest()
                .post("/user")
                .routeId("post-rest-call")
                .type(UserRequest.class)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .bindingMode(RestBindingMode.auto)
                .to("direct:post-router");

    }
}
