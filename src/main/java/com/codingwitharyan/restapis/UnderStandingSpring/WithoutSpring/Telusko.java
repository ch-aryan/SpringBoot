package com.codingwitharyan.restapis.UnderStandingSpring.WithoutSpring;

public class Telusko {
    Courses courses;
    public Telusko(Courses courses){
        this.courses = courses;
    }
    public boolean courseEnroll(int amount){
        if(amount >= 1000){
            courses.getCourse();
            System.out.println("course  done successly");
            return true;

        }else{
            System.out.println("sorry invalid course or amount ");
            return false;
        }
    }
}
