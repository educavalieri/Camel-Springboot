package com.camelexample.camelb.components;

import com.camelexample.camelb.entities.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ClassTransform {

    Logger logger = LoggerFactory.getLogger(ClassTransform.class);

    public CurrencyExchange setExchange(CurrencyExchange currencyExchange){

        return CurrencyExchange
                .builder()
                .id(currencyExchange.getId())
                .to("to:" + currencyExchange.getTo())
                .from("from" + currencyExchange.getFrom())
                .conversionMultiple(currencyExchange.getConversionMultiple())
                .build();

    }


}
