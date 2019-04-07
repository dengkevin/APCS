/**
 *  TODO The CollegeStudent class creates a college student object.
 *  TODO Pass in qualities in the parameters and the return will be a string
 *  joining all the qualities together.
 *
 *  @author  Kevin Deng
 *  @version Oct 21, 2018
 *  @author  Period: TODO 4
 *  @author  Assignment: A11_1BackToSchool
 *
 *  @author  Sources: TODO
 */
public class CollegeStudent extends Student
{
    private String major;
    private int year;

/**
 * Constructs a CollegeStudent object
 * @param myName  name of college student
 * @param myAge  age of college student
 * @param myGender  gender of college student
 * @param myIDNum  ID number of college student
 * @param myGPA  GPA of college student
 * @param year  year of college student
 * @param major  major of college student
 */
    public CollegeStudent(String myName, int myAge, String myGender, 
        String myIDNum, double myGPA, int year, String major)
    {
        super(myName, myAge, myGender, myIDNum, myGPA);
        
        this.major = major;
        this.year = year;
    }

/**
 * 
 * TODO returns the year (FROSH = 1, SOPH = 2, ...)
 * @return  the year of the college student
 */
    public int getYear()
    {
        return this.year;
    }

/**
 * 
 * TODO returns the major
 * @return  the major of the college student
 */
    public String getMajor()
    {
        return this.major;
    }

/**
 * 
 * TODO sets the year to the field
 * @param year  the year of the college student
 */
    public void setYear(int year)
    {
        this.year = year;
    }

/**
 * 
 * TODO sets the major to the field
 * @param major  the major of the college student
 */
    public void setMajor(String major)
    {
        this.major = major;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + year +
            ", major: " + major;
    }
}
