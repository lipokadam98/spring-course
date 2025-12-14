package com.luv2code.util;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice home runs for 30 minutes";
    }
}
