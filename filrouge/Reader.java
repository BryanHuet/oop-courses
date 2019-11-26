package filrouge;
import scheduleio.*;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
public class Reader{
  protected HashMap<String,Activity> activities;
  protected String fileConstraint;

  public Reader(String file1, String file2){
    ActivityReader actR = new ActivityReader(file1);
    HashMap<String,Activity> tmpMap = new HashMap<String,Activity>();
    try {
      for (Map.Entry<String, ActivityDescription> entry : actR.readAll().entrySet()) {
        Activity tmp = new Activity(entry.getValue().getName(),entry.getValue().getDuration());
        tmpMap.put(entry.getKey(),tmp);
  			}
    }catch (IOException e){
      System.err.println(e.getMessage());
      System.exit(2);
    }
    this.activities=tmpMap;
    this.fileConstraint=file2;
  }

  public List<Activity> getActivity(){
    List<Activity> tmpList=new ArrayList<Activity>();
    for (Map.Entry<String, Activity> entry : this.activities.entrySet()){
      tmpList.add(entry.getValue());
    }
    return tmpList;
  }

  public PrecedenceConstraint getPrecedenceConstraint(String[] act){
    Activity first=this.activities.get(act[0]);
    Activity second=this.activities.get(act[1]);
    PrecedenceConstraint contrainte = new PrecedenceConstraint(first,second);
    return contrainte;
  }
  public PrecedenceConstraintWithGap getPrecedenceConstraintWithGap(String[] act){
    Activity first=this.activities.get(act[1]);
    Activity second=this.activities.get(act[2]);
    int gap = Integer.parseInt(act[0]);
    PrecedenceConstraintWithGap contrainte = new PrecedenceConstraintWithGap(first,second,gap);
    return contrainte;
  }
  public MeetConstraint getMeetConstraint(String[] act){
    Activity first=this.activities.get(act[0]);
    Activity second=this.activities.get(act[1]);
    MeetConstraint contrainte = new MeetConstraint(first,second);
    return contrainte;
  }
public MaxSpanConstraint getMaxSpanConstraint(String[] act){
    String[] tmpStr = act;
    int maxSpan = Integer.parseInt(tmpStr[0]);
    List <String> tmp=new ArrayList<String>();
    for (String a: tmpStr){
      tmp.add(a);
    }
    tmp.remove(tmpStr[0]);
    List<Activity> listAct = new ArrayList<Activity>();
    for (String a: tmp){
      listAct.add(this.activities.get(a));
    }
    MaxSpanConstraint contrainte = new MaxSpanConstraint(listAct,maxSpan);
    return contrainte;
  }

  public List<Constraint> readConstraint(){
    ConstraintReader constR = new ConstraintReader(this.fileConstraint);
    List<Constraint> tmpList = new ArrayList<Constraint>();
    try {
      for (ConstraintDescription entry : constR.readAll()) {
      if (entry.getKeyword().equals("PRECEDENCE")){
        tmpList.add(this.getPrecedenceConstraint(entry.getArguments()));
      }
      if (entry.getKeyword().equals("PRECEDENCE_GAP")){
        tmpList.add(this.getPrecedenceConstraintWithGap(entry.getArguments()));
      }
      if (entry.getKeyword().equals("MEET")){
        tmpList.add(this.getMeetConstraint(entry.getArguments()));
      }
      if (entry.getKeyword().equals("MAX_SPAN")){
        tmpList.add(this.getMaxSpanConstraint(entry.getArguments()));
      }
  			}
    }catch (IOException e){
      System.err.println(e.getMessage());
      System.exit(2);
    }
    return tmpList;
  }

}
