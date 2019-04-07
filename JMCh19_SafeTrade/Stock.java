import java.util.*;
import java.lang.reflect.*;
import java.text.DecimalFormat;


/**
 * Represents a stock in the SafeTrade project
 * 
 * @author Kevin Deng, Justin Lam, Raymond Hsu
 * @version 1
 */
public class Stock
{
    private static DecimalFormat money = new DecimalFormat("0.00");
    
    private String stockSymbol;

    private String companyName;

    private double loPrice;

    private double hiPrice;

    private double lastPrice;

    private int volume;

    private PriorityQueue<TradeOrder> buyOrders;

    private PriorityQueue<TradeOrder> sellOrders;


    /**
     * Constructs a stock object
     * 
     * @param symbol
     *            the stock symbol
     * @param name
     *            the stock name
     * @param price
     *            the stock price
     */
    public Stock( String symbol, String name, double price )
    {
        stockSymbol = symbol;
        companyName = name;
        loPrice = price;
        hiPrice = price;
        lastPrice = price;
        volume = 0;
        sellOrders = new PriorityQueue<TradeOrder>( new PriceComparator() );
        buyOrders = new PriorityQueue<TradeOrder>( new PriceComparator(false));
    }


    /**
     * Returns a quote string for this stock. The quote includes: the company
     * name for this stock; the stock symbol; last sale price; the lowest and
     * highest day prices; the lowest price in a sell order (or "market") and
     * the number of shares in it (or "none" if there are no sell orders); the
     * highest price in a buy order (or "market") and the number of shares in it
     * (or "none" if there are no buy orders).
     * 
     * @return result the quote string for the stock
     */
    public String getQuote()
    {
        String result = companyName + " (" + stockSymbol + ")\nPrice: " + 
            lastPrice + "  hi: "
            + hiPrice + "  lo: " + loPrice + "  vol: " + volume + "\nAsk: ";
        if ( sellOrders.isEmpty() )
        {
            result = result + "none";
        }
        else
        {
            result = result + money.format(sellOrders.peek().getPrice()) 
                + " size: "
                + sellOrders.peek().getShares();
        }

        result = result + "  Bid: ";

        if ( buyOrders.isEmpty() )
        {
            result = result + "none";
        }
        else
        {
            result = result + money.format(buyOrders.peek().getPrice()) 
                + " size: "
                + buyOrders.peek().getShares();
        }

        return result;

    }


    /**
     * Places a trading order for this stock. Adds the order to the appropriate
     * priority queue depending on whether this is a buy or sell order. Notifies
     * the trader who placed the order that the order has been placed, by
     * sending a message to that trader.
     * 
     * @param order
     *            the order to be placed
     */
    public void placeOrder( TradeOrder order )
    {
        String sendMessage = "New order:  ";
        if ( order.isBuy() )
        {
            buyOrders.add( order );
            sendMessage += "Buy " + order.getSymbol() + " (" + 
            order.getTrader().getName() + ")\n"
                + order.getShares() + " shares at";
            if ( order.isMarket() )
            {
                sendMessage += " market";
            }
            else
            {
                sendMessage += " $" + money.format(order.getPrice());
            }
        }
        else
        {
            sellOrders.add( order );
            sendMessage += "Sell " + order.getSymbol() + " (" + 
            order.getTrader().getName() + ")\n"
                + order.getShares() + " shares at";
            if ( order.isMarket() )
            {
                sendMessage += " market";
            }
            else
            {
                sendMessage += " $" + money.format(order.getPrice());
            }
        }
        order.getTrader().receiveMessage( sendMessage );
        executeOrders();
    }


    /**
     * 
     * TODO Executes as many pending orders as possible
     */
    protected void executeOrders()
    {
        //recursion base case: if one of them is empty, it cannot proceed
        if (sellOrders.isEmpty() || buyOrders.isEmpty())
        {
            return;
        }
        
        TradeOrder ts = sellOrders.peek();
        TradeOrder tb = buyOrders.peek();
        double price = 0;

        if ( tb.isLimit() && ts.isLimit() )
        {
            price = ts.getPrice();
        }

        else if ( tb.isLimit() && ts.isMarket() )
        {
            price = tb.getPrice();
        }

        else if ( tb.isMarket() && ts.isLimit() )
        {
            price = ts.getPrice();
        }

        else if ( tb.isMarket() && ts.isMarket() )
        {
            price = lastPrice;
        }
        int shares = Math.min( ts.getShares(), tb.getShares() );
        tb.subtractShares( shares );
        ts.subtractShares( shares );

        if ( tb.getShares() == 0 )
        {
            buyOrders.remove( tb );
        }
        if ( ts.getShares() == 0 )
        {
            sellOrders.remove( ts );
        }
        if ( price < loPrice )
        {
            loPrice = price;
        }
        if ( price > hiPrice )
        {
            hiPrice = price;
        }
        lastPrice = price;
        volume += shares;

        ts.getTrader()
            .receiveMessage( "You sold: " + shares + " " + stockSymbol + 
                " at " + money.format(price)
                + " amt " + money.format(shares * price));
        tb.getTrader()
            .receiveMessage( "You bought: " + shares + " " + stockSymbol + 
                " at " + money.format(price)
                + " amt " + money.format(shares * price));
        
        if (!(sellOrders.isEmpty()) && !(buyOrders.isEmpty()))
        {
            //execute again until one queue is EMPTY
            executeOrders();
        }
    }


    //
    // The following are for test purposes only
    //

    /**
     * 
     * TODO testing
     * 
     * @return stockSymbol
     */
    protected String getStockSymbol()
    {
        return stockSymbol;
    }


    /**
     * 
     * TODO testing
     * 
     * @return companyName
     */
    protected String getCompanyName()
    {
        return companyName;
    }


    /**
     * 
     * TODO testing
     * 
     * @return loPrice
     */
    protected double getLoPrice()
    {
        return loPrice;
    }


    /**
     * 
     * TODO testing
     * 
     * @return hiPrice
     */
    protected double getHiPrice()
    {
        return hiPrice;
    }


    /**
     * 
     * TODO testing
     * 
     * @return lastPrice
     */
    protected double getLastPrice()
    {
        return lastPrice;
    }


    /**
     * 
     * TODO testing
     * 
     * @return volume
     */
    protected int getVolume()
    {
        return volume;
    }


    /**
     * 
     * TODO testing
     * 
     * @return buyOrders
     */
    protected PriorityQueue<TradeOrder> getBuyOrders()
    {
        return buyOrders;
    }


    /**
     * 
     * TODO testing
     * 
     * @return sellOrders
     */
    protected PriorityQueue<TradeOrder> getSellOrders()
    {
        return sellOrders;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Stock.
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
