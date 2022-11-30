package com.camelexample.camela.route;

import com.camelexample.camela.component.DeciderBean;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {

    @Autowired
    private DeciderBean deciderBean;

    @Override
    public void configure() throws Exception {

//        from("file:files/input")
//                .log("${body}")
//                .to("file:files/output");

//        from("file:files/input")
//                .routeId("files-input-route")
//                .log("${body}")
//                .transform().body(String.class)
//                .choice()
//                   .when(simple("${file:ext} == 'xml'"))
//                        .log("xml file")
//                    .when(simple("${body} contains 'USD'"))
//                        .log("contains USD")
//                    .otherwise()
//                        .log("not xml file")
//                .end()
//                .to("direct:log-file-values")
//                .to("file:files/output");

//
//        from("direct:log-file-values")
//                .log("${messageHistory} ${file:absolute.path}");


        from("file:files/input")
                .routeId("file-bean-router")
                .log("${body}")
                .transform().body(String.class)
                .choice()
                    .when(method(deciderBean))
                    .log("method called")
                .end()
                .to("file:files/output");


    }
}
