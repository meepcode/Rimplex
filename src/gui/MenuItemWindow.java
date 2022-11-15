package gui;

import javax.swing.JFrame;

public class MenuItemWindow extends JFrame
{
  public MenuItemWindow(String title, int width, int height)
  {
    setTitle(title);
    setSize(width, height);
    setLocation(600, 300);
    setVisible(true);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
}
