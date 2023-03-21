package com.lipokadam;

import org.springframework.stereotype.Component;

@Component
public class Doctor implements Staff{

    private String qualification;

    private Nurse nurse;

    public Doctor(String s) {
        this.qualification = s;
    }

    public void assist(){
        System.out.println("assisting");
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
