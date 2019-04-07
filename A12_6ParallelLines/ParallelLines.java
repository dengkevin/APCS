import java.awt.*;
import javax.swing.*;

/**
   TODO class ParallelLines prints out a picture of parallel lines with 7 black
   squares and 7 "white" squares filling up each line in a pattern. This occurs
   8 times total.
   TODO The class ultimately prints out 8 lines and in between each of those
   lines, black and white squares in repeating pattern will be printed out.
   However, the black squares will have an offset and some will start in 
   different positions than others. This creates a rippled look and represents
   an illusion.
  
   @author  TODO Kevin Deng
   @version TODO 9/21

   Period - TODO 3
   Assignment - A12.6 - ParallelLines

   Sources - TODO list collaborators
 */
public class ParallelLines extends JPanel
{
    
    private int drawHeight;
    private int offset;
    private int ydown;
    
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background
    
    int width = getWidth();    
    int height = getHeight();
    
    drawIllusion(g, width, height);
  }

  /**
     TODO the methods drawIllusion prints out the graphics of ParallelLines
     illusion and takes arguments width and height.
     
     
     @param g   object from the class Graphics
     @param width   the length of the width of the total grid area
     @param height   the length of the height of the total grid area
     @param size  not used
   */
  public void drawIllusion(Graphics g, int width, int height)
  {
      drawHeight = height / 10;
      
      offset = 0;
      ydown = 0;
      
      for (int row = 0; row < 8; row++)
      {
          if (row == 0 || row == 4)
          {
              offset = 0;
          }
          if (row == 2 || row == 6)
          {
              offset = 30;
          }
          if (row % 2 == 1)
          {
              offset = 15;
          }
          
          for (int col = 0; col < 7; col++)
          {
              g.fillRect(offset, ydown, width / 14, width / 14);
              offset += 2 * (width / 14);
              g.drawLine( 10, drawHeight, width - 10, drawHeight);
          }
          ydown += height / 10;
          drawHeight += height / 10;
      }
  }
  
  public static void main(String[] args)
  {
    JFrame w = new JFrame("ParallelLines");
    w.setBounds(100, 100, 640, 480);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ParallelLines panel = new ParallelLines();
    panel.setBackground(Color.WHITE);
    Container c = w.getContentPane();
    c.add(panel);
    w.setResizable(true);
    w.setVisible(true);
  }
}
