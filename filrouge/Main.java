package filrouge;
import filrouge.constraints.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
public class Main {
	public static void main (String [] args) {

	Activity options = new Activity ("Choisir mes options", 70);
	Activity ip = new Activity ("Inscription pédagogique", 30);
	PrecedenceConstraintWithGap contrainte = new PrecedenceConstraintWithGap (options, ip,30);


	Activity cafe = new Activity ("Boire un café", 10);
	Activity cours = new Activity ("Cours de POO", 75);
	Activity campus = new Activity ("Aller au campus", 30);
	Activity lireMail = new Activity ("Lire mon courrier électronique", 5);


	// Definition of constraints
	PrecedenceConstraint c1 = new PrecedenceConstraint (cafe, campus);
	PrecedenceConstraint c2 = new PrecedenceConstraint (campus, cours);
	PrecedenceConstraint c3 = new PrecedenceConstraint (lireMail, cours);
	List<PrecedenceConstraint> allConstraints = Arrays.asList (c1, c2, c3);

	HashMap<Activity, Integer> schedule = new HashMap<Activity, Integer> ();
	schedule.put(cafe,0);
	schedule.put(campus,2);
	schedule.put(cours,31);

	NegationConstraint contrainteC = new NegationConstraint(c2);
	System.out.println("Contrainte c2 ? "+c2.isSatisfiedBySchedule(schedule));
	System.out.println("Negation de c2 ? "+contrainteC.isSatisfiedBySchedule(schedule));

	DisjunctionConstraint dijonc = new DisjunctionConstraint(c1, c2);
	System.out.println("Contrainte c1 ou c2 ? "+dijonc.isSatisfiedBySchedule(schedule));

 }
}
