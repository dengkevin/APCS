/**
 * A price comparator for trade orders.
 * @author Kevin Deng
 * @version 1
 */
public class PriceComparator implements java.util.Comparator<TradeOrder>
{
    private boolean ascending;


    /**
     * Constructs a PriceComparator
     */
    public PriceComparator()
    {
        ascending = true;
    }


    /**
     * Constructs a PriceComparator
     * 
     * @param asc
     *            indicates ascending or descending
     */
    public PriceComparator( boolean asc )
    {
        ascending = asc;
    }


    /**
     * Compares two trade orders.
     * 
     * @param order1  the first order
     * @param order2  the second order
     * @return 0, -1, 1 or the difference
     */
    public int compare( TradeOrder order1, TradeOrder order2 )
    {
        if ( order1.isMarket() && order2.isMarket() )
        {
            return 0;
        }
        else if ( order1.isMarket() && !( order2.isMarket() ) )
        {
            return -1;
        }
        else if ( !( order1.isMarket()) && order2.isMarket() )
        {
            return 1;
        }
        else
        {
            if ( ascending )
            {
                return (int)(order1.getPrice() * 100 - order2.getPrice() * 100);
            }
            else
            {
                return (int)(order2.getPrice() * 100 - order1.getPrice() * 100);
            }
        }
    }
}
