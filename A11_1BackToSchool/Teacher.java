/**
 * 
 *  TODO The teacher class creates a teacher object.
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
public class Teacher extends Person
{
    private String subject;
    private double salary;

/**
 * Constructs a Teacher object
 * @param myName  name of teacher
 * @param myAge  age of teacher
 * @param myGender  gender of teacher
 * @param subject  subject that the teacher teachers
 * @param salary  salary of college teacher
 */
    public Teacher(String myName, int myAge, String myGender, String subject, 
        double salary)
    {
        super(myName, myAge, myGender);
        
        this.subject = subject;
        this.salary = salary;
    }

/**
 * 
 * TODO returns the subject
 * @return  the subject of the teacher
 */
    public String getSubject()
    {
        return this.subject;
    }

/**
 * 
 * TODO returns the salary
 * @return  the salary of the teacher
 */
    public double getSalary()
    {
        return this.salary;
    }

/**
 * 
 * TODO   sets the subject to the field
 * @param subject  the subject the teacher teaches
 */
    public void setSubject(String subject)
    {
        this.subject = subject;
    }

/**
 * 
 * TODO   sets the salary to the field
 * @param salary   the salary of the teacher
 */
    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + subject +
            ", salary: " + salary;
    }
}
