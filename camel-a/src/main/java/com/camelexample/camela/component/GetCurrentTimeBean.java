package com.camelexample.camela.component;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GetCurrentTimeBean {

    public String getCurrentTime(){
        return "time is now" + LocalDateTime.now();
    }

}
