package filrouge.constraints;
import filrouge.*;
import java.util.HashMap;

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
  public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> object){
    if (this.c1.isSatisfiedBySchedule(object) || this.c2.isSatisfiedBySchedule(object)){
      return true;
    }
  return false;
	}

}
