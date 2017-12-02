import com.yhack.h20.h2odaily.ExerciseDialog;
import com.yhack.h20.h2odaily.Workout;

import java.math
import java.util.ArrayList;

/**
 * Created by sosa on 12/2/17.
 */

public class Intake {
    private double totalintake; /* in ounces */
    private double currentintake;
    private int BASEINTAKE;
    private int EXERCISE;
    private double SURFACE;
    private double BMI;
    private ArrayList<Integer> workouts;
    private int age;
    private double temperature; /* in farenheit */
    private int UPPERBOUND_CUPS = 8 ;





    public Intake(int height, int weight) {
        /*initializes the object with a total intake needed, " +
                "calculated with an algorithm, and " +
                "keeps track of the current intake.*/
        /* turn weight to kilograms */

        this.workouts = new ArrayList<Integer>();
        this.SURFACE = weight/ (Math.pow(height,2));
        this.BASEINTAKE = 2/3 * weight;
        CalculateTotal();


    }

    public void addWorkout(int minutes){
        this.workouts.add(minutes);
        }


    public void CalculateTotal() {
        this.totalintake = this.BASEINTAKE + (0.2 * this.age) +
                workoutWeight(this.workouts);

    }
    public double workoutWeight(ArrayList<Integer> workouts){
        double sum = 0.0;
        for (Integer workout : workouts){
            sum += workout;
        }
        return sum;
    }
    public int cupsLeft(){
        return getTotalintake()-getCurrentintake();
    }

    public int getCurrentintake() {
        /* TODO -- round this */

        return Math.round(getCurrentintake());
    }


    public void setCurrentintake(int currentintake) {
        this.currentintake = currentintake;
    }


    public int getTotalintake() {
        /* TODO -- round this */
        return Math.round(getTotalintake());
    }

    public void setTotalintake(double totalintake) {
        this.totalintake = totalintake;
    }
}
