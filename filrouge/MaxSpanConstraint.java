package filrouge;
import java.util.List;
import java.util.HashMap;

public class MaxSpanConstraint implements Constraint{
  protected List<Activity> activities;
  protected int maxspan;

  public MaxSpanConstraint(List<Activity> activities,int maxspan){
    this.activities=activities;
    this.maxspan = maxspan;
  }

  public int getMaxSpan(){
    return this.maxspan;
  }

  public List<Activity> getActivities(){
    return this.activities;
  }

  public boolean isMaxSpan(){
    int time=0;
    for (Activity a: activities){
      time=time+a.getDuree();
    }
    if (time > getMaxSpan()){
      return false;
    }
    return true;
  }

  public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> hashmap){
    if ( ! isMaxSpan()){
      System.out.println("La contrainte MaxSpanConstraint nest pas satisfaite");
      return false;
    }
    return true;
  }


}
