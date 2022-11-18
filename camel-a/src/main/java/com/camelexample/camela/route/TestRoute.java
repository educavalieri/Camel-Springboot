package com.camelexample.camela.route;

import com.camelexample.camela.component.GetCurrentTimeBean;
import com.camelexample.camela.component.LoggingProcessingComponent;
import com.camelexample.camela.component.LoggingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Component
public class TestRoute extends RouteBuilder {

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    private LoggingProcessingComponent loggingProcessingComponent;

    @Override
    public void configure() throws Exception {

        from("timer:test")
//                .transform().constant("Time is " + LocalDateTime.now())
                .transform().constant("This is a test")
//                .bean("getCurrentTimeBean")
//                .bean(getCurrentTimeBean, "getCurrentTime")
                .to("direct:test");

        from("direct:test")
//                .bean(loggingProcessingComponent)
                .process(new LoggingProcessor())
                .to("log:test");

    }
}
