package university;

import java.util.*;

public class UniversityDepartment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UniversityDepartment Attributes
  private String departmentName;
  private String location;

  //UniversityDepartment Associations
  private List<Student> students;
  private List<Course> courses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UniversityDepartment(String aDepartmentName, String aLocation)
  {
    departmentName = aDepartmentName;
    location = aLocation;
    students = new ArrayList<Student>();
    courses = new ArrayList<Course>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDepartmentName(String aDepartmentName)
  {
    boolean wasSet = false;
    departmentName = aDepartmentName;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public String getDepartmentName()
  {
    return departmentName;
  }

  public String getLocation()
  {
    return location;
  }
  /* Code from template association_GetMany */
  public Student getStudent(int index)
  {
    Student aStudent = students.get(index);
    return aStudent;
  }

  public List<Student> getStudents()
  {
    List<Student> newStudents = Collections.unmodifiableList(students);
    return newStudents;
  }

  public int numberOfStudents()
  {
    int number = students.size();
    return number;
  }

  public boolean hasStudents()
  {
    boolean has = students.size() > 0;
    return has;
  }

  public int indexOfStudent(Student aStudent)
  {
    int index = students.indexOf(aStudent);
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
  public static int minimumNumberOfStudents()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addStudent(Student aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    students.add(aStudent);
    if (aStudent.indexOfUniversityDepartment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aStudent.addUniversityDepartment(this);
      if (!wasAdded)
      {
        students.remove(aStudent);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeStudent(Student aStudent)
  {
    boolean wasRemoved = false;
    if (!students.contains(aStudent))
    {
      return wasRemoved;
    }

    int oldIndex = students.indexOf(aStudent);
    students.remove(oldIndex);
    if (aStudent.indexOfUniversityDepartment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aStudent.removeUniversityDepartment(this);
      if (!wasRemoved)
      {
        students.add(oldIndex,aStudent);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStudentAt(Student aStudent, int index)
  {  
    boolean wasAdded = false;
    if(addStudent(aStudent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudents()) { index = numberOfStudents() - 1; }
      students.remove(aStudent);
      students.add(index, aStudent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStudentAt(Student aStudent, int index)
  {
    boolean wasAdded = false;
    if(students.contains(aStudent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudents()) { index = numberOfStudents() - 1; }
      students.remove(aStudent);
      students.add(index, aStudent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStudentAt(aStudent, index);
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
    if (aCourse.indexOfUniversityDepartment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCourse.addUniversityDepartment(this);
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
    if (aCourse.indexOfUniversityDepartment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCourse.removeUniversityDepartment(this);
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
    ArrayList<Student> copyOfStudents = new ArrayList<Student>(students);
    students.clear();
    for(Student aStudent : copyOfStudents)
    {
      aStudent.removeUniversityDepartment(this);
    }
    ArrayList<Course> copyOfCourses = new ArrayList<Course>(courses);
    courses.clear();
    for(Course aCourse : copyOfCourses)
    {
      aCourse.removeUniversityDepartment(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "departmentName" + "=" + (getDepartmentName() != null ? !getDepartmentName().equals(this)  ? getDepartmentName().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "location" + "=" + (getLocation() != null ? !getLocation().equals(this)  ? getLocation().toString().replaceAll("  ","    ") : "this" : "null");
  }
}