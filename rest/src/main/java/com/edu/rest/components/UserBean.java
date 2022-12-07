package com.edu.rest.components;

import com.edu.rest.dtos.UserRequest;
import com.edu.rest.dtos.UserResponse;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component

public class UserBean {

    public void insertUser(Exchange exchange){

        UserResponse userResponse = exchange.getMessage().getBody(UserResponse.class);
        exchange.getMessage().setBody(userResponse);
    }

    public void returnUser(Exchange exchange){
        UserResponse user = exchange.getMessage().getBody(UserResponse.class);
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail(user.getEmail());

        exchange.getMessage().setBody(userRequest);

    }

}
