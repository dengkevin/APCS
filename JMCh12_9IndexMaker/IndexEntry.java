import java.util.ArrayList;
/**
 * 
 *  TODO The IndexEntry class creates a list of all the occurances of a word
 *  in index form.
 *  TODO The add method adds the location to the list and the toString method
 *  will print it out in a string format.
 *
 *  @author  Kevin Deng
 *  @version Nov 9, 2018
 *  @author  Period: TODO 3
 *  @author  Assignment: JMCh12_9IndexMaker
 *
 *  @author  Sources: TODO
 */
public class IndexEntry
{
    private String word;
    private ArrayList<Integer> numsList;

/**
 * Creates an IndexEntry object
 * @param word  sets private field word to the passed paramater
 */
    public IndexEntry(String word)
    {
        this.word = word.toUpperCase();
        numsList = new ArrayList<Integer>();
    }

/**
 * 
 * TODO returns the word
 * @return  the word
 */
    public String getWord()
    {
        return word;
    }

/**
 * 
 * TODO If number is not in the list, adds it in
 * @param num  the number to be checked
 */
    public void add(int num)
    {
        if (!numsList.contains(num))
        {
            numsList.add(num);
        }
    }

/**
 * Converts the list to a string and prints it all out.
 * @return  the string format of the list.
 */
    public String toString()
    {
        String ie = word + " ";
        
        for (int i = 0; i < numsList.size() - 1; i++)
        {
            ie += numsList.get(i) + ", ";
        }
        
        ie += numsList.get(numsList.size() - 1);
        return ie;
    }
}
