/**
   Implements a sorted list of words

   @author  TODO Kevin Deng
   @version TODO 11/20

   @author Period - TODO 3
   @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order

   @author Sources - TODO list collaborators
 */
public class SortedWordList extends java.util.ArrayList<String>
{

/**
 * Constructs a SortedWordList
 */
    public SortedWordList()
    {
        super();
    }
   
/**
 * Constructs a SortedWordList
 * @param capacity  the size of the word list
 */
    public SortedWordList(int capacity)
    {
        super(capacity);
    }
/**
 * 
 * TODO checks whether string s is in the SortedWordList or not
 * @param s  the string to be checked
 * @return  true if SortedWordList contains the string s, false otherwise
 */
    public boolean contains(String s)
    {
        int left = 0;
        int right = this.size() - 1;
        
        while (left <= right)
        {
            int middle = (left + right) / 2;
            
            int comp = s.compareToIgnoreCase(this.get(middle));
            
            if (comp == 0)
            {
                return true;
            }
            else if (comp < 0)
            {
                right = middle - 1;
            }
            else
            {
                left = middle + 1;
            }
        }
        
        return false;
    }
/**
 *    
 * TODO Finds the index of the string s in the SortedWordList
 * @param s  the string to be found
 * @return  the index of the string s, -1 if not found
 */
    public int indexOf(String s)
    {
        int left = 0;
        int right = this.size() - 1;
        
        while (left <= right)
        {
            int middle = (left + right) / 2;
            
            int comp = s.compareToIgnoreCase(this.get(middle));
            
            if (comp == 0)
            {
                return middle;
            }
            else if (comp < 0)
            {
                right = middle - 1;
            }
            else
            {
                left = middle + 1;
            }
        }
        return -1;
    }
/**
 * Sets the index i in the SortedWordList to the value of string word. This 
 * essentially "replaces" the index value in SortedWordList with a new one.
 * 
 * @param i  the index where word is trying to be placed in
 * @param word  the word to be placed
 * 
 *     @return  the word that is set in index i
 */
    public String set(int i, String word)
    {
        String toReturn = "";
        
        if (i == 0 && word.compareToIgnoreCase(this.get(i + 1)) < 0)
        {
            toReturn = super.set(i, word);
        }
        else if (word.compareToIgnoreCase(this.get(i - 1)) > 0 && 
                            word.compareToIgnoreCase(this.get(i + 1)) < 0)
        {
            toReturn = super.set(i, word);
        }
        else
        {
            throw new IllegalArgumentException("word =" + word + " i ="  + i);
        }
        
        return toReturn;
    }
/**
 * Adds a string word at a given index location, but first checks if it is in
 * alphabetical order
 * 
 *  first two if else conditions checks if the i value is 0 or size() - 1
 *  because you cannot perform (i - 1) or (i + 1) respectively if the i value
 *  is in those extreme conditions.
 *  
 *  @param i  the index where the word to be added
 *  @param word  the word to be added
 */
    public void add(int i, String word)
    {
        if (i == 0 && word.compareToIgnoreCase(this.get(i + 1)) < 0)
        {
            super.add(i, word);
        }
        else if (i == this.size() && word.compareTo(this.get(i - 1)) > 0)
        {
            super.add(i, word);
        }
        else if (word.compareToIgnoreCase(this.get(i - 1)) > 0 && 
                        word.compareToIgnoreCase(this.get(i + 1)) < 0)
        {
            if (!this.contains(word))
            {
                super.add(i, word);
            }
        }
        else
        {
            throw new IllegalArgumentException("word =" + word + " i ="  + i);
        }
    }
/**
 * adds the word to the SortedWordList, and checks for the best possible place
 * using binary search.   
 * 
 * @param word  the word to be added
 * 
 *  @return  true if adding is possible, false if the ArrayList contains the
 *  word already. No duplicates!
 */
    public boolean add(String word)
    {
        if (this.contains(word))
        {
            return false;
        }
        
        int left = 0;
        int right = this.size() - 1;
            
        while (left <= right)
        {
            int middle = (left + right) / 2;
                
            int comp = word.compareToIgnoreCase(this.get(middle));
                
            if (comp < 0)
            {
                right = middle - 1;
            }
            else
            {
                left = middle + 1;
            }
        }
            
        super.add(right + 1, word);
        return true;
    }
/**
 *
 * TODO Merges another ArrayList with SortedWordList and flushes out the
 * duplicates. This is already done in the add method because we check for 
 * duplicates there. All we have to do is keep on adding it to the SortedWord
 * List. (this will cover the alphabetical order as well as checking for
 * duplicates.
 * @param additionalWords  the ArrayList to be merged with SortedWordList
 */
    public void merge(SortedWordList additionalWords)
    {
        for (String x: additionalWords)
        {
            add(x);
        }
    }
}
