import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;
import java.util.ArrayList;


/**
 * TODO Erases the entire object once you click on part of the object TODO This
 * class removes an entire object if you click on one tile of the object. It
 * does so recursively.
 *
 * @author TODO Kevin Deng
 * @version TODO 11/15
 * @author Period: TODO 3
 * @author Assignment: AB24_1EraseObject_GridWorld
 *
 * @author Sources: TODO
 */
public class EraseObject extends World<Tile>
{
    private static final Color IMGOBJ_COLOR = Color.BLACK;

    private static final Color ERASE_COLOR = Color.WHITE;


    /**
     * Constructs a default 20x20 grid containing black tiles at the locations
     * given in the file "digital.txt".
     * 
     */
    public EraseObject()
    {
        this( new BoundedGrid<Tile>( 20, 20 ), "digital.txt" );
    }


    /**
     * Constructs an EraseObject World with the provided grid. Populates the
     * world with black tile objects at the locations given in the specified
     * file (fName).
     * 
     * @param bg
     *            bounded grid used by this World
     * @param fName
     *            name of file containing location information for tile
     *            placement in this World
     */
    public EraseObject( BoundedGrid<Tile> bg, String fName )
    {
        setGrid( bg );
        getData( fName );

        setMessage( "Click on the object to be erased" );
    }


    /**
     * Overrides
     * <code>info.gridworld.world.World&lt;Tile&lt;.locationClicked</code> This
     * method is called when the user clicks on a location in the WorldFrame.
     * Invokes the recursive erase procedure on the clicked location.
     * 
     * @param loc
     *            the grid location that the user selected
     * @return true - the world consumes the click
     */
    public boolean locationClicked( Location loc )
    {
        Grid<Tile> gr = getGrid();

        setMessage( "Tile clicked at " + loc );
        erase( gr, loc.getRow(), loc.getCol() );

        return true;
    }


    /**
     * Loads the data from the specified file containing tile locations into the
     * this grid.
     * 
     * The first entry in the provided text file is the number of pairs that
     * follow (i.e., 55). Each subsequent line contains a pair of integers,
     * separated by a blank space. Each pair is a row and column coordinate that
     * specifies the location of a black tile in the starting grid.
     * 
     * @param fName
     *            name of file containing tile locations
     */
    private void getData( String fName )
    {
        File f = new File( fName );
        Scanner sc = new Scanner( System.in );

        try
        {
            sc = new Scanner( f );
        }
        catch ( FileNotFoundException e )
        {
            System.out.println( "ERROR" );
        }

        int locPairs = sc.nextInt();

        Grid<Tile> gr = getGrid();

        for ( int i = 0; i < locPairs; i++ )
        {
            int xCoordinate = sc.nextInt();
            int yCoordinate = sc.nextInt();

            Location loc = new Location( xCoordinate, yCoordinate );

            if ( gr.isValid( loc ) )
            {
                Tile t = new Tile( IMGOBJ_COLOR );
                this.add( loc, t );
            }
        }
    }


    /**
     * Recursively changes the color of a series of adjacent tiles (erases)
     * starting at the given coordinates if this coordinate is part of the
     * object. The method should erase the entire object (remove black).
     *
     * @param gr
     *            grid containing sequences of adjacent tiles
     * @param row
     *            row coordinate to begin erasure
     * @param col
     *            column coordinate to begin erasure
     */
    private void erase( Grid<Tile> gr, int row, int col )
    {
        Location loc = new Location( row, col );

        if ( gr.get( loc ) == null )
        {
            return;
        }

        if ( gr.get( loc ).getColor() == IMGOBJ_COLOR )
        {
            gr.get( loc ).setColor( ERASE_COLOR );

            Location loc1 = new Location( row, col + 1 );
            if ( gr.isValid( loc1 ) )
            {
                erase( gr, row, col + 1 );
            }
            Location loc2 = new Location( row, col - 1 );
            if ( gr.isValid( loc2 ) )
            {
                erase( gr, row, col - 1 );
            }
            Location loc3 = new Location( row - 1, col );
            if ( gr.isValid( loc3 ) )
            {
                erase( gr, row - 1, col );
            }
            Location loc4 = new Location( row + 1, col );
            if ( gr.isValid( loc4 ) )
            {
                erase( gr, row + 1, col );
            }
        }

        // check if the tile clicked is black. then erase the object. calls
        // it for all neighboring tiles
    }


    /**
     * 
     * TODO Builds the grid and erases the object.
     * 
     * @param args
     *            not used
     * @throws IOException
     */
    public static void main( String[] args ) throws IOException
    {
        new EraseObject().show();
    }
}
