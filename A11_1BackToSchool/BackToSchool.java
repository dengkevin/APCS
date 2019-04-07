/**
 * 
 *  TODO The BackToSchool class creates different people ranging from the
 *  general person to specific people like college students and prints out
 *  their status and qualities.
 *  TODO To use the class, pass in parameters that serve as information about 
 *  the person and a new string will be printed out that states every single
 *  quality a person has.
 *
 *  @author  Kevin Deng
 *  @version Oct 21, 2018
 *  @author  Period: TODO 3
 *  @author  Assignment: A11_1BackToSchool
 *
 *  @author  Sources: TODO
 */
public class BackToSchool
{
    public static void main( String args[] )
    {
        Person bob = new Person( "Coach Bob", 27, "M" );
        System.out.println( bob );

        Student lynne = new Student( "Lynne Brooke", 16, "F",
            "HS95129", 3.5 );
        System.out.println( lynne );

        Teacher mrJava = new Teacher( "Duke Java", 34, "M",
            "Computer Science", 50000 );
        System.out.println( mrJava );

        CollegeStudent ima = new CollegeStudent( "Ima Frosh", 18, "F",
            "UCB123", 4.0, 1, "English" );
        System.out.println( ima );
    }
}
