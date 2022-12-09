package gui;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class ColorSchemeUtil
{
  static InputStream file = ColorSchemeUtil.class.getResourceAsStream("/gui/colorScheme.txt");

  public static Color menuBarColor() throws FileNotFoundException
  {
    file = ColorSchemeUtil.class.getResourceAsStream("/gui/colorScheme.txt");

    Scanner scan = new Scanner(file);
    System.out.println(scan.next());
    System.out.println(scan.next());

    int red = scan.nextInt();
    int green = scan.nextInt();
    int blue = scan.nextInt();
    return new Color(red, green, blue);
  }

  public static Color backgroundColor() throws FileNotFoundException
  {
    file = ColorSchemeUtil.class.getResourceAsStream("/gui/colorScheme.txt");

    Scanner scan = new Scanner(file);
    scan.nextLine();

    scan.next();
    scan.next();

    int red = scan.nextInt();
    int green = scan.nextInt();
    int blue = scan.nextInt();
    return new Color(red, green, blue);

  }

  public static Color numberButtonsColor() throws FileNotFoundException
  {
    file = ColorSchemeUtil.class.getResourceAsStream("/gui/colorScheme.txt");

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

  public static Color functionButtonsColor() throws FileNotFoundException
  {
    file = ColorSchemeUtil.class.getResourceAsStream("/gui/colorScheme.txt");

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
