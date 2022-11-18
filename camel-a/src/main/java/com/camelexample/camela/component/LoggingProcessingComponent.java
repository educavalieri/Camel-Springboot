package com.camelexample.camela.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class LoggingProcessingComponent {

    private Logger logger = LoggerFactory.getLogger(LoggingProcessingComponent.class);

    public void process(String message){

        logger.info("LoggerProcessingComponent {}", message);

    }

}
