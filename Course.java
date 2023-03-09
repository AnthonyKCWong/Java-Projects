package university;

import java.util.*;


public class Course
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Course Attributes
  private String id;

  //Course Associations
  private List<UniversityDepartment> universityDepartments;
  private List<Student> students;
  private Professor professor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Course(String aId, Professor aProfessor)
  {
    id = aId;
    universityDepartments = new ArrayList<UniversityDepartment>();
    students = new ArrayList<Student>();
    boolean didAddProfessor = setProfessor(aProfessor);
    if (!didAddProfessor)
    {
      throw new RuntimeException("Unable to create course due to professor. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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

  public String getId()
  {
    return id;
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
  /* Code from template association_GetOne */
  public Professor getProfessor()
  {
    return professor;
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
    if (aUniversityDepartment.indexOfCourse(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUniversityDepartment.addCourse(this);
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
    if (aUniversityDepartment.indexOfCourse(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUniversityDepartment.removeCourse(this);
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
    if (aStudent.indexOfCourse(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aStudent.addCourse(this);
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
    if (aStudent.indexOfCourse(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aStudent.removeCourse(this);
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
  /* Code from template association_SetOneToMany */
  public boolean setProfessor(Professor aProfessor)
  {
    boolean wasSet = false;
    if (aProfessor == null)
    {
      return wasSet;
    }

    Professor existingProfessor = professor;
    professor = aProfessor;
    if (existingProfessor != null && !existingProfessor.equals(aProfessor))
    {
      existingProfessor.removeCourse(this);
    }
    professor.addCourse(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<UniversityDepartment> copyOfUniversityDepartments = new ArrayList<UniversityDepartment>(universityDepartments);
    universityDepartments.clear();
    for(UniversityDepartment aUniversityDepartment : copyOfUniversityDepartments)
    {
      aUniversityDepartment.removeCourse(this);
    }
    ArrayList<Student> copyOfStudents = new ArrayList<Student>(students);
    students.clear();
    for(Student aStudent : copyOfStudents)
    {
      aStudent.removeCourse(this);
    }
    Professor placeholderProfessor = professor;
    this.professor = null;
    if(placeholderProfessor != null)
    {
      placeholderProfessor.removeCourse(this);
    }
  }


  public String toString()
  {
    return  "["+
           getId()+ "]" +
            " taught by " +getProfessor().getName();
  }
}
