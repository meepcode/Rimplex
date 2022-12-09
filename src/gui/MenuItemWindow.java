package gui;

import javax.swing.JFrame;

/**
 * Menu Item Window.
 *
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
public class MenuItemWindow extends JFrame
{
  private static final long serialVersionUID = 1L;
  
  /**
   * Constructor. 
   * @param title string.
   * @param width int.
   * @param height int.
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
