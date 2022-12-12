package com.edu.rest.components;

import com.edu.rest.dtos.UserIDRequest;
import com.edu.rest.dtos.UserRequest;
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

    void getHeader(Exchange exchange){

        String getHeader = exchange.getIn().getHeader("id", String.class);
        Long timestamp = exchange.getIn().getMessageTimestamp();
        logger.info("the header is: {} and timestamp is {}",  getHeader, timestamp );
    }

    public UserIDRequest toDtoUserId(Exchange exchange){

        Long id = exchange.getIn().getHeader("id", Long.class);
        Long idMultiply = id * 2;
        UserIDRequest userId = UserIDRequest
                .builder()
                .id(idMultiply)
                .build();

        logger.info("the id seted is {} ", idMultiply);

        return userId;
    }




}
