import java.util.Stack;

/**
 * 
 *  TODO Represents a BrowserModel
 *  TODO There are 6 methods in this class. The back method allows you to
 *  "access" the previous page that you have visited. The forward method
 *  essentially does the exact opposite, letting you visit again the next page
 *  if you previously clicked back. Home method returns you back to line 0 and
 *  followLink will let you go to any line. There are 2 helper methods that
 *  check whether or not you can go back or not.
 *
 *  @author  Kevin Deng
 *  @version Jan 22, 2019
 *  @author  Period: TODO 3
 *  @author  Assignment: JMCh21_3Browsing
 *
 *  @author  Sources: TODO
 */
public class BrowserModel
{
    private BrowserView view;
    private Stack<Integer> backStk;
    private Stack<Integer> forwardStk;
    private int topLine;

    /**
     * Constructs a Browser Model
     * @param view  used to update the location
     */
    public BrowserModel(BrowserView view) {
        
        this.view = view;
        this.view.update(topLine);
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();
    }
    
    /**
     * 
     * TODO Accesses the last page you visited
     */
    public void back()
    {
        forwardStk.push(topLine);
        
        if (hasBack())
        {
            topLine = backStk.pop();
        }
        
        view.update(topLine);
    }
    
    /**
     * 
     * TODO Access the next page you visit. Essentially, if you click back,
     * then call the forward method, you will end up where you originally were
     */
    public void forward()
    {
        
        backStk.push(topLine);
        
        if (hasForward())
        {
            topLine = forwardStk.pop();
        }
        
        view.update(topLine);
    }
    
    /**
     * 
     * TODO Returns the browser to line 0
     */
    public void home()
    {
        while (!(forwardStk.isEmpty()))
        {
            forwardStk.pop();
        }
        while (!(backStk.isEmpty()))
        {
            backStk.pop();
        }
        topLine = 0;
        view.update(topLine);
    }
    
    /**
     * 
     * TODO Represents a hyperlink
     * @param n  the line to go to
     */
    public void followLink(int n)
    {
        backStk.push(topLine);
        topLine = n;
        view.update(topLine);
    }
    
    /**
     * 
     * TODO Checks if you can go back
     * @return  true  if there is a back
     */
    public boolean hasBack()
    {
        return !(backStk.isEmpty());
    }
    
    /**
     * 
     * TODO Checks if you can go forward
     * @return  true  if there is a forward
     */
    public boolean hasForward()
    {
        return !(forwardStk.isEmpty());
    }


    /**
     * 
     * TODO Testing purposes
     * @return  backStk  test
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }

    /**
     * 
     * TODO Testing purposes
     * @return  topLine  test
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }

    /**
     * 
     * TODO Testing purposes
     * @return  topLine  test
     */
    public int getTopLine()
    {
        return topLine;
    }
}

