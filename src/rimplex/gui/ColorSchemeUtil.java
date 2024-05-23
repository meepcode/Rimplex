package rimplex.gui;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * ColorSchemeUtil.
 *
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
public class ColorSchemeUtil
{
  public static String TEXT = "/rimplex/rimplex.gui/colorScheme.txt";
  
  static InputStream file = ColorSchemeUtil.class.getResourceAsStream(TEXT);

  /**
   * Get the menu bar color.
   * @return color of menu bar. 
   * @throws FileNotFoundException
   */
  public static Color menuBarColor() throws FileNotFoundException
  {
    file = ColorSchemeUtil.class.getResourceAsStream(TEXT);

    Scanner scan = new Scanner(file);
    System.out.println(scan.next());
    System.out.println(scan.next());

    int red = scan.nextInt();
    int green = scan.nextInt();
    int blue = scan.nextInt();
    return new Color(red, green, blue);
  }

  /**
   * Get the background color.
   * @return background color.
   * @throws FileNotFoundException
   */
  public static Color backgroundColor() throws FileNotFoundException
  {
    file = ColorSchemeUtil.class.getResourceAsStream(TEXT);

    Scanner scan = new Scanner(file);
    scan.nextLine();

    scan.next();
    scan.next();

    int red = scan.nextInt();
    int green = scan.nextInt();
    int blue = scan.nextInt();
    return new Color(red, green, blue);

  }

  /**
   * Gets color of number buttons.
   * @return color of number buttons.
   * @throws FileNotFoundException
   */
  public static Color numberButtonsColor() throws FileNotFoundException
  {
    file = ColorSchemeUtil.class.getResourceAsStream(TEXT);

    Scanner scan = new Scanner(file);
    scan.nextLine();
    scan.nextLine();
    scan.next();
    scan.next();
    scan.next();
    int red = scan.nextInt();
    int green = scan.nextInt();
    int blue = scan.nextInt();
    return new Color(red, green, blue);
  }
  /**
   * Gets color of function buttons.
   * @return color of function buttons.
   * @throws FileNotFoundException
   */
  public static Color functionButtonsColor() throws FileNotFoundException
  {
    file = ColorSchemeUtil.class.getResourceAsStream(TEXT);

    Scanner scan = new Scanner(file);
    scan.nextLine();
    scan.nextLine();
    scan.nextLine();
    scan.next();
    scan.next();
    scan.next();
    int red = scan.nextInt();
    int green = scan.nextInt();
    int blue = scan.nextInt();
    return new Color(red, green, blue);
  }

}
