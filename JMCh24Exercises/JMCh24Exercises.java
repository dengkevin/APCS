import java.util.*;

/**
 * Java Methods Chapter 24 Exercises 19-22.
 *
 * @author TODO Kevin Deng
 * @version TODO 2/26/19
 * @author Period: TODO 3
 * @author Assignment: JMCh24Exercises
 *
 * @author Sources: TODO
 */
public class JMCh24Exercises
{
    // Question 24-19
    // A class Date has methods int getMonth() that returns a value between
    // 0 and 11 (with 0 representing January) and int getDate() returns the
    // day of the month represented by this Date object. The value returned
    // is between 1 and 31 representing the day of the month that contains or
    // begins with the instant in time represented by this Date object,
    // as interpreted in the local time zone.  Write the method
    //
    //     public boolean has3OnSameDay(Date[] birthdays)
    //
    // that returns true if at least three birthdays in the array fall on
    // the same date. Your method should work in O(n) time, where
    // n = birthdays.length.
    @SuppressWarnings("deprecation")
    public boolean has3OnSameDay( Date[] birthdays )
    {
        Map<Date, Integer> myMap = new HashMap<Date, Integer>();
        boolean moreThanThree = false;
        
        for (int i = 0; i < birthdays.length; i++)
        {
            if (myMap.containsKey(birthdays[i]))
            {
                myMap.put(birthdays[i], myMap.get(birthdays[i]) + 1);
            }
            else
            {
                myMap.put(birthdays[i], 1);
            }
        }
        
        for (Integer value : myMap.values())
        {
            if (value >= 3)
            {
                moreThanThree = true;
                break;
            }
        }
        
        return moreThanThree;
    }
    
    
    // Question 24-21
    // A Scanner input is associated with a text file, open for reading,
    // that contains words. Write a method
    //
    //    public String mostFrequentWord(Scanner input)
    //
    // that returns the most frequently occurring word (or any one of such
    // words). Use a Map<String, Integer> to hold the counts for different words.
    public String mostFrequentWord( Scanner input )
    {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        String text = input.next();
        String[] words = text.split("\\W+");
        
        for (String s : words)
        {
            if (counts.containsKey(s))
            {
                counts.put(s, counts.get(s) + 1);
            }
            else
            {
                counts.put(s, 1);
            }
        }
        
        String mostFreq = "";
        int max = 0;
        
        for (Map.Entry<String, Integer> pair: counts.entrySet())
        {
            String s = pair.getKey();
            int frequency = pair.getValue();
            
            if (frequency > max)
            {
                max = frequency;
                mostFreq = s;
            }
        }
        
        return mostFreq;
    }
    
    /**
     * Testing method: instantiates a JMCh21Exercises object and then invokes
     * test each class/method.
     * 
     * @param args command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        JMCh24Exercises ex = new JMCh24Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) 24-19 has3OnSameDay()" );
            System.out.println( "   (2) 24-20 Person class hashCode()" );
            System.out.println( "   (3) 24-21 mostFrequentWord()" );
            System.out.println( "   (4) 24-22 MyHashTable" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        @SuppressWarnings("deprecation")
                        Date[] d = {new Date(2010, 7, 4), new Date(2010, 1, 1),
                                    new Date(2010, 7, 4), new Date(2010, 12, 1),
                                    new Date(2010, 7, 1), new Date(2010, 7, 4)};
                        System.out.println("3 on same date = " + ex.has3OnSameDay(d) );
                        break;
                    case '2':
                        Person p = new Person("Jenny Java", 1);
                        System.out.println( "p.hashCode() = " + p.hashCode() );
                        break;
                    case '3':
                        Scanner scan = new Scanner("word newt word spam word word a for stuff stuff");
                        System.out.println("most frequent word = " + ex.mostFrequentWord( scan ));
                        break;
                    case '4':
                        int capacity = 8;
                        MyHashTable ht = new MyHashTable(capacity, .75);
                        for (int i = 1; i < capacity/2; i++)
                        {
                            ht.add( "narwhal" + i);
                            ht.add( "narwhal" + (i * capacity));
                        }
                        System.out.println( ht );
                        ht.add( "" + 2); // hashtable should resize
                        System.out.println( ht );
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
