package filrouge;
import filrouge.constraints.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map;
import scheduleio.*;
import java.io.IOException;
public class Main {
	public static void main (String [] args) {

	System.out.println("///////////////////////////////////////////////////////////");
		Reader R = new Reader(args[0],args[1]);
	  RandomScheduler finalTest = new RandomScheduler();
		for (Activity a: R.getActivity()){
			finalTest.addActivity(a);
		}
		for (Constraint c: R.readConstraint()){
			finalTest.addConstraint(c);
		}
		HashMap<Activity, Integer> final1=finalTest.edtRandom(100);
		for (Map.Entry<Activity, Integer> entry : final1.entrySet()) {
			System.out.println(entry.getKey().getDescription()+" : "+entry.getValue());
			}
		/*HashMap<Activity, Integer> final2=final1.edtRandom(50);
		for (Map.Entry<Activity, Integer> entry : final2.entrySet()) {
			System.out.println(entry.getKey().getDescription()+" : "+entry.getValue());
		}*/


 }
}
