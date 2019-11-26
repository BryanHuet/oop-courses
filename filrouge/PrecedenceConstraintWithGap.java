package filrouge;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint{
  protected int gap;

  public PrecedenceConstraintWithGap(Activity first, Activity second, int gap){
    super(first,second);
    this.gap=gap;
  };
  public String getName(){
    return "PrecedenceConstraintWithGap";
  }

  public boolean isSatisfied(int date1, int date2){
    if (this.first.getDuree()+date1*60 +this.gap > date2*60 ){
			return false;
    };
		return true;
  };

}
