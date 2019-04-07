/**
 * 
 *  TODO The person class creates a Person object.
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
public class Person
{
    private String myName;   // name of the person
    private int myAge;       // person's age
    private String myGender; // 'M' for male, 'F' for female

    /**
     * Constructs a Person object
     * @param myName  name of person
     * @param myAge  age of person
     * @param myGender  gender of person
     */
        
    public Person( String name, int age, String gender )
    {
        myName = name;
        myAge = age;
        myGender = gender;
    }

/**
 * 
 * TODO returns the name
 * @return  the name of the person
 */
    public String getName()
    {
        return myName;
    }

/**
 * 
 * TODO returns the age
 * @return  the age of the person
 */
    public int getAge()
    {
        return myAge;
    }

/**
 * 
 * TODO returns the gender
 * @return  the gender of the person
 */
    public String getGender()
    {
        return myGender;
    }

/**
 * 
 * TODO sets the name to the field
 * @param   the name of the person
 */
    public void setName( String name )
    {
        myName = name;
    }

/**
 * 
  * TODO sets the age to the field
 * @param   the age of the person
 */
    public void setAge( int age )
    {
        myAge = age;
    }

/**
 * 
 * TODO sets the gender to the field
 * @param   the gender of the person
 */
    public void setGender( String gender )
    {
        myGender = gender;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}