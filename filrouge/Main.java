package filrouge;
import filrouge.constraints.*;
import java.util.HashMap;
import java.util.Map;
import scheduleio.*;
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
		HashMap<Activity, Integer> final1=finalTest.edtRandom(1000);
		for (Map.Entry<Activity, Integer> entry : final1.entrySet()) {
			System.out.println(entry.getKey().getDescription()+" : "+entry.getValue());
			}
/*
			Activity bus = new Activity("bus",30);
			Activity cm = new Activity("cm",70);
			MeetConstraint mc = new MeetConstraint(bus,cm);
			HashMap<Activity,Integer> test = new HashMap<Activity,Integer>();
			test.put(bus,10);
			test.put(cm,41);
			System.out.println(mc.isSatisfiedBySchedule(test));
			*/
 }
}
