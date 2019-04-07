import java.lang.reflect.*;
import java.util.*;


/**
 * Represents a stock trader.
 * 
 * @author Kevin Deng
 * @version 1
 */
public class Trader implements Comparable<Trader>
{
    private Brokerage brokerage;

    private String screenName;

    private String password;

    private TraderWindow myWindow;

    private Queue<String> mailbox;


    /**
     * Constructs a trader
     * 
     * @param brokerage
     *            a Brokerage object
     * @param name
     *            the name of the trader
     * @param pswd
     *            the password of the trader
     */
    public Trader( Brokerage brokerage, String name, String pswd )
    {
        this.brokerage = brokerage;
        this.screenName = name;
        this.password = pswd;
        mailbox = new LinkedList<String>();
    }


    /**
     * Compares this trader to another by comparing their screen names case
     * blind.
     * 
     * @param other
     *            the trader to compare
     * 
     * @return difference
     */
    public int compareTo( Trader other )
    {
        return screenName.compareToIgnoreCase( other.screenName );
    }


    /**
     * Indicates whether some other trader is "equal to" this one, based on
     * comparing their screen names case blind.
     * 
     * @param other
     *            the trader to compare
     * @return true if equals, false if not
     */
    public boolean equals( Object other )
    {
        return compareTo( (Trader)other ) == 0;

    }


    /**
     * 
     * TODO Returns the screen name for this trader
     * 
     * @return the screen name
     */
    public String getName()
    {
        return screenName;
    }


    /**
     * 
     * TODO returns the password for this trader
     * 
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }


    /**
     * 
     * TODO Requests a quote for a given stock symbol from the brokerage by
     * calling brokerage's getQuote.
     * 
     * @param symbol
     *            stock symbol
     */
    public void getQuote( String symbol )
    {
        brokerage.getQuote( symbol, this );
    }


    /**
     * 
     * TODO Returns true if this trader has any messages in its mailbox.
     * 
     * @return true if mailbox has messages
     */
    public boolean hasMessages()
    {
        return !( mailbox.isEmpty() );
    }


    /**
     * Creates a new TraderWindow for this trader and saves a reference to it in
     * myWindow.
     */
    public void openWindow()
    {
        myWindow = new TraderWindow( this );
        while ( !( mailbox.isEmpty() ) )
        {
            myWindow.showMessage( mailbox.remove() );
        }
    }


    /**
     * 
     * TODO Places a given order with the brokerage by calling brokerage's
     * placeOrder.
     * 
     * @param order
     *            the given order
     */
    public void placeOrder( TradeOrder order )
    {
        brokerage.placeOrder( order );
    }


    /**
     * TODO Logs out this trader.
     */
    public void quit()
    {
        brokerage.logout( this );
        myWindow = null;
    }


    /**
     * Adds msg to this trader's mailbox and displays all messages.
     * 
     * @param msg
     *            message to be added to mailbox
     */
    public void receiveMessage( String msg )
    {
        mailbox.add( msg );
        if ( myWindow != null )
        {
            // while (!(mailbox.isEmpty()))
            // {
            myWindow.showMessage( mailbox.remove() );
            // }
        }
    }


    //
    // The following are for test purposes only
    //

    /**
     * 
     * TODO testing
     * 
     * @return mailbox
     */
    protected Queue<String> mailbox()
    {
        return mailbox;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Trader.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                if ( field.getType().getName().equals( "Brokerage" ) )
                {
                    str += separator + field.getType().getName() + " " + 
                field.getName();
                }
                else
                {
                    str += separator + field.getType().getName() + " " + 
                field.getName() + ":"
                        + field.get( this );
                }
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
