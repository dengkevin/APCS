/**
 *  Instantiate and test various Checker objects.
 *
 *  @author  George Peck
 *  @version Oct 14, 2014
 *  @author  Period: 1-7
 *  @author  Assignment: A2008Q4_Checker
 *
 *  @author  Sources: TODO
 */
public class CheckerTester
{
    /**
     * Test checker objects.
     * @param args command line arguments (not used)
     */
    public static void main( String[] args )
    {
        //Checker aChecker = new SubstringChecker( "artichokes" );
        Checker kChecker = new SubstringChecker( "kale" );
        Checker yumChecker;

        Checker y1 = new SubstringChecker("artichokes");
        Checker y2 = new SubstringChecker("kale");
        yumChecker = new AndChecker(y1, y2);
        Checker eitherChecker1 = new NotChecker(y1);
        Checker eitherChecker2 = new NotChecker(y2);
        
        System.out.println(!(yumChecker.accept("chocolate truffles")) 
            && eitherChecker1.accept("chocolate truffles")
            && eitherChecker2.accept("chocolate truffles"));
        System.out.println(!(yumChecker.accept("kale is great"))
            && eitherChecker1.accept("kale is great")
            && eitherChecker2.accept("kale is great"));
        System.out.println(!(yumChecker.accept("Yuck: artichokes & kale"))
            && eitherChecker1.accept("Yuck: artichokes & kale")
            && eitherChecker2.accept("Yuck: artichokes & kale"));
        
    }
}
