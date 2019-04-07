import java.awt.geom.*;
import java.util.ArrayList;
import gpdraw.*;

/**
 * TODO The Irregular Polygon class draws an irregular polygon. It also
 * calculates the area and perimeter of the polygon.
 * TODO To use it, simply put in x,y coordinates into the arraylist. When
 * running the program, call draw, perimeter, area to get results. To add
 * points you just have to call the add method.
 *
 * @author  TODO Kevin Deng
 * @version TODO 11/5/18
 *
 * @author  Period - TODO 3
 * @author  Assignment - TODO Irregular Polygon
 * 
 * @author  Sources - TODO list collaborators
 */
public class IrregularPolygon
{
     //= new DrawingTool( new SketchPad( 300, 300, 0 ));
    private ArrayList<Point2D.Double> myPolygon;

/**
 * Constructs an Irregular Polygon
 */
    
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
        
    }

/**
 * 
 * TODO The add method adds a point to the Point2D Double arraylist.
 * @param aPoint  the (x,y) coordinates
 */

    public void add( Point2D.Double aPoint )
    {
        myPolygon.add(aPoint);
    }

/**
 * 
 * TODO The perimeter method calculates each of the distance between the points
 * and then sums it up to get the perimeter. It is the absolute value because
 * perimeter is always positive.
 * @return  perimeter of the irregular polygon.
 */
    public double perimeter()
    {
        double p = 0;
        
        for (int i = 0; i < myPolygon.size(); i++)
        {
            if (i == myPolygon.size() - 1)
            {
                p += Math.sqrt((myPolygon.get(i).getX() - 
                                myPolygon.get(0).getX()) * 
                    (myPolygon.get(i).getX() - myPolygon.get(0).getX()) + 
                    (myPolygon.get(i).getY() - myPolygon.get(0).getY()) * 
                    (myPolygon.get(i).getY() - myPolygon.get(0).getY()));
            }
            else
            {
                p += Math.sqrt((myPolygon.get(i).getX() - 
                                myPolygon.get(i + 1).getX()) * 
                    (myPolygon.get(i).getX() - myPolygon.get(i + 1).getX()) + 
                    (myPolygon.get(i).getY() - myPolygon.get(i + 1).getY()) * 
                    (myPolygon.get(i).getY() - myPolygon.get(i + 1).getY()));
            }
        }
        return p;
    }

/**
 * 
 * TODO The area method requires two steps. The first being the sum of all the
 * lower half and the second being the sum of all the upper half. The difference
 * is then calculated of the two and the number is divided by 2. The absolute
 * value is taken at the end.
 * @return  area of the irregular polygon
 */
    public double area()
    {
        double lowerhalf = 0;
        double upperhalf = 0;
        
        for (int i = 0; i < myPolygon.size(); i++)
        {
            if (i == myPolygon.size() - 1)
            {
                lowerhalf += myPolygon.get(i).getX() * 
                                myPolygon.get(0).getY();
            }
            else
            {
                lowerhalf += myPolygon.get(i).getX() * 
                                myPolygon.get(i + 1).getY();
            }
        }
        
        for (int i = 0; i < myPolygon.size(); i++)
        {
            if (i == myPolygon.size() - 1)
            {
                upperhalf += myPolygon.get(i).getY() * myPolygon.get(0).getX();
            }
            else
            {
                upperhalf += myPolygon.get(i).getY() * 
                                myPolygon.get(i + 1).getX();
            }
        }
        
        return Math.abs((lowerhalf - upperhalf) / 2);
        
    }

/**
 * 
 * TODO draws the irregular polygon.
 */
    public void draw()
    {
        DrawingTool pen = new DrawingTool();
        pen.down();
        
        double currentx = pen.getXPos();
        double currenty = pen.getYPos();
        for (int i = 0; i < myPolygon.size(); i++)
        {
            pen.move(myPolygon.get(i).getX(), myPolygon.get(i).getY());
        }
        pen.move(currentx, currenty);
        pen.up();
    }
}
