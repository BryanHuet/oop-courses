package constraints;
import java.util.HashMap;

public class MeetConstraint extends BinaryConstraint{

  public MeetConstraint(Activity first, Activity second){
    super(first,second);
  }

  public String getName(){
    return "MeetConstraint";
  }

  public boolean isSatisfied(int date1, int date2) {
    return (this.first.getDuree()) <= (date2 - date1);
  }

    public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> object) {
      return this.isSatisfied(object.get(this.first), object.get(this.second));
    }


}
