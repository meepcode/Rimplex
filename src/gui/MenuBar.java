package gui;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
=======
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD

public class MenuBar implements ActionListener
{

  public JMenuBar createMenuBar()
  {

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
    print.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        MenuItemWindow p = new MenuItemWindow("Print", 300, 300);
        // final print button 
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
    exit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    });

    // edit menu along menubar
    edit = new JMenu("Edit");
    menuBar.add(edit);

    mode = new JMenuItem("Mode");
    edit.add(mode);
    mode.addActionListener(this);
    mode.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        MenuItemWindow m = new MenuItemWindow("Mode", 250, 200);
      }
    });

    // help menu along menubar
    help = new JMenu("Help");
    menuBar.add(help);

    about = new JMenuItem("About");
    help.add(about);
    about.addActionListener(this);
    about.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JOptionPane.showMessageDialog(null, "This calculator performs operations on the given complex number operands. " 
            + "A history of results from previosu calculations are stored in the history panel.","About",
            JOptionPane.INFORMATION_MESSAGE);
      }
    });

    JMenu langs = new JMenu("Language");
    menuBar.add(langs);

    JMenuItem span = new JMenuItem("Spanish");
    langs.add(span);
    span.addActionListener(this);

    span.addActionListener(new ActionListener()
    {
      @Override public void actionPerformed(ActionEvent e)
      {
        langs.setText("Idioma");
        file.setText("Expediente");
        edit.setText("Editar");
        help.setText("Ayuda");
        about.setText("Sobre");
        mode.setText("Modo");
        print.setText("Impresión");
        exit.setText("Salida");
      }
    });

    JMenuItem german = new JMenuItem("German");
    langs.add(german);
    german.addActionListener(this);

    german.addActionListener(new ActionListener()
    {
      @Override public void actionPerformed(ActionEvent e)
      {
        langs.setText("Sprachen");
        file.setText("Datei");
        edit.setText("Bearbeiten");
        help.setText("Hilfe");
        about.setText("Um");
        mode.setText("Modus");
        print.setText("Drucken");
        exit.setText("Ausfahrt");
      }
    });

    JMenuItem french = new JMenuItem("French");
    langs.add(french);
    french.addActionListener(this);

    french.addActionListener(new ActionListener()
    {
      @Override public void actionPerformed(ActionEvent e)
      {
        langs.setText("Langue");
        file.setText("Dossier");
        edit.setText("Éditer");
        help.setText("Aider");
        about.setText("Sur");
        mode.setText("Mode");
        print.setText("Imprimer");
        exit.setText("Sortir");
      }
    });

    JMenuItem english = new JMenuItem("English");
    langs.add(english);
    english.addActionListener(this);

    english.addActionListener(new ActionListener()
    {
      @Override public void actionPerformed(ActionEvent e)
      {
        langs.setText("Language");
        file.setText("File");
        edit.setText("Edit");
        help.setText("Help");
        about.setText("About");
        mode.setText("Mode");
        print.setText("Print");
        exit.setText("Exit");
      }
    });

    return menuBar;

  }

  @Override public void actionPerformed(ActionEvent e)
  {
    // TODO Auto-generated method stub

  }
}
