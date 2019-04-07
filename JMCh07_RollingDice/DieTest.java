/**
 * Tests the simulated die.
 */
public class DieTest
{
    /**
     * 
     * TODO Invokes the Die class and roles a die 3 times.
     * @param args command-line argument - not used.
     */
  public static void main(String[] args)
  {
    Die die = new Die();
    die.roll();
    System.out.println(die.getNumDots());
    die.roll();
    System.out.println(die.getNumDots());
    die.roll();
    System.out.println(die.getNumDots());
  }
}
