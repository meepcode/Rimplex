package gui;

import settings.LanguageChangeable;
import settings.Settings;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import calculation.ComplexNumber;

/**
 * Complex Plane class that displays Complex Plane
 * 
 * @author Team D
 * @version 12/9/22
 *
 */
public class ComplexPlane extends JFrame implements LanguageChangeable
{

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
  }

  /**
   * Set plane frame.
   */
  public void createUI()
  {
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(700, 700);
    setVisible(false);
    Settings.addLanguageChangeable(this);
  }

  /**
   * Getter for complex panel
   * 
   * @return complexPanel Change the set language.
   */
  @Override
  public void changeLanguage()
  {
    setTitle(Settings.getInstance().getLanguage().get("complexPlaneTitle"));
  }

  /**
   *
   * @return
   */
  public ComplexPanel getPanel()
  {
    return panel;
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
  // positive x-axis coord constants
  public static final int X_AXIS_FIRST_X_COORD = 350;
  public static final int X_AXIS_SECOND_X_COORD = 690;
  public static final int X_AXIS_Y_COORD = 350;

  // negative x-axis coord constants
  public static final int NEG_X_AXIS_FIRST_X_COORD = 10;
  public static final int NEG_X_AXIS_SECOND_X_COORD = 350;
  public static final int NEG_X_AXIS_Y_COORD = 350;

  // positive y-axis coord constants
  public static final int Y_AXIS_FIRST_Y_COORD = 10;
  public static final int Y_AXIS_SECOND_Y_COORD = 350;
  public static final int Y_AXIS_X_COORD = 350;

  // negative x-axis coord constants
  public static final int NEG_Y_AXIS_FIRST_Y_COORD = 350;
  public static final int NEG_Y_AXIS_SECOND_Y_COORD = 690;
  public static final int NEG_Y_AXIS_X_COORD = 350;

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
  int xCoordNumbers = 100;
  int yCoordNumbers = 100;

  double negXLength = (NEG_X_AXIS_SECOND_X_COORD - NEG_X_AXIS_FIRST_X_COORD) / xCoordNumbers;
  double negYLength = (NEG_Y_AXIS_SECOND_Y_COORD - NEG_Y_AXIS_FIRST_Y_COORD) / yCoordNumbers;
  int xLength = (X_AXIS_SECOND_X_COORD - X_AXIS_FIRST_X_COORD) / xCoordNumbers;
  int yLength = (Y_AXIS_SECOND_Y_COORD - Y_AXIS_FIRST_Y_COORD) / yCoordNumbers;

  private ArrayList<Point2D> points = new ArrayList<>();
  private ArrayList<ComplexNumber> numbers = new ArrayList<>();

  /**
   * Repaints graph with new complex point.
   *
   * @param point
   */
  public void drawPoint(Point2D point)
  {
    points.add(point);
    repaint();
  }

  /**
   * updates the GUI with the new point
   */
  public void update()
  {

    if (ComplexCalc.isClicked)
    {
      ComplexNumber res = ComplexCalc.getResult();
      numbers.add(res);
      double x = res.getReal();
      double y = res.getImaginary();
      Point2D nextPoint = new Point2D.Double(x, y);

      drawPoint(nextPoint);
    }
  }

  /**
   * Draws Point on panel
   *
   * @param point
   * @param g
   */
  private void drawPointOnPanel(Point2D point, Graphics g)
  {

    Graphics2D gg = (Graphics2D) g;

    gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    gg.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

    double x = 0;
    double y = 0;

    final int pointDiameter = 5;
    if (point.getX() > 0)
    {
      x = X_AXIS_FIRST_X_COORD + (point.getX() * xLength) - pointDiameter / 2;
    }
    else
    {
      // fill
      x = NEG_X_AXIS_SECOND_X_COORD + (point.getX() * negXLength) - pointDiameter / 2;
    }
    if (point.getY() > 0)
    {
      y = Y_AXIS_SECOND_Y_COORD - (point.getY() * yLength) - pointDiameter / 2;
    }
    else
    {
      // fill
      y = NEG_Y_AXIS_FIRST_Y_COORD - (point.getY() * negYLength) - pointDiameter / 2;
    }

    Ellipse2D.Double shape = new Ellipse2D.Double(x, y, pointDiameter, pointDiameter);
    gg.fill(shape);
    // g.fillOval((int) x, (int) y, pointDiameter, pointDiameter);

  }

  /**
   * Paints Complex Plane
   */
  public void paintComponent(Graphics g)
  {

    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    // save the current transformation matrix
    // AffineTransform oldTransform = g2.getTransform();

    // calculate the dimensions of the panel

    // translate the graphics to the center of the panel
    // if (isCalled)
    // {
    // g.translate(-panelWidth / 2 + 10, -panelHeight / 2 + 10);
    // System.out.println(-panelWidth / 2);
    // System.out.println(-panelHeight / 2);
    // g.translate(panelWidth / 2 + 10, panelHeight / 2 + 10);
    // }
    // // g2.scale(scaleFactor, scaleFactor);
    // g2.scale(scaleFactor, scaleFactor);

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // positive x-axis
    g2.drawLine(X_AXIS_FIRST_X_COORD, X_AXIS_Y_COORD, X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);

    // negative x-axis
    g2.drawLine(NEG_X_AXIS_FIRST_X_COORD, NEG_X_AXIS_Y_COORD, NEG_X_AXIS_SECOND_X_COORD,
        NEG_X_AXIS_Y_COORD);

    // positive y-axis
    g2.drawLine(Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD, Y_AXIS_X_COORD, Y_AXIS_SECOND_Y_COORD);

    // negative y-axis
    g2.drawLine(NEG_Y_AXIS_X_COORD, NEG_Y_AXIS_FIRST_Y_COORD, NEG_Y_AXIS_X_COORD,
        NEG_Y_AXIS_SECOND_Y_COORD);

    // x-axis arrow
    // g2.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGHT, X_AXIS_Y_COORD - SECOND_LENGHT,
    // X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
    // g2.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGHT, X_AXIS_Y_COORD + SECOND_LENGHT,
    // X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
    //
    // // y-axis arrow
    // g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT, Y_AXIS_FIRST_Y_COORD + FIRST_LENGHT,
    // Y_AXIS_X_COORD,
    // Y_AXIS_FIRST_Y_COORD);
    // g2.drawLine(Y_AXIS_X_COORD + SECOND_LENGHT, Y_AXIS_FIRST_Y_COORD + FIRST_LENGHT,
    // Y_AXIS_X_COORD,
    // Y_AXIS_FIRST_Y_COORD);

    // draw origin Point
    // g2.fillOval(
    // X_AXIS_FIRST_X_COORD - (ORIGIN_COORDINATE_LENGHT / 2),
    // Y_AXIS_SECOND_Y_COORD - (ORIGIN_COORDINATE_LENGHT / 2),
    // ORIGIN_COORDINATE_LENGHT, ORIGIN_COORDINATE_LENGHT);
    // g2.fillOval(347, 347, ORIGIN_COORDINATE_LENGHT, ORIGIN_COORDINATE_LENGHT);

    // draw text "X" and draw text "Y"
    g2.drawString("X", X_AXIS_SECOND_X_COORD - AXIS_STRING_DISTANCE / 2 - 5,
        X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
    g2.drawString("Y", Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
        Y_AXIS_FIRST_Y_COORD + AXIS_STRING_DISTANCE / 2);
    // draw center point (0,0)
    // g2.drawString("(0, 0)", X_AXIS_FIRST_X_COORD - AXIS_STRING_DISTANCE,
    // Y_AXIS_SECOND_Y_COORD + AXIS_STRING_DISTANCE);
    // g2.drawString("(0, 0)", 352, 365);

    // draw x-axis numbers
    int xNum = -100;
    int xIncrement = 25;
    for (int i = 1; i < 5; i++)
    {

      // if (xNum == 0)
      // {
      // xNum++;
      // continue;
      // }

      // positive x
      g2.drawLine(X_AXIS_FIRST_X_COORD + (xIncrement * xLength), X_AXIS_Y_COORD - SECOND_LENGHT,
          X_AXIS_FIRST_X_COORD + (xIncrement * xLength), X_AXIS_Y_COORD + SECOND_LENGHT);

      g.setFont(new Font("Serif", Font.PLAIN, 10));
      g2.drawString(Integer.toString(xIncrement), X_AXIS_FIRST_X_COORD + (xIncrement * xLength) - 3,
          X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);

      // negative X
      g2.drawLine(NEG_X_AXIS_FIRST_X_COORD + ((xIncrement - 11) * xLength),
          NEG_X_AXIS_Y_COORD - SECOND_LENGHT,
          NEG_X_AXIS_FIRST_X_COORD + ((xIncrement - 11) * xLength),
          NEG_X_AXIS_Y_COORD + SECOND_LENGHT);

      g2.drawString(Integer.toString(xNum),
          NEG_X_AXIS_FIRST_X_COORD + ((xIncrement - 11) * xLength) - 3,
          NEG_X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);

      xNum += 25;
      xIncrement += 25;
    }

    // draw y-axis numbers
    int yNum = -100;
    int yIncrement = 25;
    for (int i = 1; i < 5; i++)
    {

      // if (yNum == 0)
      // {
      // yNum++;
      // continue;
      // }

      // positive y axis
      String yAxis = Integer.toString(yIncrement) + "i";
      g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT, Y_AXIS_SECOND_Y_COORD - (yIncrement * yLength),
          Y_AXIS_X_COORD + SECOND_LENGHT, Y_AXIS_SECOND_Y_COORD - (yIncrement * yLength));

      g.setFont(new Font("Serif", Font.PLAIN, 10));
      g2.drawString(yAxis, Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
          Y_AXIS_SECOND_Y_COORD - (yIncrement * yLength));

      // negative y axis
      g2.drawLine(NEG_Y_AXIS_X_COORD - SECOND_LENGHT,
          NEG_Y_AXIS_SECOND_Y_COORD - ((yIncrement - 11) * yLength),
          NEG_Y_AXIS_X_COORD + SECOND_LENGHT,
          NEG_Y_AXIS_SECOND_Y_COORD - ((yIncrement - 11) * yLength));

      g2.drawString(yNum + "i", NEG_Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
          NEG_Y_AXIS_SECOND_Y_COORD - ((yIncrement - 11) * yLength));
      yNum += 25;
      yIncrement += 25;
    }
    // draw points
    points.forEach(p -> drawPointOnPanel(p, g));

  }

}
