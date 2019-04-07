/**
 * 
 *  TODO The student class creates a student object.
 *  TODO Pass in qualities in the parameters and the return will be a string
 *  joining all the qualities together.
 *
 *  @author  Kevin Deng
 *  @version Oct 21, 2018
 *  @author  Period: TODO 3
 *  @author  Assignment: A11_1BackToSchool
 *
 *  @author  Sources: TODO
 */
public class Student extends Person
{
    private String myIdNum; // Student Id Number
    private double myGPA;   // grade point average
    
/**
 * Constructs a Student object
 * @param myName  name of student
 * @param myAge  age of student
 * @param myGender  gender of student
 * @param myIDNum  ID number of student
 * @param myGPA  GPA of student
 */
    public Student( String name, int age, String gender, String idNum,
                    double gpa )
    {
        // use the super class' constructor
        super( name, age, gender );

        // initialize what's new to Student
        myIdNum = idNum;
        myGPA = gpa;
    }

/**
 * 
 * TODO returns the IdNum
 * @return  the IdNum of the student
 */
    public String getIdNum()
    {
        return myIdNum;
    }

/**
 * 
 * TODO returns the GPA
 * @return  the GPA of the student
 */
    public double getGPA()
    {
        return myGPA;
    }

/**
 * 
 * TODO sets the IdNum to the field
 * @param   the IdNum of the student
 */
    public void setIdNum( String idNum )
    {
        myIdNum = idNum;
    }

/**
 * 
 * TODO sets the gpa to the field
 * @param   the gpa of the college student
 */
    public void setGPA( double gpa )
    {
        myGPA = gpa;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", student id: " +
            myIdNum + ", gpa: " + myGPA;
    }
}
