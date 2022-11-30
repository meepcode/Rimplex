package gui;

import javax.swing.JFrame;

/**
<<<<<<< HEAD
 * MenuItemWindow class.
 * 
 * @author TeamD
 * @version 11.18.22
=======
 * Menu Item Window.
 *
 * @author TeamD
 * @version 11/18/22 This work complies with the JMU Honor Code.
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
 */
public class MenuItemWindow extends JFrame
{
  /**
<<<<<<< HEAD
   * MenuItemWindow.
   * 
   * @param title
   *          String
   * @param width
   *          int
   * @param height
   *          int
=======
   * 
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * Constructor. 
   * @param title string.
   * @param width int.
   * @param height int.
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
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
