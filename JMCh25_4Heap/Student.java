/**
   Student.java

   Stores the following information about students
      grade
      name (first and last)
      Lynbrook id

 */
public class Student implements Comparable
{
    private String lynbrookId;
    private String firstName;
    private String lastName;
    private int grade;

    public Student( String id, String fName, String lName, int g )
    {
        lynbrookId = id;
        firstName = fName;
        lastName = lName;
        grade = g;
    }

    public Student()
    {
        this( "", "", "", 0 );
    }

    /**
     * TODO Compares the grades of each student. If they are equal, then compare
     * the lynbrookId. Otherwise, return the difference in grades.
     * 
     * @param obj  the other student
     * @return  the difference in lynbrookId/grades
     */
    public int compareTo( Object obj )
    {
        Student s = (Student)obj;
        
        if (grade == s.grade)
        {
            return lynbrookId.compareTo(s.lynbrookId);
        }
        return grade - s.grade;
    }

    public Object clone()
    {
        return new Student( lynbrookId, firstName, lastName, grade );
    }

    public String toString()
    {
        return lynbrookId + " " + firstName + " " + lastName + " " + grade;
    }
}
