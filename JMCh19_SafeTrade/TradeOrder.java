import java.lang.reflect.*;


/**
 * Represents a buy or sell order for trading a given number of
 * shares of a specified stock.
 * 
 * @author Raymond Hsu 
 * @version 1
 */
public class TradeOrder
{
    private Trader trader;

    private String symbol;

    private boolean buyOrder;

    private boolean marketOrder;

    private int numShares;

    private double price;


    /**
     * Constructs a TradeOrder
     * 
     * @param trader
     *            to set trader to
     * @param symbol
     *            to set symbol to
     * @param buyOrder
     *            to set buyOrder to
     * @param marketOrder
     *            to set MarketOrder to
     * @param numShares
     *            to set numShares to
     * @param price
     *            to set price to
     *            
     */
    public TradeOrder(
        Trader trader,
        String symbol,
        boolean buyOrder,
        boolean marketOrder,
        int numShares,
        double price )
    {
        this.trader = trader;
        this.symbol = symbol;
        this.buyOrder = buyOrder;
        this.marketOrder = marketOrder;
        this.numShares = numShares;
        this.price = price;
    }


    /**
     * returns the price
     * 
     * @return the price
     */
    public double getPrice()
    {
        return price;
    }


    /**
     * Returns the number of shares to be traded in this trade order.
     * 
     * @return the number of shares to be traded in this trade order.
     */
    public int getShares()
    {
        return numShares;
    }


    /**
     * Returns the stock symbol for this trade order.
     * 
     * @return the stock symbol for this trade order.
     */
    public String getSymbol()
    {
        return symbol;
    }


    /**
     * Returns the trader for this trade order.
     * 
     * @return the trader for this trade order.
     */
    public Trader getTrader()
    {
        return trader;
    }


    /**
     * Returns true if this is a buy order; otherwise returns false.
     * 
     * @return true if this is a buy order; otherwise returns false.
     */
    public boolean isBuy()
    {
        return ( buyOrder );
    }


    /**
     * Returns true if this is a limit order; otherwise returns false.
     * 
     * @return true if this is a limit order; otherwise returns false.
     */
    public boolean isLimit()
    {
        return ( !marketOrder );
    }


    /**
     * Returns true if this is a market order; otherwise returns false.
     * 
     * @return true if this is a market order; otherwise returns false.
     */
    public boolean isMarket()
    {
        return ( marketOrder );
    }


    /**
     * Returns true if this is a sell order; otherwise returns false.
     * 
     * @return true if this is a sell order; otherwise returns false.
     */
    public boolean isSell()
    {
        return ( !buyOrder );
    }


    /**
     * Subtracts a given number of shares from the total number of shares in
     * this trade order.
     * 
     * @param shares
     *            to subtract
     */
    public void subtractShares( int shares )
    {
        if (numShares >= shares)
        {
            numShares -= shares;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }


    // The following are for test purposes only
    //
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this TradeOrder.
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
                str += separator + field.getType().getName() + " " + 
            field.getName() + ":"
                    + field.get( this );
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
