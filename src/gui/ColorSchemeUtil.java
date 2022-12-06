package gui;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ColorSchemeUtil
{
  static File file = new File("src/gui/colorScheme.txt");

  public static Color menuBarColor() throws FileNotFoundException
  {
    Scanner scan = new Scanner(file);
    scan.next();
    scan.next();
    return getColor(scan.next());
  }

  public static Color menuBarOptionsColor() throws FileNotFoundException
  {
    Scanner scan = new Scanner(file);
  for(int i = 0; i< 5; i++){
    scan.next();
  }
    return getColor(scan.next());
  }

  public static Color backgroundColor() throws FileNotFoundException
  {
    Scanner scan = new Scanner(file);
    scan.nextLine();
    scan.next();
    scan.next();
    String color = scan.next();
    return getColor(color);
  }

  public static Color numberButtonsColor() throws FileNotFoundException
  {
    Scanner scan = new Scanner(file);
    scan.nextLine();
    scan.nextLine();
    scan.next();
    scan.next();
    scan.next();
    String color = scan.next();
    return getColor(color);
  }

  public static Color functionButtonsColor() throws FileNotFoundException
  {
    Scanner scan = new Scanner(file);
    scan.nextLine();
    scan.nextLine();
    scan.nextLine();
    scan.next();
    scan.next();
    scan.next();
    String color = scan.next();
    return getColor(color);
  }

  public static void main(String[] args) throws FileNotFoundException
  {
    ColorSchemeUtil s = new ColorSchemeUtil();
  }

  private static Color getColor(String color)
  {
    if (color.equalsIgnoreCase("blue"))
    {
      return Color.blue;
    }
    if (color.equalsIgnoreCase("magenta"))
    {
      return Color.magenta;
    }
    if (color.equalsIgnoreCase("cyan"))
    {
      return Color.cyan;
    }
    if (color.equalsIgnoreCase("gray"))
    {
      return Color.gray;
    }
    if (color.equalsIgnoreCase("orange"))
    {
      return Color.orange;
    }
    if (color.equalsIgnoreCase("red"))
    {
      return Color.red;
    }
    if (color.equalsIgnoreCase("green"))
    {
      return Color.green;
    }
    return Color.gray;
  }
}
