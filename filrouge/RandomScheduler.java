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
      a.duree=time;
      schedule.put(a,time);
    }
    return schedule;
  }

  public int nbConstraintVerifier(HashMap<Activity, Integer> hmap){
    int nb_constraint;
    nb_constraint=0;
    for(Constraint c: this.constraints){
      if (! c.isSatisfiedBySchedule(hmap)){
        nb_constraint=nb_constraint+1;
      }
    }
    return nb_constraint;
  }
  public HashMap<Activity, Integer> edtRandom(int n){
    HashMap<Activity, Integer> edtRan=this.edt();
    int nbConstraint=this.nbConstraintVerifier(edtRan);
    for (int i=0;i<n;i++){
      edtRan=this.edt();
      nbConstraint=this.nbConstraintVerifier(edtRan);
      if (nbConstraint==0){
        System.out.println("Nombres de contraintes NON valide: "+nbConstraint);
        System.out.println();
        return edtRan;
      }
    }
    System.out.println("Nombres de contraintes NON valide: "+nbConstraint);
    System.out.println();
    return edtRan;
  }
}
