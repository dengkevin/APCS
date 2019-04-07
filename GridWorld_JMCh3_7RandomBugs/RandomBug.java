import info.gridworld.actor.Bug;
import java.awt.Color;

public class RandomBug extends Bug
{
    public RandomBug()
        {
            setColor( Color.YELLOW );
        }

        public RandomBug(Color bugColor )
        {
            setColor(bugColor );
        }

        public void turn(int angle)
        {
            turn();
            turn();
            turn();
            turn();
        }

        // Overrides Bug's act method
        public void act()
        {
            if (canMove()) {
                move();
            }
            
            else {
                int angle = 45 * (int)(Math.random() * 8);
                turn();
            }
        }
}