package com.edu.rest.routers;

import com.edu.rest.components.GetParamBean;
import com.edu.rest.dtos.UserIDRequest;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.language.simple.Simple;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParamRouter extends RouteBuilder {

    @Autowired
    private GetParamBean getParamBean;

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet")
                .host("localhost")
                .bindingMode(RestBindingMode.auto)
                .port(8082);

        from("direct:param-router")
                .routeId("param-router")
                .setBody(simple("Oi, meu id é ${header.id}"))
                .log("${body}")
//                .bean(getParamBean, "logParam")
//                .bean(getParamBean, "getHeader")
//                .bean(getParamBean, "toDtoUserId")
                .setBody(exchange -> getParamBean.toDtoUserId(exchange))
//                .log("${in.headers}")
                .log("${body}")
//                .marshal().json(JsonLibrary.Jackson)
                .log("${body}")
                .setHeader("id", () -> getParamBean)
                .log("${in.headers}");

    }
}
