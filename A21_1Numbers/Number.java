import java.util.*;


/**
 * TODO Number Class. Represents a whole number with digit objects and a base
 * 
 * @author TODO Kevin Deng
 * @version TODO 4/5/19
 * 
 * @author Period - TODO 3
 * @author Assignment - TODO Numbers
 * 
 * @author Sources - TODO none
 */
public class Number
{
    private int base;

    private ArrayList<Digit> arr;


    /**
     * constructs a number object
     */
    public Number()
    {
        arr = new ArrayList<Digit>();
        arr.add( new Digit() );
        base = 10;
    }


    /**
     * constructs a number object
     * @param value  the number value
     * @param base  the base value
     */
    public Number( int value, int base )
    {
        arr = new ArrayList<Digit>();
        this.base = base;
        int mod = Integer.MAX_VALUE;
        while ( value > 0 )
        {
            mod = value % base;
            value = value / base;
            Digit d = new Digit( mod, base );
            arr.add( 0, d );
        }
    }


    /**
     * Increments the next "digit place" if the increment method in digit
     * class returns true
     */
    public void increment()
    {
        for ( int i = arr.size() - 1; i >= 0; i-- )
        {
            if (!( arr.get( i ).increment()))
            {
                return;
            }
        }
        
        Digit d = new Digit(1, base);
        // adds new digit if carryover
        arr.add( 0, d );
    }


    /**
     * toString method
     * @return toReturn
     */
    public String toString()
    {
        String toReturn = "";
        for ( Digit d : arr )
        {
            toReturn = toReturn + d.toString();
        }
        return toReturn;
    }
}
