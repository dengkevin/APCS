/**
   TODO Represents a single digit, checking if it is able to increment
   
   @author  TODO Kevin Deng
   @version TODO 4/5/19

   @author  Period - TODO 3
   @author  Assignment - TODO Numbers

   @author  Sources - TODO none
 */
public class Digit
{
    private int base;
    private int value;
    
    /**
     * Constructs a digit object
     */
    public Digit()
    {
        value = 0;
        base = 10;
    }
   
    /**
     * Constructs a digit object
     * @param value  the value of the digit
     * @param base  the base of the number
     */
    public Digit(int value, int base)
    {
        this.value = value;
        this.base = base;
    }
    
    /**
     * 
     * determines if the digit should increment (carry-over)
     * @return  true/false if digit can increment
     */
    public boolean increment()
    {
        if (value + 1 == base)
        {
            value = 0;
            return true;
        }
        else
        {
            value = value + 1;
            return false;
        }
    }
    
    /**
     * toString method
     * @return  complete String for the digit accounting the base value too
     */
    public String toString()
    {
        if (value < 10)
        {
            return "" + value;
        }
        else
        {
            char c = (char)(value - 10 + 'a');
            return "" + c;
        }
    }
}