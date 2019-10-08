package filrouge;
import java.util.List;
import java.util.HashMap;

public class Scheduler{

  public Scheduler(){}

  private HashMap iniNbPreds(List<PrecedenceConstraint>listeContrainte){
    int nbPreds=0;
    HashMap<Activity, Integer> hmap = new HashMap<>();
    for (PrecedenceConstraint c: listeContrainte){
    /* On souhait connaitre le nb de predecesseur a de chaque activite b,
    a->b ; donc si a n'est pas present dans hmap je l'ajoute. ici (a->b), a
    est la premiere activite  donc elle ne possede pas de predecesseur.
    */
      if (! hmap.containsKey(c.getFirst())){
        nbPreds=0;
        hmap.put(c.getFirst(),nbPreds);
      }
    /* Si b n'est pas present dans hmap, je l'ajoute avec pour nb de predecesseur 1 (a->b)
    */
      if (! hmap.containsKey(c.getSecond())){
        nbPreds=1;
        hmap.put(c.getSecond(),nbPreds);
    /* Si b est deja present, (a->b; c->b), c'est que b possede plusieurs predecesseurs donc,
    on recupere le nb de predecesseur de b dans hmap, et on l'incremente de 1.
    */
    }else{
        nbPreds=hmap.get(c.getSecond())+1;
        hmap.replace(c.getSecond(),nbPreds);
      }
    }
    return hmap;
  }

  private void scheduleActivity(Activity act, int minute, List<PrecedenceConstraint>listeContrainte, HashMap<Activity, Integer> planpartiel, HashMap<Activity, Integer> nbPreds){
    int heureCourante = 0;
    if (! planpartiel.containsKey(act)){
        if (planpartiel.size() == 0){
          if (nbPreds.get(act)==0){
            planpartiel.put(act,heureCourante);
          }
        }
      }
  }

/*
  public HashMap computeSchedule(List<PrecedenceConstraint>listeContrainte){

  }
*/

}
