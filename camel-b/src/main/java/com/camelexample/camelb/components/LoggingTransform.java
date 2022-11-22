package com.camelexample.camelb.components;

import com.camelexample.camelb.entities.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingTransform<T> {

    Logger logger = LoggerFactory.getLogger(LoggingTransform.class);

    public void processLogger(T t){

        logger.info("Message is " + t.toString());

    }
}
