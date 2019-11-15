package filrouge;
import filrouge.constraints.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
public class Main {
	public static void main (String [] args) {

	Activity cafe = new Activity ("Boire un café", 5);
	Activity cours = new Activity ("Cours de POO", 75);
	Activity campus = new Activity ("Aller au campus", 5);
	Activity lireMail = new Activity ("Lire mon courrier électronique", 5);

	// Definition of constraints
	PrecedenceConstraint c1 = new PrecedenceConstraint (cafe, campus);
	PrecedenceConstraint c2 = new PrecedenceConstraint (campus, cours);
	PrecedenceConstraint c3 = new PrecedenceConstraint (lireMail, cours);

	RandomScheduler test = new RandomScheduler();
	test.addActivity(cafe);
	test.addActivity(cours);
	test.addActivity(campus);
	test.addConstraint(c1);
	test.addConstraint(c2);
	HashMap<Activity, Integer> test1=test.edt();

	HashMap<Activity, Integer> test2=test.edtRandom(50);

	for (Map.Entry<Activity, Integer> entry : test2.entrySet()) {
    System.out.println(entry.getKey().getDescription()+" : "+entry.getValue());
}
 }
}
