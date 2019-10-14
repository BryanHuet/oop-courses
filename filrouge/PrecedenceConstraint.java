package filrouge;
import java.util.HashMap;

/* class permettant de représenter des contraintes de précédence
	On cherche a représenter une activité devant être planifiée avant
	et celle devant être planifiée après.
*/

public class PrecedenceConstraint extends BinaryConstraint{

	public PrecedenceConstraint(Activity first, Activity second){
		super(first,second);

		}

	public boolean isSatisfied(int date1, int date2){
		if (this.first.getDuree()+date1*60 > date2*60){
			return false;
			}
		return true;
		}

	public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> object){
		if (! this.isSatisfied(object.get(this.first),object.get(this.second))){
	      System.out.println("La contrainte PrecedenceConstraint nest pas satisfaite");
			return false;
		}
		return true;
	}

}
