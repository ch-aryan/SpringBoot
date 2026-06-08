package com.codingwitharyan.restapis.webMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("HelloWorld")
public class ClassLevelRequestMappingController {
    @RequestMapping("/welcome")
    public ModelAndView displaySomeResponse(){
        ModelAndView modelview  = new ModelAndView();
        modelview.addObject("message", "hello world this is aryan by class level understanding .");
        modelview.setViewName("index");
        System.out.println("this is something big");

        return modelview;
    }
}
