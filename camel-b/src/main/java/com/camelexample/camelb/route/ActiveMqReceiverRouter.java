package com.camelexample.camelb.route;

import com.camelexample.camelb.components.ClassTransform;
import com.camelexample.camelb.components.LoggingTransform;
import com.camelexample.camelb.entities.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {

    @Autowired
    private LoggingTransform loggingTransform;

    @Autowired
    private ClassTransform classTransform;

    @Override
    public void configure() throws Exception {

        from("activemq:my-activemq-queue")
                .unmarshal()
                    .json(JsonLibrary.Jackson, CurrencyExchange.class)
                .bean(classTransform)
//                .bean(loggingTransform)
                .to("log:receiver");
    }
}
