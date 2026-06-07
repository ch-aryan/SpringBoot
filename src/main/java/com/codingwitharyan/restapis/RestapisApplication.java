package com.codingwitharyan.restapis;

import com.codingwitharyan.restapis.UnderStandingSpring.With.Dsa1;
import com.codingwitharyan.restapis.UnderStandingSpring.With.Telusko1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestapisApplication {

    public static void main(String[] args) {

//     ConfigurableApplicationContext obj =   SpringApplication.run(RestapisApplication.class, args);
//        Telusko1 obj = context.getBean(Telusko1.class);
//        boolean b = obj.courseEnroll(1000);
//        System.out.println(b);
//
//        ServiceClassExample bean = obj.getBean(ServiceClassExample.class);
//        bean.thisMethManuallyInvoking();

        ConfigurableApplicationContext run = SpringApplication.run(RestapisApplication.class, args);
        Telusko1 bean = run.getBean(Telusko1.class);
        System.out.println(bean.courseEnroll(1111));
    }

}
