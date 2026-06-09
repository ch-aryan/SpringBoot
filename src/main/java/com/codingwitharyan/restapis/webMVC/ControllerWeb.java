//package com.codingwitharyan.restapis.webMVC;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Map;
//
//@Controller
//public class ControllerWeb {
//
//    @RequestMapping("/welcome")
//    public ModelAndView displaySomeResponse(){
//        ModelAndView modelview  = new ModelAndView();
//        modelview.addObject("message", "hello world this is aryan");
//        modelview.setViewName("index");
//        System.out.println("this is something big");
//
//        return modelview;
//    }
//    @GetMapping("/welcome2")
//    public ModelAndView displaySomeResponse2(){
//        ModelAndView modelview  = new ModelAndView();
//        modelview.addObject("message", "hello world this is aryan Chilkeshwaram");
//        modelview.setViewName("index");
//        System.out.println("this is something big");
//
//        return modelview;
//    }
//
//    @GetMapping("/welcome3")
//    public String displaySomeResponse3(Model model){
//
//    model.addAttribute("info", "this is home page created by springboot");
//        return "hoem";
//    }
//
//
//    @RequestMapping("/profile")
//    public ModelAndView profile() {
//
//        ModelAndView mv = new ModelAndView();
//
//        mv.addObject("name", "Aryan");
//        mv.addObject("age", 22);
//
//        mv.setViewName("profile");
//
//        return mv;
//    }
//
//    @RequestMapping("/contact")
//    public String contact() {
//        return "contact";
//    }
//
//    @RequestMapping("/submitContact")
//    public ModelAndView submitContact(
//            @RequestParam String username,
//            @RequestParam String msg) {
//
//        ModelAndView mv = new ModelAndView();
//
//        mv.addObject("username", username);
//        mv.addObject("msg", msg);
//
//        mv.setViewName("result");
//
//        return mv;
//    }
//    @GetMapping(value = "map" , name = "hello world")
//    public String displayInfo(Map<String , Object> map){
//        map.put("info", "hello industry has drastically changed over the time now frehser");
//        return "hoem";
//    }
//}
