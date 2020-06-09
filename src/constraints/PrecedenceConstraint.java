package constraints;
import java.util.HashMap;

/* class permettant de représenter des contraintes de précédence
	On cherche a représenter une activité devant être planifiée avant
	et celle devant être planifiée après.
*/

public class PrecedenceConstraint extends BinaryConstraint{

	public PrecedenceConstraint(Activity first, Activity second){
		super(first,second);

		}
		public String getName(){
			return "PrecedenceConstraint between <"+this.first.getDescription()+"> and <"+this.second.getDescription()+">";
		}

	public boolean isSatisfied(int date1, int date2) {
		return (this.first.getDuree() + date1) * 60 <= date2 * 60;
	}

	public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> object) {
		return this.isSatisfied(object.get(this.first), object.get(this.second));
	}

}
