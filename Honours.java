package university;

import java.util.*;

public class Honours extends Undergrad implements ResearchInterface
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Honours(String aName, String aId, ArrayList aClasses)
  {
    super(aName, aId, aClasses);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

  @Override
  public void doResearch(){
          return ;
  }

}
