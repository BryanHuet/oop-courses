package filrouge;
import filrouge.constraints.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class RandomScheduler{
  protected HashSet<Activity> activities;
  protected ArrayList<Constraint> constraints;
  protected Random randomGenerator;

  public RandomScheduler(){
    this.activities = new HashSet<>();
    this.constraints = new ArrayList<>();
    this.randomGenerator = new Random();
  }

  public void addActivity(Activity act){
    if ( ! this.activities.contains(act)){
    this.activities.add(act);
    }
  }

  public void addConstraint(Constraint constraint){
    if ( ! this.constraints.contains(constraint)){
      this.constraints.add(constraint);
    }
  }

  public HashMap<Activity, Integer> edt(){
    HashMap<Activity, Integer> schedule = new HashMap<Activity, Integer> ();
    for(Activity a: this.activities){
      int time = this.randomGenerator.nextInt(60) + 1;
      schedule.put(a,time);
    }
    return schedule;
  }

  public boolean verify(HashMap<Activity, Integer> hmap){
    for(Constraint c: this.constraints){
      if ( ! c.isSatisfiedBySchedule(hmap)){
        System.out.println("Constaint: "+c.getName()+" is not valid");
        return false;
      }
    }
    return true;
  }

  public HashMap<Activity, Integer> edtRandom(){
    
  }
}
