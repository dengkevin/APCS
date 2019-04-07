/**
 * TODO The LipogramAnalyzer changes a string text and replaces all character
 * that is e with a #. It also prints out the offending words with the letter e
 * on the right hand box. The LipogramAnalyzer class also comes with a method
 * that will exclude any letter at a given position of a string and print out
 * the words that are offending words given that letter.
 * 
 * @author TODO Kevin Deng
 * @version TODO 10/08
 * 
 * @author Period - TODO 3
 * @author Assignment - JMCh10 Lipogrammer
 * 
 * @author Sources - TODO list collaborators
 */
public class LipogramAnalyzer
{
    private String text;


    /**
     * Constructor: Saves the text string
     * 
     * @param text
     *            String to analyze
     */
    public LipogramAnalyzer( String text )
    {
        this.text = text;
    }


/**
  * Returns the text string with all characters equal to letter replaced with
  * '#'.
  * 
  * @param letter
  *            character to replace
  * @return text string with all characters equal to letter replaced with '#'
  */
    public String mark( char letter )
    {
        String newText = "";
        for ( int i = 0; i < text.length(); i++ )
        {
            if ( text.charAt( i ) == letter )
            {
                newText += '#';
            }

            else
            {
                newText += text.charAt( i );
            }
        }

        return newText;

    }


 /**
  * Returns a String that concatenates all "offending" words from text that
  * contain letter; the words are separated by '\n' characters; the returned
  * string does not contain duplicate words: each word occurs only once;
  * there are no punctuation or whitespace characters in the returned string.
  * 
  * @param letter
  *            character to find in text
  * @return String containing all words with letter
  */
    public String allWordsWith( char letter )
    {
        String newString = "";

        int i = 0;
        int counter = 0;

        do
        {
            if ( text.charAt( i ) == letter && 
                            extractWord( i ).length() == 1 && counter < 1 )
            {
                newString += extractWord( i ) + "\n";
                counter++;
            }
            
            else if ( text.charAt( i ) == letter && 
                            newString.indexOf( extractWord( i ) ) == -1)
            // checks for duplicates
            {
                newString += extractWord( i ) + '\n';
            }
            
            i++;

        } while ( i < text.length() );

        return newString;

    }


/**
  * Returns the word that contains character at pos excluding any punctuation
  * or whitespace. The firstLetter is the first letter of the cut word, while
  * the lastLetter is the last letter of the cut word.
  * 
  * @param pos  location of character
  * 
  * 
  * @return word that contains character at pos
  */
    public String extractWord( int pos )
    {
        char letter = text.charAt( pos );
        int firstLetter = pos;
        int lastLetter = pos;

        if ( Character.isLetter( letter ) )
        {

            while ( firstLetter >= 0 && 
                            Character.isLetter( text.charAt( firstLetter ) ) )
            {
                firstLetter--;
            }
            while ( lastLetter < text.length() && 
                            Character.isLetter( text.charAt( lastLetter ) ) )
            {
                lastLetter++;
            }

        }

        return text.substring( firstLetter + 1, lastLetter );
    }
}
