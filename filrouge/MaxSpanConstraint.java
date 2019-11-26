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

  public String getName(){
    return "MaxSpanConstraint";
  }

  public boolean isMaxSpan(){
    int time=0;
    for (Activity a: activities){
      time=time+a.getDuree();
    }
    if (time > this.getMaxSpan()){
      return false;
    }
    return true;
  }

  public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> hashmap){
    if ( ! this.isMaxSpan()){
      return false;
    }
    return true;
  }


}
