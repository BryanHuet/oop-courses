package constraints;

import java.util.HashMap;
import java.util.List;

public class MaxSpanConstraint implements Constraint {
  protected List<Activity> activities;
  protected int maxspan;

  public MaxSpanConstraint(List<Activity> activities, int maxspan) {
    this.activities = activities;
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
    return time <= this.getMaxSpan();
  }

  public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> hashmap){
    return this.isMaxSpan();
  }


}
