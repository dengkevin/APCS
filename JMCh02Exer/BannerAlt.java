// This applet displays a message moving horizontally
// across the screen.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BannerAlt extends JApplet
  implements ActionListener
{
  private int msgID = 1;
  private int xPos, yPos;  // hold the coordinates of the banner

  public void init()
  {
    Container c = getContentPane();
    c.setBackground(Color.WHITE);
    xPos = c.getWidth() / 2;
    yPos = c.getHeight() / 2;
    Timer clock = new Timer(2000, this);  // fires every 30 milliseconds 
    clock.start();
  }

  // Called automatically after a repaint request
  public void paint(Graphics g)
  {
    super.paint(g);
    if (msgID == 1) {
        g.setColor(Color.BLACK);
        g.drawString("East or West", xPos + 60, yPos + 60);
        }
    if (msgID == -1) {
        g.setColor(Color.BLACK);
        g.drawString("Java is Best", xPos + 60, yPos + 60);
        }
    }
    
    

  // Called automatically when the timer fires
  public void actionPerformed(ActionEvent e)
  {
    Container c = getContentPane();

    msgID = -msgID;
    
    repaint();
  }
}