package constraints;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint {
  protected int gap;

  public PrecedenceConstraintWithGap(Activity first, Activity second, int gap) {
    super(first, second);
    this.gap = gap;
  }

  public String getName() {
    return "PrecedenceConstraintWithGap";
  }

  public boolean isSatisfied(int date1, int date2) {
    return this.first.getDuree() + date1 * 60 + this.gap <= date2 * 60;
  }

}
