package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JFrame
{
 
  JMenuBar menuBar;
  JMenu file, edit, help;
  JMenuItem print, exit, lang, mode, about;
  
  public MenuBar() {
    
    menuBar = new JMenuBar();
    
    // file menu along menubar
    file = new JMenu("File");
    print = new JMenuItem("Print");
    exit = new JMenuItem("Exit");
    menuBar.add(file);
    
    // edit menu along menubar
    edit = new JMenu("Edit");
    lang = new JMenuItem("Language");
    mode = new JMenuItem("Mode");
    menuBar.add(edit);
    
    // help menu along menubar
    help = new JMenu("Help");
    about = new JMenuItem("About");
    menuBar.add(help);
    
    menuBar.setVisible(true);
  }
}
