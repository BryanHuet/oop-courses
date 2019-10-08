package filrouge;
// Class permettant de creer une activité
public class Activity {
	protected String description;
	protected int duree;

	public Activity(String description, int duree){
		this.description=description;
		this.duree=duree;
		}
	public int getDuree(){
		return this.duree;
	}
	public String getdescription(){
		return this.description;
	}
}
