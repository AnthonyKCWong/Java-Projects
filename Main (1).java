package university;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    // Create department
    UniversityDepartment department = new UniversityDepartment("Science Building","Peterborough");

    
    
    

    
    ArrayList<Course> courselist = new ArrayList<Course>();
    // Create undergraduate students
    ArrayList<Student> students = new ArrayList<Student>();
    students.add(new Undergrad("Anthony Wong", "0768129",courselist));
    students.add(new Undergrad("Tyler Chin", "0760676",courselist));
    students.add(new Undergrad("Max Corbett", "0787791",courselist));
    students.add(new Undergrad("Jacky Li", "0772921",courselist));
    students.add(new Grad("Joe Smith", "1234", courselist,"Phd"));
    
    Professor omaralam = new Professor("Omar Alam");
    Course compscia = new Course("COIS 2240",omaralam);
    
    Professor richardhurley = new Professor("Richard Hurley");
    Course compscib = new Course("COIS 1020",richardhurley);
    
    
    // Add courses to undergraduate students
    for (Student student : students) {
      student.addCourse(compscia);
      student.addCourse(compscib);
    }

    // Add students to department
    for (Student student : students) {
    	department.addStudent(student);
      }
    

    // Loop over students
    for (Student student : students) {
    	
    	
    	System.out.print(student.getName()+"// ");
    	
    	if (student instanceof Undergrad)System.out.println("courses ="+student.printCourses());
    	else System.out.println("");
    	
      }
    
    
    
  }
}
