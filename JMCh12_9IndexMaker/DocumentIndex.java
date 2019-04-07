import java.util.ArrayList;


/**
 * 
 * TODO The DocumentIndex classes documents the index of the appearance of the
 * word in a string. TODO The add word methods adds the new word for indexentry,
 * and then it inserts counts of where it appears. There is also a helper method
 * that tests the condition of whether the word is already existing, and where
 * the location should be.
 *
 * @author Kevin Deng
 * @version Nov 9, 2018
 * @author Period: TODO 3
 * @author Assignment: JMCh12_9IndexMaker
 *
 * @author Sources: TODO
 */
public class DocumentIndex extends ArrayList<IndexEntry>
{
    /**
     * Creates an empty DocumentIndex with the default initial capacity.
     */
    public DocumentIndex()
    {
        super();
    }


    /**
     * Creates an empty DocumentIndex with a giveninitial capacity.
     * 
     * @param initialCapacity
     *            the initial capacity of the arraylist
     */
    public DocumentIndex( int initialCapacity )
    {
        super( initialCapacity );
    }


    /**
     * 
     * TODO Adds word here and at a specific location if word is not in the
     * arraylist.
     * 
     * @param word
     *            the word to be added
     * @param num
     *            the location of where it should be added
     */
    public void addWord( String word, int num )
    {
        int pos = foundOrInserted(word);
        
        boolean exists = false;

        for ( IndexEntry ientry : this )
        {
            String test = ientry.getWord();

            if ( test.equalsIgnoreCase( word ) )
            {
                exists = true;
                ientry.add( num );
            }
        }

        if ( !exists )
        {
            IndexEntry ie = new IndexEntry( word );
            
            this.add( pos, ie );
            IndexEntry addwhere = this.get( indexOf( ie ) );
            addwhere.add( num );
        }
    }



    /**
     * 
     * TODO For each word, calls the above method
     * 
     * @param str
     *            the word to be called
     * @param num
     *            the location to be added
     */
    public void addAllWords( String str, int num )
    {
        String[] s = str.split( "\\W+" );

        for ( String x : s )
        {
            if ( x.length() != 0 )
            {
                addWord( x, num );
            }
        }
    }


    /**
     * 
     * TODO Finds word and orders in alphabetical order, then places it in ideal
     * location
     * 
     * @param word
     *            the word to be analyzed
     * @return the ideal position
     */
    private int foundOrInserted( String word )
    {
        int pos;
        int determiningFactor;
        for (pos = 0; pos < this.size(); pos++)
        {
            String str = this.get(pos).getWord();
            determiningFactor = str.compareToIgnoreCase( word );
          
            //found location. add new slot.
            if ( determiningFactor > 0 )
            {
                break;
            }

            //equal
            else if ( determiningFactor == 0 )
            {
                return pos;
            }
        }
        this.add(pos, new IndexEntry(word));

        return pos;
    }
}
