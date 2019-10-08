package filrouge;

public class MeetConstraint extends BinaryConstraint{

  public MeetConstraint(Activity first, Activity second){
    super(first,second);
  }

  public boolean isSatisfied(int date1, int date2){
    if (this.first.getDuree()+this.second.getDuree() > (date2-date1)*60){
			return false;
			}
		return true;
		}

}
