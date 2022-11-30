package gui;

import javax.swing.JFrame;

/**
 * MenuItemWindow class.
 * 
 * @author TeamD
 * @version 11.18.22
 */
public class MenuItemWindow extends JFrame
{
  /**
   * MenuItemWindow.
   * 
   * @param title
   *          String
   * @param width
   *          int
   * @param height
   *          int
   */
  public MenuItemWindow(final String title, final int width, final int height)
  {
    setTitle(title);
    setSize(width, height);
    setLocation(600, 300);
    setVisible(true);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
}
