package filrouge;
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


	Scheduler schedule = new Scheduler();
	System.out.println("hello");



 }
}
