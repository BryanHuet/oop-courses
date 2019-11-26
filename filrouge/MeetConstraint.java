package filrouge;
import java.util.HashMap;

public class MeetConstraint extends BinaryConstraint{

  public MeetConstraint(Activity first, Activity second){
    super(first,second);
  }

  public String getName(){
    return "MeetConstraint";
  }

  public boolean isSatisfied(int date1, int date2){
    if ((this.first.getDuree()) > (date2-date1)){
			return false;
			}
		return true;
		}

    public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> object){
      if ( ! this.isSatisfied(object.get(this.first),object.get(this.second))){
        return false;
  		}
  		return true;
  	}


}
