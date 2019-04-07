import java.lang.reflect.*;
import java.util.*;

/**
 * Represents a brokerage.
 * 
 * @author Justin Lam
 * @version 1.0
 */
public class Brokerage implements Login
{
    private Map<String, Trader> traders;
    private Set<Trader> loggedTraders;
    private StockExchange exchange;

    /**
     * Constructs new brokerage affiliated with a given stock exchange.
     * Initializes the map of traders to an empty map (a TreeMap), keyed 
     * by trader's name;initializes the set of active (logged-in) traders
     * to an empty set (a TreeSet). 
     * @param exchange stock exchange
     */
    public Brokerage(StockExchange exchange)
    {
        this.exchange = exchange;
        traders = new TreeMap<String, Trader>();
        loggedTraders = new TreeSet<Trader>();
    }
    
    /**
     * Tries to register a new trader with a given screen name and password. 
     * If successful, creates a Trader object for this trader and adds this 
     * trader to the map of all traders(using the screen name as the key). 
     * @param name name of trader
     * @param password password of trader
     * @return integer 0, -1, -2, -3
     * 
     */
    public int addUser(String name, String password)
    {
        if (name.length() < 4 || name.length() > 10)
        {
            return -1;
        }
        
        else if (password.length() < 2 || password.length() > 10)
        {
            return -2;
        }
        
        else if (traders.get( name ) != null)
        {
            return -3;
        }
        
        else 
        {
            Trader newTrader = new Trader(this, name, password);
            traders.put( name, newTrader );
            
            return 0;
        }
    }
    /**
     * 
     *Requests a quote for a given stock from the stock exachange and passes it
     * along to the traderby calling trader's receiveMessage method. 
     * @param symbol the stock symbol
     * @param trader the trader who requested the quote
     */
    public void getQuote(String symbol, Trader trader)
    {
        trader.receiveMessage(exchange.getQuote( symbol ));
    }
    
    /**
     * Tries to login a trader with a given screen name and password.
     * If no messages are waiting for the trader, sends a "Welcome to 
     * SafeTrade!" message to the trader. Opens a dialog window for the trader 
     * by calling trader's openWindow() method.Adds the trader to the set of 
     * all logged-in traders. 
     * @param name name of trader
     * @param password password of trader
     * @return integer 0, -1, -2, -3
     */
    
    public int login(String name, String password)
    {
        if ( traders.get( name ) == null )
        {
            return -1;
        }

        else if ( !( traders.get( name ).getPassword() ).equals( password ) )
        {
            return -2;
        }

        else if ( loggedTraders.contains( traders.get( name ) ))
        {
            return -3;
        }

        else
        {
            
            Trader newTrader = new Trader( this, name, password );
            
            if ( newTrader.hasMessages())
            {
                newTrader.receiveMessage( "Welcome to SafeTrade!" );
            }

            newTrader.openWindow();
            loggedTraders.add( newTrader );
            
            return 0;

        }

    }
    
    /**
     * 
     * Removes a specified trader from the set of logged-in traders. 
     * @param trader trader to get logged out
     */
    public void logout(Trader trader)
    {
        loggedTraders.remove( trader );
    }
    
    /**
     * 
     * Places an order at the stock exchange.
     * @param order to be placed
     */
    public void placeOrder(TradeOrder order)
    {
        exchange.placeOrder(order);
    }
    
    //
    // The following are for test purposes only
    //
    
    /**
     * 
     * TODO testing
     * @return Map<String, Trader>
     */
    protected Map<String, Trader> getTraders()
    {
        return traders;
    }

    /**
     * 
     * TODO testing
     * @return Set<Trader>
     */
    protected Set<Trader> getLoggedTraders()
    {
        return loggedTraders;
    }

    /**
     * 
     * TODO testing
     * @return exchange
     */
    protected StockExchange getExchange()
    {
        return exchange;
    }

    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Brokerage.
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
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
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