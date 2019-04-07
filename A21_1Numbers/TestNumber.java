/**
 * 
 *  TODO Tester class for Number
 *
 *  @author  Kevin Deng
 *  @version 4/5/2019
 *  @author  Period: TODO 3
 *  @author  Assignment: A21_1Numbers
 *
 *  @author  Sources: TODO none
 */
public class TestNumber
{
    /**
     * main method
     * @param args  not used
     */
    public static void main( String[] args )
    {
        int[] base = { 2, 8, 10, 16 };

        for ( int b = 0; b < base.length; b++ )
        {
            Number n = new Number( 0, base[b] );
            System.out.println( "\nbase=" + base[b] );
            for ( int i = 0; i < 256; i++ )
            {
                System.out.println( n );
                n.increment();
            }
        }
    }
}
