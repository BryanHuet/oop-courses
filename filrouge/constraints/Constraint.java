package filrouge.constraints;
import filrouge.*;

import java.util.HashMap;

public interface Constraint{

  public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> hashmap);
}
