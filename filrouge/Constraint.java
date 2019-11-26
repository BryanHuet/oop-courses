package filrouge;
import java.util.HashMap;

//Class mère de toute contrainte. Une contrainte est définie par un nom et
// si cette contrainte est validée ou non par un emploi du temps donné.
public interface Constraint{

  public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> hashmap);

  public String getName();
}
