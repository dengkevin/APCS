import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 *  Test for the complex number class.
 *  
 *  testConstructor1Param - test the 1 parameter constructor
 *  testConstructor2Param - test the 2 parameter constructor
 *  testAddRealAndComplexNum - addition of a complex number 
 *     with a real number
 *  testAdd2ComplexNums - addition of two complex numbers
 *  testMultiply2ComplexNums - multiplication of two complex numbers
 *  testMultiplyRealAndComplexNum - multiplication of a complex number
 *     with a real number
 *  testAbsoluteValue - absolute value of a complex number
 *
 *  @author  TODO Kevin Deng
 *  @version TODO 10/7
 *  @author  Period: TODO 3
 *  @author  Assignment: JMCh09Ex17_Complex 
 *
 *  @author  Sources: TODO List collaborators
 */
public class ComplexJUTest extends junit.framework.TestCase
{
    private Complex c1 = new Complex(5, 8);
    private Complex c2 = new Complex(5);
    private Complex c3 = new Complex(4, 2);
    private Complex c4 = new Complex(6, 8);
    
    @Test
    public void testConstructor1Param()
    {
        assertEquals("5.0 + 0.0i", c2.toString());
    }

    @Test
    public void testConstructor2Param()
    {
        assertEquals("5.0 + 8.0i", c1.toString());
    }

    @Test
    public void testAddRealAndComplexNum()
    {
        assertEquals("10.0 + 8.0i", c1.add(5.0).toString());
    }
    
    @Test
    public void testAdd2ComplexNums()
    {
        assertEquals("9.0 + 10.0i", c1.add(c3).toString());
    }

    @Test
    public void testMultiply2ComplexNums()
    {
        assertEquals("4.0 + 42.0i", c1.multiply(c3).toString());
    }

    @Test
    public void testMultiplyRealAndComplexNum()
    {
        assertEquals("25.0 + 40.0i", c1.multiply(5.0).toString());
    }

    @Test
    public void testAbsoluteValue()
    {
        assertEquals(10.0, c4.abs());
    }
    
    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }

    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
