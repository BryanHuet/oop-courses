package constraints;
import java.util.HashMap;

// La contrainte 1 est validée OU la contrainte 2 est validée
public class DisjunctionConstraint implements Constraint{
  protected Constraint c1;
  protected Constraint c2;

  public DisjunctionConstraint(Constraint c1, Constraint c2){
    this.c1=c1;
    this.c2=c2;
  }

  public String getName(){
    return "DisjunctionConstraint";
  }
  public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> object) {
    return this.c1.isSatisfiedBySchedule(object) || this.c2.isSatisfiedBySchedule(object);
  }

}
