package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar
{
 
  JMenuBar menuBar;
  JMenu file, edit, help;
  
  public MenuBar() {
    
    menuBar = new JMenuBar();
    
    file = new JMenu("File");
    edit = new JMenu("Edit");
    help = new JMenu("Help");
  }
}
