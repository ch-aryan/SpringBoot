package com.codingwitharyan.restapis.GreetingsAPP.Controller;

import com.codingwitharyan.restapis.GreetingsAPP.Service.IGreetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingsController {


    @Autowired
    private IGreetings greetings;


    @GetMapping("/greet")
    public String method(Model model) {
     String response =   greetings.greetingMethI("Aryan");
     model.addAttribute("wish" , response);
     return "index";
    }

}
