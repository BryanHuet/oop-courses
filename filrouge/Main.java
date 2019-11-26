package filrouge;
import java.util.HashMap;
import java.util.Map;
import scheduleio.*;
public class Main {
	public static void main (String [] args) {
 	System.out.println("");
	System.out.println("///////////////////////////////////////////////////////////");

		// On récupère les informations des deux fichiers mis en arguments
		Reader R = new Reader(args[0],args[1]);
	  RandomScheduler finalTest = new RandomScheduler();
		for (Activity a: R.getActivity()){
			finalTest.addActivity(a);
		}
		for (Constraint c: R.readConstraint()){
			finalTest.addConstraint(c);
		}
		// On essaye de trouver un emploi du temps qui valide toute les contraintes
		// sur x essaies;
		HashMap<Activity, Integer> final1=finalTest.edtRandom(50); // pour x = 50
		for (Map.Entry<Activity, Integer> entry : final1.entrySet()) {
			System.out.println(entry.getKey().getDescription()+" : "+entry.getValue());
			}
 }
}
