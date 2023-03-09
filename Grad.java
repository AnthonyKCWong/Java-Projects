package university;
import java.util.*;

public class Grad extends Student implements ResearchInterface
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Grad Attributes
  private String degreeLevel;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Grad(String aName, String aId, ArrayList aClasses, String aDegreeLevel)
  {
    super(aName, aId, aClasses);
    degreeLevel = aDegreeLevel;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDegreeLevel(String aDegreeLevel)
  {
    boolean wasSet = false;
    degreeLevel = aDegreeLevel;
    wasSet = true;
    return wasSet;
  }

  public String getDegreeLevel()
  {
    return degreeLevel;
  }

  public void delete()
  {
    super.delete();
  }

  @Override
  public void doResearch(){
          return ;
  }

  @Override
  public String toString()
  {
    return super.toString() + "["+ "]" +
            "  " + "degreeLevel" + "=" + (getDegreeLevel() != null ? !getDegreeLevel().equals(this)  ? getDegreeLevel().toString().replaceAll("  ","    ") : "this" : "null");
  }
}