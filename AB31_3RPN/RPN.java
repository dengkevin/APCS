import java.util.*;

/**
 * RPN Calculator
 *
 * @author TODO Kevin Deng
 * @version TODO 1/17
 * @author Period: TODO 3
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: TODO List Collaborators
 */
/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  Kevin Deng
 *  @version Jan 18, 2019
 *  @author  Period: TODO 3
 *  @author  Assignment: AB31_3RPN
 *
 *  @author  Sources: TODO
 */
public class RPN
{
    private Scanner scan = new Scanner( System.in );
    
    private Stack<Integer> myStack;
    private Queue<String> myQ;

    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }
    
    /**
     *  **** Used for testing - Do Not Remove ***
     *  
     *  Constructs an RPN Calculator and then redirects the Scanner input
     *  to the supplied string.
     *  
     *  @param console  replaces console input
     */
    public RPN(String console)
    {
        this();
        scan = new Scanner( console );
    }

    /**
     * TODO Calculates the value from the RPN expression
     */
    public void calculate()
    {
        while (scan.hasNext())
        {
            int length = 0;
            String scanned = scan.next();
            
            while (length < scanned.length())
            {
                char c = scanned.charAt(length);
                
                if (c != 'Q' && c != 'q')
                {
                    myQ.add(c + " ");
                }
                
                if (c == 'Q' || c == 'q')
                {
                    String problem = combine();
                    int answer = myStack.pop();
                    System.out.println(problem + "= " + answer);
                }
                
                else if (c == '+')
                {
                    add();
                }
                
                else if (c == '-')
                {
                    subtract();
                }
                
                else if (c == '*')
                {
                    multiply();
                }
                
                else if (c == '/')
                {
                    divide();
                }
                else
                {
                    myStack.push(Character.getNumericValue(c));
                }
                
                length++;
            }
        }
    }

    /**
     * 
     * TODO adds two values
     */
    public void add()
    {
        myStack.push(myStack.pop() + myStack.pop());
    }
    
    /**
     * 
     * TODO subtracts two values
     */
    public void subtract()
    {
        int one = myStack.pop();
        int two = myStack.pop();
        myStack.push(two - one);
    }
    
    /**
     * 
     * TODO multiplies two values
     */
    public void multiply()
    {
        myStack.push(myStack.pop() * myStack.pop());
    }
    
    /**
     * 
     * TODO divides two values
     */
    public void divide()
    {
        int one = myStack.pop();
        int two = myStack.pop();
        myStack.push(two / one);
    }
    
    /**
     * 
     * TODO combines and returns the expression
     * @return result  the expression
     */
    public String combine()
    {
        String result = "";
        
        while (!myQ.isEmpty())
        {
            result += myQ.peek();
            myQ.remove();
        }
        
        return result;
    }
    
    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args  command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}