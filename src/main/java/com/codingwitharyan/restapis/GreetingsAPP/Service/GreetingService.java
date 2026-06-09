package com.codingwitharyan.restapis.GreetingsAPP.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class GreetingService implements IGreetings{
    @Autowired
    private LocalDateTime ldt;


    @Override
    public String greetingMethI(String name) {
        int hour = ldt.getHour();
        if(hour < 12){
            return "namaskar subhoday"+ name + hour;
        }else if(hour < 16){
            return "good after noon" + name + hour;
        }else{
            return "good night";
        }
    }
}
