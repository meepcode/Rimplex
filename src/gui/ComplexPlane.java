package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComplexPlane extends JFrame
{
  // testing
//  public static void main(String[] args) {
//    ComplexPlane plane = new ComplexPlane();
//    plane.setVisible(true);
//  }

  /**
   * attributes
   */
  private static final long serialVersionUID = 1L;
  private ComplexPanel panel;

  /**
   * Constructor.
   */
  public ComplexPlane()
  {
    panel = new ComplexPanel();
    add(panel);
    this.createUI();
    // panel.drawPoint(new Point(3, 4));
  }

  /**
   * Set plane frame
   */
  public void createUI()
  {
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setTitle("Complex Plane");
    setSize(700, 700);
    setVisible(false);
  }
}

/**
 * helper class to paint plane
 * 
 * @author jaxco
 *
 */
class ComplexPanel extends JPanel
{
  
  
  /**
   * constant attributes
   */
  private static final long serialVersionUID = 1L;
  // x-axis coord constants
  public static final int X_AXIS_FIRST_X_COORD = 50;
  public static final int X_AXIS_SECOND_X_COORD = 650;
  public static final int X_AXIS_Y_COORD = 350;

  // y-axis coord constants
  public static final int Y_AXIS_FIRST_Y_COORD = 50;
  public static final int Y_AXIS_SECOND_Y_COORD = 650;
  public static final int Y_AXIS_X_COORD = 350;

  // arrows of axis are represented with "hipotenuse" of
  // triangle
  // now we are define length of cathetas of that triangle
  public static final int FIRST_LENGHT = 10;
  public static final int SECOND_LENGHT = 5;

  // size of start coordinate lenght
  public static final int ORIGIN_COORDINATE_LENGHT = 6;

  // distance of coordinate strings from axis
  public static final int AXIS_STRING_DISTANCE = 20;

  // numerate axis
  int xCoordNumbers = 12;
  int yCoordNumbers = 12;
  int xLength = (X_AXIS_SECOND_X_COORD - X_AXIS_FIRST_X_COORD) / xCoordNumbers;
  int yLength = (Y_AXIS_SECOND_Y_COORD - Y_AXIS_FIRST_Y_COORD) / yCoordNumbers;

  private ArrayList<Point> points = new ArrayList<>();

  /**
   * Repaints graph with new complex point.
   * 
   * @param point
   */
  public void drawPoint(Point point)
  {
    points.add(point);
    repaint();
  }

  /**
   * Draws Point on panel
   * 
   * @param point
   * @param g
   */
  private void drawPointOnPanel(Point point, Graphics g)
  {
    final int pointDiameter = 5;
    final int x = X_AXIS_FIRST_X_COORD + (point.x * xLength) - pointDiameter / 2;
    final int y = Y_AXIS_SECOND_Y_COORD - (point.y * yLength) - pointDiameter / 2;
    System.out.println(Y_AXIS_FIRST_Y_COORD);
    System.out.println(y);
    g.fillOval(x, y, pointDiameter, pointDiameter);
  }

  /**
   * Paints Complex Plane
   */
  public void paintComponent(Graphics g)
  {

    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // x-axis
    g2.drawLine(X_AXIS_FIRST_X_COORD, X_AXIS_Y_COORD, X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
    // y-axis
    g2.drawLine(Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD, Y_AXIS_X_COORD, Y_AXIS_SECOND_Y_COORD);

    // x-axis arrow
    g2.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGHT, X_AXIS_Y_COORD - SECOND_LENGHT,
        X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
    g2.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGHT, X_AXIS_Y_COORD + SECOND_LENGHT,
        X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);

    // y-axis arrow
    g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT, Y_AXIS_FIRST_Y_COORD + FIRST_LENGHT, Y_AXIS_X_COORD,
        Y_AXIS_FIRST_Y_COORD);
    g2.drawLine(Y_AXIS_X_COORD + SECOND_LENGHT, Y_AXIS_FIRST_Y_COORD + FIRST_LENGHT, Y_AXIS_X_COORD,
        Y_AXIS_FIRST_Y_COORD);

    // draw origin Point
    // g2.fillOval(
    // X_AXIS_FIRST_X_COORD - (ORIGIN_COORDINATE_LENGHT / 2),
    // Y_AXIS_SECOND_Y_COORD - (ORIGIN_COORDINATE_LENGHT / 2),
    // ORIGIN_COORDINATE_LENGHT, ORIGIN_COORDINATE_LENGHT);
    g2.fillOval(347, 347, ORIGIN_COORDINATE_LENGHT, ORIGIN_COORDINATE_LENGHT);

    // draw text "X" and draw text "Y"
    g2.drawString("X", X_AXIS_SECOND_X_COORD - AXIS_STRING_DISTANCE / 2,
        X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
    g2.drawString("Y", Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
        Y_AXIS_FIRST_Y_COORD + AXIS_STRING_DISTANCE / 2);
    // draw center point (0,0)
    // g2.drawString("(0, 0)", X_AXIS_FIRST_X_COORD - AXIS_STRING_DISTANCE,
    // Y_AXIS_SECOND_Y_COORD + AXIS_STRING_DISTANCE);
    g2.drawString("(0, 0)", 352, 365);

    // draw x-axis numbers
    int xNum = -5;
    for (int i = 1; i < xCoordNumbers; i++)
    {

      if (xNum == 0)
      {
        xNum++;
        continue;
      }

      g2.drawLine(X_AXIS_FIRST_X_COORD + (i * xLength), X_AXIS_Y_COORD - SECOND_LENGHT,
          X_AXIS_FIRST_X_COORD + (i * xLength), X_AXIS_Y_COORD + SECOND_LENGHT);

      g2.drawString(Integer.toString(xNum), X_AXIS_FIRST_X_COORD + (i * xLength) - 3,
          X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
      xNum++;
    }

    // draw y-axis numbers
    int yNum = -5;
    for (int i = 1; i < yCoordNumbers; i++)
    {

      if (yNum == 0)
      {
        yNum++;
        continue;
      }

      String yAxis = Integer.toString(yNum) + "i";
      g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT, Y_AXIS_SECOND_Y_COORD - (i * yLength),
          Y_AXIS_X_COORD + SECOND_LENGHT, Y_AXIS_SECOND_Y_COORD - (i * yLength));
      g2.drawString(yAxis, Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
          Y_AXIS_SECOND_Y_COORD - (i * yLength));
      yNum++;
    }
    // draw points
    points.forEach(p -> drawPointOnPanel(p, g));
  }
}
