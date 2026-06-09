package com.codingwitharyan.restapis.GreetingsAPP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class ConfiguarationClass {
    @Bean
    public LocalDateTime ldt(){
        return LocalDateTime.now();
    }
}
