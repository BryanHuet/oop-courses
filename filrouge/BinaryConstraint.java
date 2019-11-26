package filrouge;

public abstract class BinaryConstraint implements Constraint{
  protected Activity first;
  protected Activity second;

  public BinaryConstraint(Activity first, Activity second){
    this.first = first;
    this.second = second;
  }

  public String getName(){
    return "BinaryConstraint";
  }

  public Activity getFirst(){
    return this.first;
  }
  public Activity getSecond(){
    return this.second;
  }
}
