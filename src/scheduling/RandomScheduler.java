package scheduling;

import constraints.Activity;
import constraints.Constraint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomScheduler {
  protected HashSet<Activity> activities;
  protected ArrayList<Constraint> constraints;
  protected Random randomGenerator;

  public RandomScheduler(){
    this.activities = new HashSet<>();
    this.constraints = new ArrayList<>();
    this.randomGenerator = new Random();
  }

  public void addActivity(Activity act){
    this.activities.add(act);
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
      a.setDuree(time);
      schedule.put(a, time);
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
    for (int i=1;i<n+1;i++){
      edtRan=this.edt();
      nbConstraint=this.nbConstraintVerifier(edtRan);
      if (nbConstraint==0){
        System.out.println("Nombre d'emploi du temps crées: "+i);
        System.out.println("Nombre de contraintes NON valide: "+nbConstraint);
        System.out.println();
        return edtRan;
      }
    }
    System.out.println("Nombre d'emploi du temps crées: "+n);
    System.out.println("Nombre de contraintes NON valide: "+nbConstraint);
    System.out.println();
    return edtRan;
  }
}
