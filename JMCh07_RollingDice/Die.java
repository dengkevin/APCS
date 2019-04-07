/**
 *  Simulates a six-sided die.
 *
 *  @author  TODO Kevin Deng
 *  @version TODO 9/14
 *  @author  Period: TODO 3
 *  @author  Assignment: JMCh07_RollingDice
 *
 *  @author  Sources: TODO collaborators
 */
public class Die
{
    private int numDots;

    /**
     * Sets numDots to a random integer from 1 to 6
     */
    public void roll()
    {
        numDots = (int)(Math.random() * 6) + 1;
    }
    
    /**
     * Returns the value of the most recent roll.
     * @return numDots
     */
    public int getNumDots()
    {
        return numDots; // Fix this !!!
    }
}
