package constraints;
import java.util.HashMap;

public class NegationConstraint implements Constraint{
  protected Constraint negaC;

  public NegationConstraint(Constraint c){
    this.negaC=(c);
  }
  public String getName(){
    return "NegationConstraint";
  }
  public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> object) {
    return !negaC.isSatisfiedBySchedule(object);
  }




}
