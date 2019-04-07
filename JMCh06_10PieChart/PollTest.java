/**
 *  TODO Runs the main method to print out name plus number of votes.
 *
 *  @author  TODO Kevin Deng
 *  @version TODO 9/13
 *  @author  Period: TODO 3
 *  @author  Assignment: JMCh06_10PieChart
 *
 *  @author  Sources: TODO list collaborators
 */
public class PollTest
{
    /**
     * TODO Prints the name and the corresponding number of votes.
     * @param args command-line argument - not used.
     */
    
    public static void main(String[] args)
    {
        PollDisplayPanel votingMachine = 
                        new PollDisplayPanel("Tami", "Brian", "Liz");
        votingMachine.vote1();
        votingMachine.vote2();
        votingMachine.vote2();
        System.out.println(votingMachine); 
    }
    /* TODO complete main method */
}
