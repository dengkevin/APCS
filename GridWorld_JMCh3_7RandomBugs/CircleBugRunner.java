import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Kevin Deng
   @version TODO 9/3

   @author  Period - TODO 3
   @author  Assignment - GridWorld Part 2, Random Bugs - CircleBugRunner

   @author  Sources - TODO list collaborators
 */

/* This class calls the CircleBug class with its act method only having
 * one turn method. Thus, the bugs are moving in 45 degree directions, rather
 * than the 90 degree box path in the BoxBugRunner class.
 */
public class CircleBugRunner
{
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        CircleBug alice = new CircleBug( 6 );
        alice.setColor( Color.ORANGE );
        CircleBug bob = new CircleBug( 3 );
        world.add( new Location( 7, 8 ), alice );
        world.add( new Location( 5, 5 ), bob );
        world.show();
        
    }
}