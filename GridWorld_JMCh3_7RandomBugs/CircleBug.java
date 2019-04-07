import info.gridworld.actor.Bug;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Kevin Deng
   @version TODO 9/3

   @author  Period - TODO 3
   @author  Assignment - GridWorld Part 2, Random bugs - CircleBug

   @author  Sources - TODO list collaborators
 */
public class CircleBug extends Bug
{
    private int steps;
    private int sideLength;
    
    // TODO instance variables

    public CircleBug( int n )
    {
        steps = 0;
        sideLength = n;
        // TODO complete constructor
    }

    public void act()
    {
        if ( steps < sideLength && canMove() )
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
}