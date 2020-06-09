package constraints;
import java.util.HashMap;

//Class mère de toute contrainte. Une contrainte est définie par un nom et
// si cette contrainte est validée ou non par un emploi du temps donné.
public interface Constraint{

    boolean isSatisfiedBySchedule(HashMap<Activity, Integer> hashmap);

    String getName();
}
