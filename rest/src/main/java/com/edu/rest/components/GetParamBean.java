package com.edu.rest.components;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class GetParamBean {

    Logger logger = LoggerFactory.getLogger(GetParamBean.class);

    void logParam(Exchange exchange){

        String get = exchange.getMessage().getBody(String.class);
        logger.info("the body is:");
        logger.info("{}", get);
    }




}
