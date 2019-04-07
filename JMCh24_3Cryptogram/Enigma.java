import java.util.Arrays;
/**
   TODO Represents an Cryptogram decoding machine.
   TODO Ultimately decodes a string. The decode method decodes the string 
   referencing the lookup table, the getHints method returns the string
   (hint) that is generated, giving the best permutation to decode the code.
   The countLetters method counts all the letters in a string and puts the
   frequency of each letter into an int array.

   @author  TODO Kevin Deng
   @version TODO 2/11/19

   @author Period - TODO 3
   @author Assignment - JM 24.3 Lab: Cryptogram Solver

   @author Sources - TODO list collaborators
 */
public class Enigma
{
    private char[] lookupTable;


    public Enigma( int numLetters )
    {
        lookupTable = new char[numLetters];
    }


    public void setSubstitution( int index, char ch )
    {
        lookupTable[index] = Character.toUpperCase( ch );
    }


    public String decode( String text )
    {
        StringBuffer buffer = new StringBuffer( text.length() );
        for ( int x = 0; x < text.length(); x++ )
        {
            char r = text.charAt( x );
            if ( Character.isLetter( r ) )
                if ( Character.isUpperCase( r ) )
                {
                    buffer.append( lookupTable[r - 'A'] );
                }
                else
                {
                    r = Character.toUpperCase( r );
                    buffer.append( Character.toLowerCase(lookupTable[r - 'A']));
                }
            else
                buffer.append( text.charAt( x ) );
        }
        return buffer.toString();
    }


    public String getHints( String text, String lettersByFrequency )
    {
        int[] t = countLetters( text );
        char[] o = new char[lookupTable.length];
        for ( int x = 0; x < lookupTable.length; x++ )
        {
            int m = 0;
            for ( int y = 1; y < lookupTable.length; y++ )
                if ( t[y] < t[m] )
                    m = y;
            t[m] = Integer.MAX_VALUE;
            o[m] = lettersByFrequency.charAt( x );
        }
        String r = "";
        for ( char q : o )
            r += q;
        return r;
    }


    private int[] countLetters( String text )
    {
        int[] counts = new int[lookupTable.length];

        for ( int x = 0; x < text.length(); x++ )
            if ( Character.isLetter( text.charAt( x ) ) )
                counts[Character.toUpperCase( text.charAt( x ) ) - 'A']++;
        return counts;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation

    protected char[] getLookupTable()
    {
        return lookupTable;
    }


    protected int[] getCountLetters( String text )
    {
        return countLetters( text );
    }

}