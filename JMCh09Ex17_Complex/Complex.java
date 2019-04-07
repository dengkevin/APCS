/**
 * Represents a complex number of the form a + bi. Provides methods for
 * adding, multiplying and calculating the absolute value.
 *
 *  @author  TODO Kevin Deng
 *  @version TODO 10/04/18
 *  @author  Period: TODO 3
 *  @author  Assignment: JMCh09Ex17_Complex 
 *
 *  @author  Sources: TODO List collaborators
 */
public class Complex
{
    private double a;
    private double b;

/**
 * Constructs a complex number with the real number value to a
 * and sets the imaginary number value to be 0.0
 * @param a  real number value
 */
    public Complex(double a)
    {
        this.a = a;
        this.b = 0.0;
    }

/**
 * Constructs a complex number
 * @param a  real number value
 * @param b  imaginary number value
 */
    public Complex(double a, double b)
    {
        this.a = a;
        this.b = b;
    }

/**
 * 
 * TODO Returns the absolute value of the a and b values
 * @return  square root of a squared plus b squared
 */
    public double abs()
    {
        return Math.sqrt(a * a + b * b);
    }

/**
 * 
 * TODO Adds two complex numbers
 * @param other  the other complex number that will be added
 * @return  sum of the two complex numbers
 */
    public Complex add(Complex other)
    {
        return new Complex((this.a + other.a), (this.b + other.b)); 
    }

/**
 * 
 * TODO Multiplies two complex numbers
 * @param other  the other complex number that will be multiplied
 * @return  product of the two complex numbers
 */
    public Complex multiply(Complex other)
    {
        return new Complex(this.a * other.a - this.b * other.b, 
            this.a * other.b + this.b * other.a); 
    }
    
/**
 * 
 * TODO Adds one complex number to a real double.
 * @param c  the double that will be added
 * @return  sum of the complex number and the real number
 */
    public Complex add(double c) 
    {
        
        return new Complex(this.a + c, this.b);
    }
    
/**
 * 
 * TODO Multiplies one complex number to a real double.
 * @param c  the double that will be multiplied.
 * @return  product of the complex number and the real number
 */
    public Complex multiply(double c) 
    {
        
        return new Complex(this.a * c, this.b * c);  
    }

/**
 * Represents the complex number as a string.
 * @return  returns the complex number in the form of a string.
 */
    public String toString()
    {
        return a + " + " + b + "i";
    }
}
