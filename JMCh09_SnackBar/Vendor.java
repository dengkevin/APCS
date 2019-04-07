import java.lang.reflect.*;

/**
   This class implements a vendor that sells one kind of item.
   A vendor carries out sales transactions.

   @author  TODO Kevin Deng
   @version TODO 10/02

   @author Period - TODO 3
   @author Assignment - Java Methods Ch09 - SnackBar

   @author Sources - TODO list collaborators
 */
public class Vendor
{
    
    private int stock;
    private int price;
    private int deposit;
    private int change;
    private static double totalSales;

/**
 * Constructs the objects of Vendor class
 * @param price  price of a single item in cents
 * @param stock  number of items to place in stock
 */
    public Vendor(int price, int stock)
    {
        this.price = price;
        this.stock = stock;
        deposit = 0;
        change = 0;
        totalSales = 0;
    }
/**
 * 
 * TODO Returns the amount of the total sales and sets the value back to zero.
 * @return temp (temporary variable for totalSales)
 */
    public static double getTotalSales()
    {
        double temp = totalSales;
        totalSales = 0;
        return temp;
    }
/**
 * 
 * TODO Sets the stock value.
 * @param stock takes a integer value and sets stock to that value
 */
    public void setStock(int stock)
    {
        this.stock = stock;
    }
/**
 * 
 * TODO Returns the stock value.
 * @return stock
 */
    public int getStock()
    {
        return stock;
    }
/**
 * 
 * TODO Adds money to the deposit amount only if there is stock
 * @param cents  adds the amount in cents to the deposit
 */
    public void addMoney(int cents)
    {
        if (stock > 0)
        {
            deposit += cents;
        }
    }
/**
 * 
 * TODO Returns deposit
 * @return deposit
 */
    public int getDeposit()
    {
        return deposit;
    }
/**
 * 
 * TODO Calculates if a sale can occur, and if it does, the method will add
 * the sale to the total price, subtract from the stock, and calculate the 
 * appropriate change that will be given to the user.
 * @return true/false (whether a sale can take place)
 */
    public boolean makeSale()
    {
        if (stock > 0 && deposit >= price)
        {
            totalSales += 0.01 * price;
            stock--;
            if (deposit > price) {
                change = deposit - price;
            }
            deposit = 0;
            return true;
        }
        else
        {
            change = deposit;
            deposit = 0;
            return false;
        }
    }
/**
 *    
 * TODO returns the change
 * @return temp (temporary variable for change)
 */
    public int getChange()
    {
        int temp = change;
        change = 0;
        return temp;

    }

    /**
        Intended only for debugging.
        
        <p>A generic toString implementation that uses reflection to print
        names and values of all fields <em>declared in this class</em>.
        Note that superclass fields are left out of this implementation.</p>
        
        @return  a string representation of this Vendor.
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
                str += separator + field.getName() + ":" + field.get( this );
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
