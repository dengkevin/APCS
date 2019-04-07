
/**
 * Question 24-20
 * 
 *  Write a hashCode method for this class that agrees with the equals method
 *  and returns different values for Persons of different ages.
 *
 *  @author  TODO Kevin Deng
 *  @version TODO 2/28/19
 *  @author  Period: TODO 3
 *  @author  Assignment: JMCh24Exercises Question 20
 *
 *  @author  Sources: TODO none
 */
public class Person
{
    private String name;
    private int age; // age <= 125

    public Person( String name, int age )
    {
        this.name = name;
        this.age = age;
    }

    public boolean equals( Object other )
    {
        if ( !( other instanceof Person ) )
        {
            return false;
        }
        Person otherPerson = (Person)other;
        return name.equals( otherPerson.name ) && age == otherPerson.age;
    }

    public int hashCode()
    {
        return name.hashCode() + age;
    }

}

