package com.company;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Experience extends Client{
    
    private String jobTitle;
    private String supervisor;
    private int duration;   // Duration is in DAYS

    public String getJobTitle(){
        return jobTitle;
    }

    public String getSupervisor(){
        return supervisor;
    }

    public int getDuration(){
        return duration;
    }

    public void setJobTitle(String newTitle){
        this.jobTitle = newTitle;
    }

    public void setSupervisor(String newSupervisor){
        this.supervisor = newSupervisor;
    }

//    public void SetDuration(Date start, Date end){
//       durInMillies = end.getTime()-start.getTime();
//        this.duration = TimeUnit.DAYS.convert(durInMillies,TimeUnit.MILLISECONDS);
//    }
}

// To Add: Functionality