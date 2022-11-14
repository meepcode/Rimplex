package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuBar implements ActionListener
{
 
  
  public JMenuBar createMenuBar() {
    
    JMenuBar menuBar;
    JMenu file, edit, help;
    JMenuItem print, exit, lang, mode, about;
    
    menuBar = new JMenuBar();
    
    // file menu along menubar
    file = new JMenu("File");
    menuBar.add(file);
    
    print = new JMenuItem("Print");
    file.add(print);
    file.addActionListener(this);
    print.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        MenuItemWindow p = new MenuItemWindow();
        JPanel panel = new JPanel();
        JButton printButton = new JButton("Print");
        p.add(panel, BorderLayout.SOUTH);
        panel.setLayout((new FlowLayout(FlowLayout.TRAILING)));
        panel.add(printButton);
      }
    });
    
    exit = new JMenuItem("Exit");
    file.add(exit);
    exit.addActionListener(this);
    exit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       System.exit(0);
      }
    });
    
    // edit menu along menubar
    edit = new JMenu("Edit");
    menuBar.add(edit);
    
    lang = new JMenuItem("Language");
    edit.add(lang);
    lang.addActionListener(this);
    lang.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        MenuItemWindow l = new MenuItemWindow();
      }
    });
    mode = new JMenuItem("Mode");
    edit.add(mode);
    mode.addActionListener(this);
    mode.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        MenuItemWindow m = new MenuItemWindow();
      }
    });
    
    // help menu along menubar
    help = new JMenu("Help");
    menuBar.add(help);
    
    about = new JMenuItem("About");
    help.add(about);
    about.addActionListener(this);
    help.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        MenuItemWindow a = new MenuItemWindow();
        Font myFont = new Font("Serif", Font.BOLD, 15);
        JTextField text = new JTextField("This calculator performs operations on the given complex number operands."
            + " A history of results from previous calculations are stored in the history panel.");
        a.add(text);
        text.setFont(myFont);
        text.setEditable(false);
      }
    });
    
    return menuBar;
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    // TODO Auto-generated method stub
    
  }
}
