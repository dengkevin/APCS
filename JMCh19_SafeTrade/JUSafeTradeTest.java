import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.regex.*;

import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 * SafeTrade tests:
 *   TradeOrder
 *   PriceComparator
 *   Trader
 *   Brokerage
 *   StockExchange
 *   Stock
 *
 * @author TODO Kevin Deng (priceComparator, Trader, Stock)
 * @author TODO Raymond Hsu (stockExchange, Stock)
 * @author TODO Justin Lam (Brokerage, some Stock)
 * @version TODO date
 * @author Assignment: JM Chapter 19 - SafeTrade
 * 
 * @author Sources: TODO sources
 *
 */
public class JUSafeTradeTest
{
    // --Test TradeOrder
    /**
     * TradeOrder tests:
     *   TradeOrderConstructor - constructs TradeOrder and then compare toString
     *   TradeOrderGetTrader - compares value returned to constructed value
     *   TradeOrderGetSymbol - compares value returned to constructed value
     *   TradeOrderIsBuy - compares value returned to constructed value
     *   TradeOrderIsSell - compares value returned to constructed value
     *   TradeOrderIsMarket - compares value returned to constructed value
     *   TradeOrderIsLimit - compares value returned to constructed value
     *   TradeOrderGetShares - compares value returned to constructed value
     *   TradeOrderGetPrice - compares value returned to constructed value
     *   TradeOrderSubtractShares - subtracts known value & compares result
     *     returned by getShares to expected value
     */
    private String symbol = "GGGL";
    private boolean buyOrder = true;
    private boolean marketOrder = true;
    private int numShares = 123;
    private int numToSubtract = 24;
    private double price = 123.45;

    @Test
    public void tradeOrderConstructor()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        String toStr = to.toString();

