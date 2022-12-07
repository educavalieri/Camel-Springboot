package com.edu.rest.components;

import com.edu.rest.dtos.UserRequest;
import com.edu.rest.dtos.UserResponse;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class UserBean {

    public void insertUser(Exchange exchange){
        UserRequest user = exchange.getMessage().getBody(UserRequest.class);
        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(user.getEmail());

        exchange.getMessage().setBody(userResponse);
    }

    public void returnUser(Exchange exchange){
        UserResponse user = exchange.getMessage().getBody(UserResponse.class);
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail(user.getEmail());

        exchange.getMessage().setBody(userRequest);

    }

}
