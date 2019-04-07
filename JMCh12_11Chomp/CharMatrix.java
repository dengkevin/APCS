/**
 * Implements a 2-D array of characters.
 *
 * @author TODO Kevin Deng
 * @version TODO 11/4/18
 * 
 * @author Period - TODO 3
 * @author Assignment - JMCh12_11Chomp
 * 
 * @author Sources - TODO list collaborators
 */
public class CharMatrix
{
    public final char SPACE = ' ';
    private char[][] grid;

    /**
     * Constructor: creates a grid with dimensions rows, cols
     * and fills it with spaces.
     * 
     * @param rows number of rows
     * @param cols number of columns
     */
    public CharMatrix( int rows, int cols )
    {
        grid = new char[rows][cols];
        
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                grid[i][j] = ' ';
            }
        }
    }

    /**
     * Constructor: creates a grid with dimensions rows , cols
     * and fills it with the fill character.
     * 
     * @param rows number of rows
     * @param cols number of columns
     * @param fill character for fill
     */
    public CharMatrix( int rows, int cols, char fill )
    {
        grid = new char[rows][cols];
        
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                grid[i][j] = fill;
            }
        }
    }

    /**
     * Returns the number of rows in grid.
     * 
     * @return the number of rows in grid
     */
    public int numRows()
    {
        return grid.length;
    }

    /**
     * Returns the number of columns in grid.
     * 
     * @return the number of columns in grid
     */
    public int numCols()
    {
        return grid[0].length;
    }

    /**
     * Returns the character at row, col location.
     * 
     * @param row row
     * @param col column
     * @return character at row, col location
     */
    public char charAt( int row, int col )
    {
        return grid[row][col];
    }

    /**
     * Sets the character at row, col location to ch.
     * 
     * @param row row
     * @param col column
     * @param ch character
     */
    public void setCharAt( int row, int col, char ch )
    {
        grid[row][col] = ch;
    }

    /**
     * Returns true if the character at row, col is a space,
     * false otherwise.
     * 
     * @param row  row to check
     * @param col  column to check
     * @return true if the character at row, col is a space,
     *         false otherwise.
     */
    public boolean isEmpty( int row, int col )
    {
        if (grid[row][col] == ' ')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Fills the given rectangle with fill characters.
     * 
     * @param row0 the upper left corner row of the rectangle
     * @param col0 the upper left corner column of the rectangle
     * @param row1 the lower right corner row of the rectangle
     * @param col1 the lower right corner column of the rectangle
     * @param fill character used to fill the rectangle
     */
    public void fillRect( int row0, int col0, int row1, int col1, char fill )
    {
        for (int i = row0; i <= row1; i++)
        {
            for (int j = col0; j <= col1; j++)
            {
                grid[i][j] = fill;
            }
        }
    }

    /**
     * Fills the given rectangle with SPACE characters.
     * 
     * @param row0 upper left corner row of the rectangle
     * @param col0 upper left corner column of the rectangle
     * @param row1 lower right corner row of the rectangle
     * @param col1 lower right corner column of the rectangle
     */
    public void clearRect( int row0, int col0, int row1, int col1 )
    {
        for (int i = row0; i <= row1; i++)
        {
            for (int j = col0; j <= col1; j++)
            {
                grid[i][j] = ' ';
            }
        }
    }

    /**
     * Returns the count of all non-space characters in row
     * 
     * @param row row in which to count non-space characters
     * @return count of all non-space characters
     */
    public int countInRow( int row )
    {
        int count = 0;
        
        for (int i = 0; i < grid[row].length; i++)
        {
            if (grid[row][i] != ' ')
            {
                count++;
            }
        }
        
        return count;
    }

    /**
     * Returns the count of all non-space characters in col
     * 
     * @param col column in which to count non-space characters
     * @return count of all non-space characters
     */
    public int countInCol( int col )
    {
        int count = 0;
        
        for (int i = 0; i < grid[col].length; i++)
        {
            if (grid[i][col] != ' ')
            {
                count++;
            }
        }
        
        return count;
    }

    /**
     * *** For Test Purposes Only ***
     * 
     * Returns the 2D char array in this class.
     * 
     * @return this grid
     */
    public char[][] getGrid()
    {
        return grid;
    }
}
