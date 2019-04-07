import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

import java.awt.Color;

/**
 *  TODO The BlusterCritter class analyzes Actors around the "Bluster Critter."
 *  It adjusts the color of the BlusterCritter depending on how many critters
 *  surround the BlusterCritter.
 *  TODO There are two fields. One is the c value which determines when the 
 *  color of the blustercritter start to change. The other is a final constant,
 *  the darkening factor. The getActors method returns all the possible actors
 *  within two spaces from the BlusterCritter. The processActors method then
 *  processes the Actors and sees which ones are Critter Actors. This ultimately
 *  determines the color of the BlusterCritter when it moves around the grid.
 *
 *  @author  TODO Kevin Deng
 *  @version TODO 11/10/18
 *  @author  Period: TODO 3
 *  @author  Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 *
 *  @author  Sources: TODO I received help from ...
 */
public class BlusterCritter extends Critter
{
    private int c;
    private static final double DARKENING_FACTOR = 0.05;

/**
 * Constructs a BlusterCritter object
 * @param c  the number of critters before the BlusterCritter changes color
 */
    public BlusterCritter( int c )
    {
        this.c = c;
    }

    /**
     * TODO Returns all possible actors in an ArrayList within 2 "spaces" from
     * the BlusterCritter.
     * <br />
     * Postcondition: The state of all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();

        Location loc = getLocation();
        
        for (int i = loc.getRow() - 2; i <= loc.getRow() + 2; i++)
        {
            for (int j = loc.getCol() - 2; j <= loc.getCol() + 2; j++) {
                
                Location tempLoc = new Location(i, j);
                if (gr.isValid(tempLoc))
                {
                    Actor tempActor = gr.get(tempLoc);
                    
                    /*if tempActor does not equal the current blusterCritter
                     * or have no value attached to it
                     */
                    if (tempActor != null && tempActor != this)
                    {
                        actors.add(tempActor);
                    }
                }
            }
        }
        
        return actors;
    }

    /**
     * TODO Processes all the actors and sees which ones are critters. This
     * determines the color of the BlusterCritter.
     * <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * 
     * @param actors the actors to be processed
     */
    public void processActors( ArrayList<Actor> actors )
    {
        ArrayList<Actor> totalActors = getActors();
        int total = 0;
        
        for (Actor a : totalActors)
        {
            if (a instanceof Critter)
            {
                total++;
            }
        }
        if (total >= c)
        {
            darken();
        }
        if (total < c)
        {
            lighten();
        }
    }

    /**
     * TODO Darkens the critter.
     */
    private void darken()
    {
        Color co = getColor();
        int red = Math.max((int) (co.getRed() * (1 - DARKENING_FACTOR)), 0);
        int green = Math.max((int) (co.getGreen() * (1 - DARKENING_FACTOR)), 0);
        int blue = Math.max((int) (co.getBlue() * (1 - DARKENING_FACTOR)), 0);

        setColor(new Color(red, green, blue));
    }

    /**
     * TODO Lightens the critter.
     */
    private void lighten()
    {
        Color co = getColor();
        int red = Math.min((int) (co.getRed() * (1 + DARKENING_FACTOR)), 255);
        int green = Math.min((int) (co.getGreen() * 
                        (1 + DARKENING_FACTOR)), 255);
        int blue = Math.min((int) (co.getBlue() * (1 + DARKENING_FACTOR)), 255);

        setColor(new Color(red, green, blue));
    }
}