        assertTrue( "<< Invalid TradeOrder Constructor >>",
                    toStr.contains( "TradeOrder[Trader trader:null" )
                        && toStr.contains( "java.lang.String symbol:" + symbol )
                        && toStr.contains( "boolean buyOrder:" + buyOrder )
                        && toStr.contains( "boolean marketOrder:" + marketOrder )
                        && toStr.contains( "int numShares:" + numShares )
                        && toStr.contains( "double price:" + price ) );
    }
    
    @Test
    public void TradeOrderToString()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertNotNull( to.toString() );
    }

    @Test
    public void tradeOrderGetTrader()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertNull( "<< TradeOrder: " + to.getTrader() + " should be null >>",
                    to.getTrader() );
    }

    @Test
    public void tradeOrderGetSymbol()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertEquals( "<< TradeOrder: " + to.getTrader() + " should be "
            + symbol + " >>", symbol, to.getSymbol() );
    }

    @Test
    public void tradeOrderIsBuy()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );

        assertTrue( "<< TradeOrder: " + to.isBuy() + " should be " + buyOrder
            + " >>", to.isBuy() );
    }

    @Test
    public void tradeOrderIsSell()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertFalse( "<< TradeOrder: " + to.isSell() + " should be "
            + !buyOrder + " >>", to.isSell() );
    }

    @Test
    public void tradeOrderIsMarket()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertTrue( "<< TradeOrder: " + to.isMarket() + " should be "
            + marketOrder + " >>", to.isMarket() );
    }

    @Test
    public void tradeOrderIsLimit()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );

        assertFalse( "<< TradeOrder: " + to.isLimit() + " should be "
            + !marketOrder + ">>", to.isLimit() );
    }

    @Test
    public void tradeOrderGetShares()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertTrue( "<< TradeOrder: " + to.getShares() + " should be "
            + numShares + ">>", numShares == to.getShares()
            || ( numShares - numToSubtract ) == to.getShares() );
    }

    @Test
    public void tradeOrderGetPrice()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        assertEquals( "<< TradeOrder: " + to.getPrice() + " should be " + price
            + ">>", price, to.getPrice(), 0.0 );
    }

    @Test
    public void tradeOrderSubtractShares()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder,
            numShares, price );
        to.subtractShares( numToSubtract );
        assertEquals( "<< TradeOrder: subtractShares(" + numToSubtract
            + ") should be " + ( numShares - numToSubtract ) + ">>", numShares
            - numToSubtract, to.getShares() );
    }
    
    // --Test TraderWindow Stub
    @Test
    public void traderWindowConstructor()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
    }

    @Test
    public void traderWindowShowMessage()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
        tw.showMessage( null );
    }

    //  --Test PriceComparator
    /**
     * 
     * PriceComparator tests:
     *   priceComparatorAscTest - tests ascending for compareTo if both limits
     *   priceComparatorDesTest - tests descending for compareTo if both limits
     *   bothMarketTest - tests both markets
     *   firstMarketSecondLimitTest - tests first market, second limit
     *   firstLimitSecondMarketTest - tests first limit, second market
     */
    
    @Test
    public void priceComparatorAscTest()
    {
        //ASSUME BOTH ARE LIMITS
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        StockExchange testStockExchangeOne = new StockExchange();
        Brokerage testBrokerageOne = new Brokerage(testStockExchangeOne);
        Trader testTraderOne = new Trader(testBrokerageOne, "test name", "test pass");
        PriceComparator testPC = new PriceComparator();
        TradeOrder testOrder = new TradeOrder(testTrader, symbol, buyOrder, false, numShares, price);
        TradeOrder testOrderOne = new TradeOrder(testTraderOne, symbol, buyOrder, false, numShares, price + 1);
        assertTrue(testPC.compare(testOrder, testOrderOne) == (int)(testOrder.getPrice() * 100 - testOrderOne.getPrice() * 100));
    }
    
    @Test
    public void priceComparatorDesTest()
    {
        //Assume both are LIMITS
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        StockExchange testStockExchangeOne = new StockExchange();
        Brokerage testBrokerageOne = new Brokerage(testStockExchangeOne);
        Trader testTraderOne = new Trader(testBrokerageOne, "test name", "test pass");
        PriceComparator testPC = new PriceComparator(false);
        TradeOrder testOrder = new TradeOrder(testTrader, symbol, buyOrder, false, numShares, price + 1);
        TradeOrder testOrderOne = new TradeOrder(testTraderOne, symbol, buyOrder, false, numShares, price);
        assertTrue(testPC.compare(testOrder, testOrderOne) == (int)(testOrderOne.getPrice() * 100 - testOrder.getPrice() * 100));
    }
    
    @Test
    public void bothMarketTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        StockExchange testStockExchangeOne = new StockExchange();
        Brokerage testBrokerageOne = new Brokerage(testStockExchangeOne);
        Trader testTraderOne = new Trader(testBrokerageOne, "test name", "test pass");
        PriceComparator testPC = new PriceComparator();
        TradeOrder testOrder = new TradeOrder(testTrader, symbol, buyOrder, true, numShares, price);
        TradeOrder testOrderOne = new TradeOrder(testTraderOne, symbol, buyOrder, true, numShares, price);
        assertTrue(testPC.compare(testOrder, testOrderOne) == 0);
    }
    
    @Test
    public void firstMarketSecondLimitTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        StockExchange testStockExchangeOne = new StockExchange();
        Brokerage testBrokerageOne = new Brokerage(testStockExchangeOne);
        Trader testTraderOne = new Trader(testBrokerageOne, "test name", "test pass");
        PriceComparator testPC = new PriceComparator();
        TradeOrder testOrder = new TradeOrder(testTrader, symbol, buyOrder, true, numShares, price);
        TradeOrder testOrderOne = new TradeOrder(testTraderOne, symbol, buyOrder, false, numShares, price);
        assertTrue(testPC.compare(testOrder, testOrderOne) == -1);
    }
    
    @Test
    public void firstLimitSecondMarketTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        StockExchange testStockExchangeOne = new StockExchange();
        Brokerage testBrokerageOne = new Brokerage(testStockExchangeOne);
        Trader testTraderOne = new Trader(testBrokerageOne, "test name", "test pass");
        PriceComparator testPC = new PriceComparator();
        TradeOrder testOrder = new TradeOrder(testTrader, symbol, buyOrder, false, numShares, price);
        TradeOrder testOrderOne = new TradeOrder(testTraderOne, symbol, buyOrder, true, numShares, price);
        assertTrue(testPC.compare(testOrder, testOrderOne) == 1);
    }
    
    // --Test Trader
    
    /**
     * Trader tests:
     *   traderConstructorTest - creates constructor and tests toString
     *   compareToTest - tests compareTo method
     *   equalsTest - tests equal method
     *   getNameTest - tests getsName
     *   getPasswordTest - tests getPassword
     *   getQuoteTest - tests getQuote
     *   hasMessagesTest - tests if there are messages
     *   openWindowTest - tests openWindow and mailbox not empty
     *   placeOrderTest - tests to place an order
     *   quitTest -  tests to see if successful with quitting
     *   traderToStringTest - tests toString method
     *   
     */
    
    @Test //TODO
    public void traderConstructorTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(brokerage, "test name", "test pass");
        String toStr = testTrader.toString();
        
        assertTrue( "<< Invalid Trader Constructor >>",
            toStr.contains("Trader[Brokerage brokerage")
            && toStr.contains( "java.lang.String screenName:" + "test name" )
            && toStr.contains( "java.lang.String password:" + "test pass")
            && testTrader.mailbox() != null && testTrader.mailbox().isEmpty());
    }
    
    @Test
    public void compareToTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        StockExchange testStockExchangeone = new StockExchange();
        Brokerage testBrokerageone = new Brokerage(testStockExchangeone);
        Trader t1 = new Trader(testBrokerageone, "test name", "test pass");
        
        assertTrue(testTrader.compareTo(t1) == 0);
    }
    
    @Test
    public void equalsTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        StockExchange testStockExchangeone = new StockExchange();
        Brokerage testBrokerageone = new Brokerage(testStockExchangeone);
        Trader t1 = new Trader(testBrokerageone, "test name", "test pass");
        
        assertTrue(testTrader.equals(t1));
    }
    
    @Test
    public void getNameTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        
        assertTrue(testTrader.getName().equals("test name"));
    }
    
    @Test
    public void getPasswordTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        
        assertTrue(testTrader.getPassword().equals("test pass"));
    }
    
    @Test
    public void getQuoteTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        
        testStockExchange.listStock(symbol, "test name", price);
        testTrader.getQuote(symbol);
        
        assertFalse(testTrader.mailbox().isEmpty());
    }
    
    @Test
    public void hasMessagesTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");

        testTrader.receiveMessage("test message");
        assertFalse(testTrader.mailbox().isEmpty());
    }
    
    @Test
    public void openWindowTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");

        testTrader.receiveMessage("test message");
        testTrader.openWindow();
        
        assertTrue(testTrader.mailbox().isEmpty());
    }
    
    @Test //TODO
    public void placeOrderTest()
    {
        StockExchange testStockExchange = new StockExchange();
        testStockExchange.listStock(symbol, "Giggle.com", price);
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        
        TradeOrder testOrder = new TradeOrder(testTrader, symbol, buyOrder, marketOrder, numShares, price);
        testTrader.placeOrder(testOrder);
        
        assertFalse(testStockExchange.getListedStocks().get(symbol).getBuyOrders().isEmpty());
        assertFalse(testTrader.mailbox().isEmpty());
    }
    
    @Test
    public void quitTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        
        testBrokerage.login("test name", "test pass");
        testTrader.quit();
        assertTrue(testBrokerage.getLoggedTraders().isEmpty());
    }
    
    @Test
    public void traderToStringTest()
    {
        StockExchange testStockExchange = new StockExchange();
        Brokerage testBrokerage = new Brokerage(testStockExchange);
        Trader testTrader = new Trader(testBrokerage, "test name", "test pass");
        assertNotNull(testTrader.toString());
    }
    
    
    // --Test Brokerage
    
    /**
     * Brokerage Tests:
     * BrokerageConstructor - constructs Brokerage and then compares toString
     * BrokerageGetQuote - constructs value returned to constructed value
     * BrokerageAddUser - constructs value returned to constructed value
     * BrokerageLogin - constructs value returned to constructed value
     * BrokerageLogout - constructs value returned to constructed value
     * BrokeragePlaceOrder - constructs value returned to constructed value
     * BrokerageToStringTest - constructs value returned to constructed value
     * 
     */
    
    public void brokerageConstructor()
    {
        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );
        
        String toStr = brokerage.toString();
        
        assertTrue( "<< Invalid Trader Constructor >>",
            toStr.contains("Brokerage["));
        
    }
    
    @Test
    public void brokerageGetQuote()
    {

        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );
        Trader trader = new Trader(brokerage, "name", "password");

        brokerage.getQuote("symbol", trader);

        assertTrue("Brokerage: should have a message", trader.hasMessages());
    }
    
    @Test
    public void brokerageAddUser()
    {
        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );

        assertTrue( "Screen name not found", 
            brokerage.addUser("n", "password") == -1);

        assertTrue( "Invalid password", 
            brokerage.addUser("name2", "p") == -2 );

        brokerage.addUser( "sameName", "password" );
        assertTrue( "User is already logged in", 
            brokerage.addUser("sameName", "password") == -3 );

        assertTrue( "Successful or negative integer",
            brokerage.addUser("name2", "password") == 0 );
    }

    
    @Test
    public void brokerageLogin()
    {
    
        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );
        
        brokerage.addUser( "name", "password" );  
        assertTrue("Screen name not found", brokerage.login( "name1",  "password" ) == -1);
        
        brokerage.addUser( "name2", "password2" );
        assertTrue("Invalid login password", brokerage.login( "name2", "password" ) == -2);
        
        brokerage.addUser( "name3", "password3" );
        brokerage.login("name3", "password3");     
        assertTrue("Already logged in", brokerage.login( "name3", "password3" ) == -3);
        
        brokerage.addUser("name0", "password0");
        assertTrue("Successful", brokerage.login("name0", "password0") == 0);
        
    }
    
    @Test
    public void brokerageLogout()
    {
        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );
        
        Trader trader = new Trader(brokerage, "name", "password");

        brokerage.addUser("name", "password");
        brokerage.login("name", "password");

        brokerage.logout(trader);

        assertFalse("Brokerage logout", brokerage
                .getLoggedTraders().contains(trader));
    }

    @Test
    public void BrokeragePlaceOrder()
    {
        StockExchange stockExchange = new StockExchange();
        stockExchange.listStock(symbol, "Giggle.com", price);

        Brokerage brokerage = new Brokerage( stockExchange );
        
        Trader trader = new Trader(brokerage, "name", "password");

        TradeOrder tradeOrder = new TradeOrder(trader, symbol, buyOrder, marketOrder, numShares, price);
        brokerage.placeOrder(tradeOrder);

        assertFalse(stockExchange.getListedStocks().get(symbol).getBuyOrders().isEmpty());
        assertFalse(trader.mailbox().isEmpty());

    }
    
    @Test
    public void BrokerageToStringTest()
    {
        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );

        assertNotNull(brokerage.toString());
    }
    
    
    // --Test StockExchange
    
    /** StockExchange tests: 
     *StockExchangeConstructor - constructs StockExchange
    * and then compare fields - compares values returned to values entered
    * StockExchangeGetQuote - checks to see if calling the method for a
    * Nonexistent stock returns a message that the result was not found
    * TradeOrderIsBuy - compares value returned to constructed value
    * StockExchangeListStock - compares value returned to constructed value
    * StockExchangePlaceOrder - executes the method and checks to see if a
    * message showing proof of the transaction was sent constructed value
    */

    @Test
    public void stockExchangeConstructor()
    {
        StockExchange test = new StockExchange();

        assertTrue( "<< Invalid StockExchange Constructor >>",
            test.getListedStocks() != null && test.getListedStocks().isEmpty() );
    }


    @Test
    public void stockExchangeGetQuote()
    {
        StockExchange test = new StockExchange();

        assertTrue( "<< Test.getQuote() should not have returned a quote >>",
            test.getQuote( "gobledygook should not be found" ).contains( "not found" ) );
    }


    @Test
    public void stockExchangeListStock()
    {
        StockExchange test = new StockExchange();
        Stock x = new Stock( symbol, "name", price );
        test.listStock( symbol, "name", price );

        assertTrue(
            "<< StockExchange: ListStock(" + symbol + "," + "name," + price
                + ") should contain a Stock >>",
            !test.getListedStocks().isEmpty() );

    }


    @Test
    public void stockExchangePlaceOrder()
    {
        StockExchange test = new StockExchange();
        Brokerage b = new Brokerage( test );
        Trader x = new Trader( b, "Joe", "pswd" );
        test.listStock( symbol, "name", numShares );

        test.placeOrder( new TradeOrder( x, symbol, buyOrder, marketOrder, 1, price ) );
        assertTrue(
            "< StockExchange: placeOrder( trader, " + symbol + ", " + buyOrder + ", " + marketOrder
                + ", 1, " + price
                + " ) should have sent a message to the trader after placing the order >",
            !x.mailbox().isEmpty() );
    }


    @Test
    public void stockExchangeToString()
    {
        StockExchange test = new StockExchange();
        assertNotNull( test.toString() );
    }
    
    
 // --Test Stock
    /**
     * Stock tests: 
     * StockConstructorTest - constructs Stock Object and tests if successful
     * StockGetQuoteTest - tests for getQuote
     * StockPlaceQuoteTest - tests for placeQuote and successfulness
     * StockToStringTest - tests the toString method
     * StockExecuteOrders - tests whether an order is successfully executed

     */

    @Test
    public void stockConstructorTest()
    {
        Stock test = new Stock( symbol, "name", price );
        assertTrue( "<< Invalid StockExchange Constructor >>",
            test.getHiPrice() == price && test.getLoPrice() == price && test.getLastPrice() == price
                && test.getStockSymbol().equals( symbol ) && test.getCompanyName().equals( "name" )
                && test.getVolume() == 0 && test.getBuyOrders().isEmpty()
                && test.getSellOrders().isEmpty() );
    }


    @Test
    public void stockGetQuoteTest()
    {
        Stock test = new Stock( symbol, "name", price );
        String x = test.getQuote();

        assertTrue( "<< Invalid StockQuote information >>",
            x.contains( "name" ) && x.contains( symbol ) && x.contains( price + "" )
                && x.contains( test.getLoPrice() + "" ) && x.contains( test.getHiPrice() + "" )
                && x.contains( test.getVolume() + "" ) );

        // && (x.contains("none") || x.contains(
        // test.getSellOrders().peek().getShares() )
    }


    @Test
    public void stockPlaceOrderTest()
    {
        Stock thing = new Stock( symbol, "name", price );
        StockExchange test = new StockExchange();
        Brokerage b = new Brokerage( test );
        Trader x = new Trader( b, "Joe", "pswd" );
        test.listStock( symbol, "name", numShares );

        thing.placeOrder( new TradeOrder( x, symbol, buyOrder, marketOrder, 1, price ) );
        assertTrue(
            "< Stock: placeOrder( trader, " + symbol + ", " + buyOrder + ", " + marketOrder
                + ", 1, " + price
                + " ): should have sent a message to the trader after placing the order >",
            !x.mailbox().isEmpty() );
    }


    @Test
    public void stockToStringTest()
    {
        Stock test = new Stock( symbol, "name", price );
        // test.toString();
        assertNotNull( " Test.toString() should return a String ", test.toString() );
    }

    @Test
    public void stockExecuteOrdersTest()
    {
        Stock testS = new Stock(symbol, "test", price);
        StockExchange testSE = new StockExchange();
        Brokerage testB = new Brokerage(testSE);
        Trader testT = new Trader(testB, "test", "test");
        TradeOrder testTO = new TradeOrder(testT, symbol, true, marketOrder, numShares, price);
        testS.placeOrder(testTO);
        
        assertTrue(testT.hasMessages());
    }
    
    // Remove block comment below to run JUnit test in console

    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( JUSafeTradeTest.class );
    }
    
    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "JUSafeTradeTest" );
    }

}

