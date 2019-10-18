package filrouge;
import java.util.HashMap;

public class NegationConstraint implements Constraint{
  protected Constraint negaC;

  public NegationConstraint(Constraint c){
    this.negaC=(c);
  }
  public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> object){
    if (! negaC.isSatisfiedBySchedule(object)){
      return true;
    }
    return false;
	}




}
