import java.util.*;

/**
   TODO Simulates a search engine.
   TODO When the user inputs a word, a whole line will be returned containing 
   that word, as if the user had searched the word on a search engine.

   @author  TODO Kevin Deng
   @version TODO 2/22/19

   @author Period - TODO 3
   @author Assignment - JM24.6 - Search Engine

   @author Sources - TODO none
 */
public class SearchEngine
{
    // Instance variable(s)
    private String myURL; // holds the name for the "url" (file name)
    private Map<String, List<String>> myIndex; // holds the word index

    /**
     * Constructs a Search Engine
     * @param url  the file name
     */
    public SearchEngine(String url)
    {
        myURL = url;
        myIndex = new HashMap<String, List<String>>(20000);
    }

    /**
     * 
     * TODO Returns the URL
     * @return  myURL
     */
    public String getURL()
    {
        return myURL;
    }
    
    /**
     * 
     * TODO extracts all the words from line and then adds the line to the list
     * of all lines in myIndex (the hashMap), representing all of the lines
     * in the text that contains the word
     * @param line  the line to be analyzed
     */
    public void add(String line)
    {
        Set<String> words = parseWords(line);
        
        for (String s : words)
        {
            if (!(myIndex.containsKey(s)))
            {
                LinkedList<String> link = new LinkedList<String>();
                myIndex.put(s, link);
            }
            myIndex.get(s).add(line);
        }
    }
    
    /**
     * 
     * TODO Gets the list of lines that contain the given word
     * @param word  the word in each line to be returned
     * @return  myIndex.get(word), which is a linked list of all the lines with
     * the given word
     */
    public List<String> getHits(String word)
    {
        return myIndex.get(word);
    }
    
    /**
     * 
     * TODO Parses a line into separate words, then adds them to a treeSet to
     * eliminate duplicates, then returns the treeSet to be used in the add
     * method.
     * @param line  the line to be analyzed
     * @return allWords  the treeSet containing all the words in the line
     */
    private Set<String> parseWords(String line)
    {
        String[] words = line.split("\\W+");
        TreeSet<String> allWords = new TreeSet<String>();
        
        for (String s : words)
        {
            if (!(s.isEmpty()))
            {
                s = s.toLowerCase();
                allWords.add(s);
            }
        }
        
        return allWords;
    }


    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation
    
    /**
     * 
     * TODO Test purposes only
     * @return myIndex  test purposes only
     */
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}
