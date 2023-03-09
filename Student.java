package university;
import java.util.*;

/**
 * association PrerequisiteReason { 
 * Course successor;
 * Course prerequisite;
 * }
 * association MutualExclusionReason { 
 * Course;
 * Course isMutualyExclusiveWith;
 * }
 * Positioning
 */

public class Student extends Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Student Attributes
  private String id;
  private ArrayList classes;

  //Student Associations
  private List<UniversityDepartment> universityDepartments;
  private List<Course> courses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Student(String aName, String aId, ArrayList aClasses)
  {
    super(aName);
    id = aId;
    classes = aClasses;
    universityDepartments = new ArrayList<UniversityDepartment>();
    courses = new ArrayList<Course>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setClasses(ArrayList aClasses)
  {
    boolean wasSet = false;
    classes = aClasses;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public ArrayList getClasses()
  {
    return classes;
  }
  /* Code from template association_GetMany */
  public UniversityDepartment getUniversityDepartment(int index)
  {
    UniversityDepartment aUniversityDepartment = universityDepartments.get(index);
    return aUniversityDepartment;
  }

  public List<UniversityDepartment> getUniversityDepartments()
  {
    List<UniversityDepartment> newUniversityDepartments = Collections.unmodifiableList(universityDepartments);
    return newUniversityDepartments;
  }

  public int numberOfUniversityDepartments()
  {
    int number = universityDepartments.size();
    return number;
  }

  public boolean hasUniversityDepartments()
  {
    boolean has = universityDepartments.size() > 0;
    return has;
  }

  public int indexOfUniversityDepartment(UniversityDepartment aUniversityDepartment)
  {
    int index = universityDepartments.indexOf(aUniversityDepartment);
    return index;
  }
  /* Code from template association_GetMany */
  public Course getCourse(int index)
  {
    Course aCourse = courses.get(index);
    return aCourse;
  }

  public List<Course> getCourses()
  {
    List<Course> newCourses = Collections.unmodifiableList(courses);
    return newCourses;
  }

  public int numberOfCourses()
  {
    int number = courses.size();
    return number;
  }

  public boolean hasCourses()
  {
    boolean has = courses.size() > 0;
    return has;
  }

  public int indexOfCourse(Course aCourse)
  {
    int index = courses.indexOf(aCourse);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUniversityDepartments()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addUniversityDepartment(UniversityDepartment aUniversityDepartment)
  {
    boolean wasAdded = false;
    if (universityDepartments.contains(aUniversityDepartment)) { return false; }
    universityDepartments.add(aUniversityDepartment);
    if (aUniversityDepartment.indexOfStudent(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUniversityDepartment.addStudent(this);
      if (!wasAdded)
      {
        universityDepartments.remove(aUniversityDepartment);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeUniversityDepartment(UniversityDepartment aUniversityDepartment)
  {
    boolean wasRemoved = false;
    if (!universityDepartments.contains(aUniversityDepartment))
    {
      return wasRemoved;
    }

    int oldIndex = universityDepartments.indexOf(aUniversityDepartment);
    universityDepartments.remove(oldIndex);
    if (aUniversityDepartment.indexOfStudent(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUniversityDepartment.removeStudent(this);
      if (!wasRemoved)
      {
        universityDepartments.add(oldIndex,aUniversityDepartment);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUniversityDepartmentAt(UniversityDepartment aUniversityDepartment, int index)
  {  
    boolean wasAdded = false;
    if(addUniversityDepartment(aUniversityDepartment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUniversityDepartments()) { index = numberOfUniversityDepartments() - 1; }
      universityDepartments.remove(aUniversityDepartment);
      universityDepartments.add(index, aUniversityDepartment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUniversityDepartmentAt(UniversityDepartment aUniversityDepartment, int index)
  {
    boolean wasAdded = false;
    if(universityDepartments.contains(aUniversityDepartment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUniversityDepartments()) { index = numberOfUniversityDepartments() - 1; }
      universityDepartments.remove(aUniversityDepartment);
      universityDepartments.add(index, aUniversityDepartment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUniversityDepartmentAt(aUniversityDepartment, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCourses()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addCourse(Course aCourse)
  {
    boolean wasAdded = false;
    if (courses.contains(aCourse)) { return false; }
    courses.add(aCourse);
    if (aCourse.indexOfStudent(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCourse.addStudent(this);
      if (!wasAdded)
      {
        courses.remove(aCourse);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeCourse(Course aCourse)
  {
    boolean wasRemoved = false;
    if (!courses.contains(aCourse))
    {
      return wasRemoved;
    }

    int oldIndex = courses.indexOf(aCourse);
    courses.remove(oldIndex);
    if (aCourse.indexOfStudent(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCourse.removeStudent(this);
      if (!wasRemoved)
      {
        courses.add(oldIndex,aCourse);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCourseAt(Course aCourse, int index)
  {  
    boolean wasAdded = false;
    if(addCourse(aCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCourses()) { index = numberOfCourses() - 1; }
      courses.remove(aCourse);
      courses.add(index, aCourse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCourseAt(Course aCourse, int index)
  {
    boolean wasAdded = false;
    if(courses.contains(aCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCourses()) { index = numberOfCourses() - 1; }
      courses.remove(aCourse);
      courses.add(index, aCourse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCourseAt(aCourse, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<UniversityDepartment> copyOfUniversityDepartments = new ArrayList<UniversityDepartment>(universityDepartments);
    universityDepartments.clear();
    for(UniversityDepartment aUniversityDepartment : copyOfUniversityDepartments)
    {
      aUniversityDepartment.removeStudent(this);
    }
    ArrayList<Course> copyOfCourses = new ArrayList<Course>(courses);
    courses.clear();
    for(Course aCourse : copyOfCourses)
    {
      aCourse.removeStudent(this);
    }
    super.delete();
  }
  
  
  public String printCourses()
  {
	  String x="";
	  for (Course course: this.getCourses()) {
		  x=x+course.toString()+" ";
	  }
	  return x;
	  
  }

  
  public String toString()
  {
    return super.toString() +"  " + "id" + "=" + (getId() != null ? !getId().equals(this)  ? getId().toString().replaceAll("  ","    ") : "this" : "null") +
            "  " + "classes" + "=" + this.printCourses();
  }
}