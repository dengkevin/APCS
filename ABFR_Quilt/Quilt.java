import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 *  TODO Represents a Quilt Class
 *  TODO Can turn a quilt to a mat (i.e. checkerboard alteration) and place the
 *  quilt in a specified pattern.
 *
 *  @author  TODO: Kevin Deng
 *  @version TODO: 4/26/19
 *  @author  Period: TODO 3
 *  @author  Assignment: AB Free Response Quilt
 *
 *  @author  Sources: TODO none
 */
public class Quilt
{
    char[][] myBlock;       // stores pattern for one block
    int myRowsOfBlocks;     // number of rows of blocks in the quilt 
    int myColsOfBlocks;     // number of columns of blocks in the quilt
    
    // precondition:   quiltBlock refers to an initialized quilt block,
    //                 rowsOfBlocks > 0, colsOfBlocks > 0
    // postcondition:  myRowsOfBlocks and myColsOfBlocks are initialized to
    //                 the number of rows and columns of blocks that make up
    //                 the quilt; myBlock has been initialized to the block
    //                 pattern of quiltBlock.
    public Quilt(char[][] quiltBlock, int rowsOfBlocks, int colsOfBlocks)
    {
        myBlock = quiltBlock;
        myRowsOfBlocks = rowsOfBlocks;
        myColsOfBlocks = colsOfBlocks;
    }
    
    // precondition:  startRow >= 0; startCol >= 0;
    //                startRow + myBlock.numrows() <= qmat.numrows();
    //                startCol + myBlock.numcols() <= qmat.numcols();
    // postcondition: myBlock has been copied into the matrix
    //                qmat with its upper-left corner at the position
    //                startRow, startCol
    public void placeBlock(int startRow, int startCol, char[][] qmat)
    {
        for ( int r = 0; r < myBlock.length; r++ )
        {
            for ( int c = 0; c < myBlock[r].length; c++ )
            {
                qmat[startRow + r][startCol + c] = myBlock[r][c];
            }
        }
    }
    
    // precondition:  startRow >= 0; startCol >= 0;
    //  startRow + myBlock.length <= qmat.length;
    //  startCol + myBlock[0].length <= qmat[0].length;
    //postcondition: a flipped version of myBlock has been copied into the
    //  matrix qmat with its upper-left corner at the position
    //  startRow, startCol
    public void placeFlipped( int startRow, int startCol, char[][] qmat )
    {
        int rowLength = myBlock.length;
        for ( int r = 0; r < myBlock.length; r++ )
        {
            for ( int c = 0; c < myBlock[r].length; c++ )
            {
                qmat[startRow + r][startCol + c] = myBlock[rowLength - r - 1][c];
            }
        }
    }
    
    public char[][] quiltToMat() // checkerboard alternation
    {
        int rowLength = myBlock.length;
        int colLength = myBlock[0].length;
        char[][] newMat = new char[myRowsOfBlocks * rowLength]
                        [myColsOfBlocks * colLength];
        
        for (int i = 0; i < myRowsOfBlocks; i++)
        {           
            for (int j = 0; j < myColsOfBlocks; j++)
            {
                if ((i + j) % 2 != 0)
                {
                    placeFlipped(i * rowLength, j * colLength, newMat);
                }
                else
                {
                    placeBlock(i * rowLength, j * colLength, newMat);
                }
            }
        }
        return newMat;
    }
    
    /*
     * Intended only for testing.
     */
    public char[][] getMyBlock()
    {
        return myBlock;
    }
    
    public int getMyRowsOfBlocks()
    {
        return myRowsOfBlocks;
    }

    public int getMyColsOfBlocks()
    {
        return myColsOfBlocks;
    }
    
    /**
     * Test Quilt class.
     * @param args command-line parameters (not used)
     */
    public static void main( String[] args )
    {
        char[][] qBlock = { {'x', '.', '.', '.', 'x'},
                            {'.', 'x', '.', 'x', '.'},
                            {'.', '.', 'x', '.', '.'},
                            {'.', '.', 'x', '.', '.'} };

        Quilt q = new Quilt(qBlock, 3, 3);
        
        char[][] quilt = q.quiltToMat();
        
        for (char r[] : quilt)
        {
            for (char ch : r)
            {
                System.out.print(ch);
            }
            System.out.println();
        }
        
    }
}
