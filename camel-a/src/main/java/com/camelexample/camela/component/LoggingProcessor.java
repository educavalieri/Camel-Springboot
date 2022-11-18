package com.camelexample.camela.component;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingProcessor implements Processor {

    private Logger logger = LoggerFactory.getLogger(LoggingProcessingComponent.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        logger.info("LoggingProcessor {}" + exchange.getMessage().getBody());
    }
}
