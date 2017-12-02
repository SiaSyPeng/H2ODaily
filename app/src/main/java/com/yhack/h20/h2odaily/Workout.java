package com.yhack.h20.h2odaily;

/**
 * Created by sosa on 12/2/17.
 */

public class Workout {
    private String exercise;
    private int minutes;
    private String intensity; /* if we have time, implement this */

    public Workout(String exercise, int minutes){
        this.exercise = exercise;0
        this.minutes = minutes;

    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    public double getWeight(){
        if (this.exercise == null || this.minutes == null) return 0;
        double timeweight = this.minutes/60;
        double baseweight = 0 ;
        if (this.exercise == "running"){
            baseweight = 8;
            return baseweight * timeweight;
        }
        if (this.exercise == "swimming"){
            baseweight = 10;
            return baseweight * timeweight;
        }
        if (this.exercise == "lifting"){
            baseweight = 6;
            return baseweight * timeweight;
        }
        if (this.exercise == "basketball"){
            baseweight = 12;
            return baseweight * timeweight;
        }
}
