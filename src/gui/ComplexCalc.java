package gui;

import calculation.Calculate;
import calculation.ComplexNumber;
import parse.Evaluation;
import parse.ExpressionEvaluationException;

// import javax.print.attribute.HashPrintRequestAttributeSet;
// import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.awt.print.*;
//import java.awt.print.PageFormat;
//import java.awt.print.Printable;
//import java.awt.print.PrinterException;
//import java.awt.print.PrinterJob;
//
//import static java.awt.print.Printable.NO_SUCH_PAGE;
//import static java.awt.print.Printable.PAGE_EXISTS;

/**
 * Calculator GUI.
 *
 * @author TeamD
 * @version 11/4/22 This work complies with the JMU Honor Code.
 */

public class ComplexCalc extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  private static final String SERIF = "Serif";
  private static final String MINUS = "-";
  private static final String PLUS = "+";
  private static final String ASTERISK = "*";
  private static final String SLASH = "/";
  private static final String DOT = ".";
  protected static String result = "";
  protected static boolean isClicked = false;
  private final JFrame frame;
  private final JTextField textfield;
  private final JButton[] numberButtons = new JButton[10];
  private final JButton[] functionButtons = new JButton[20];
  private final JButton addButton, subButton, mulButton, divButton;
  private final JButton decButton, equButton, resetButton, clrButton, expButton, invButton,
      leftParenth, rightParenth, leftArrow, imaginaryNum, logButton, sqrtButton, realPart,
      conjugate, imaginaryPart;
  private final JPanel panel;
  private final HistoryPanel his;
  private final Font myFont = new Font(SERIF, Font.BOLD, 30);
  private boolean isPolarActive = false;
  private String pastResult = "";

  ComplexCalc()
  {
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 480);
    frame.setLayout(new BorderLayout());
    frame.setResizable(false);

    frame.setLocationRelativeTo(null);

    // adding file menu
    MenuBar mb = new MenuBar();
    frame.setJMenuBar(mb.createMenuBar());

    // adding history panel
    his = new HistoryPanel();
    // temp initialization of result

    textfield = new JTextField();
    textfield.setBounds(50, 25, 300, 50);
    textfield.setFont(myFont);
    textfield.setEditable(true);

    resetButton = new JButton("R");
    subButton = new JButton(MINUS);
    addButton = new JButton(PLUS);
    mulButton = new JButton(ASTERISK);
    divButton = new JButton(SLASH);
    decButton = new JButton(DOT);
    equButton = new JButton("=");
    clrButton = new JButton("\u2190");
    expButton = new JButton("^");
    leftParenth = new JButton("(");
    rightParenth = new JButton(")");
    leftArrow = new JButton("<");
    invButton = new JButton("Inv");
    imaginaryNum = new JButton("i");
    logButton = new JButton("Log");
    sqrtButton = new JButton("\u221A");
    realPart = new JButton("real");
    conjugate = new JButton("conj");
    imaginaryPart = new JButton("imag");

    functionButtons[0] = addButton;
    functionButtons[1] = subButton;
    functionButtons[2] = mulButton;
    functionButtons[3] = divButton;
    functionButtons[4] = decButton;
    functionButtons[5] = equButton;
    functionButtons[6] = resetButton;
    functionButtons[7] = clrButton;
    functionButtons[8] = expButton;
    functionButtons[9] = invButton;
    functionButtons[10] = leftParenth;
    functionButtons[11] = rightParenth;
    functionButtons[12] = leftArrow;
    functionButtons[13] = imaginaryNum;
    functionButtons[14] = logButton;
    functionButtons[15] = sqrtButton;
    functionButtons[16] = realPart;
    functionButtons[17] = conjugate;
    functionButtons[18] = imaginaryPart;

    for (int i = 0; i < 19; i++)
    {
      functionButtons[i].addActionListener(this);
      functionButtons[i].setFont(myFont);
      functionButtons[i].setFocusable(false);
    }

    imaginaryNum.setFont(new Font(SERIF, Font.ITALIC, 30));
    logButton.setFont(new Font(SERIF, Font.BOLD, 10));
    invButton.setFont(new Font(SERIF, Font.BOLD, 10));
    expButton.setFont(new Font(SERIF, Font.BOLD, 10));
    resetButton.setFont(new Font(SERIF, Font.BOLD, 20));
    clrButton.setFont(new Font(SERIF, Font.BOLD, 20));
    sqrtButton.setFont(new Font(SERIF, Font.BOLD, 20));
    expButton.setFont(new Font(SERIF, Font.BOLD, 30));

    for (int i = 0; i < 10; i++)
    {
      numberButtons[i] = new JButton(String.valueOf(i));
      numberButtons[i].addActionListener(this);
      numberButtons[i].setFont(myFont);
      numberButtons[i].setFocusable(false);
    }

    for (int i = 16; i < 19; i++)
    {
      functionButtons[i].setFont(new Font(SERIF, Font.BOLD, 12));
    }

    clrButton.setFont(new Font(SERIF, Font.BOLD, 20));

    panel = new JPanel();
    panel.setBounds(50, 100, 300, 300);
    panel.setLayout(new GridLayout(5, 4, 10, 10));

    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(numberButtons[3]);
    panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(numberButtons[6]);
    panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(numberButtons[9]);
    panel.add(numberButtons[0]);

    panel.add(addButton);
    panel.add(subButton);
    panel.add(mulButton);
    panel.add(divButton);
    panel.add(leftParenth);
    panel.add(rightParenth);
    panel.add(decButton);
    panel.add(equButton);
    panel.add(expButton);
    panel.add(invButton);
    panel.add(resetButton);
    panel.add(logButton);
    panel.add(imaginaryNum);
    panel.add(sqrtButton);
    panel.add(realPart);
    panel.add(conjugate);
    panel.add(imaginaryPart);
    panel.add(clrButton);
    frame.add(textfield, BorderLayout.NORTH);
    frame.add(panel, BorderLayout.CENTER);
    frame.add(his.getPanel(), BorderLayout.EAST);

    frame.setVisible(true);
  }

  /**
   * Main method.
   *
   * @param args
   *     cmd line args
   */
  public static void main(final String[] args)
  {
    ComplexCalc calc = new ComplexCalc();
  }

  /**
   * setting boolean click
   */
  public static void setClick()
  {
    isClicked = !isClicked;
  }

  @Override public void actionPerformed(final ActionEvent e)
  {
    for (int i = 0; i < 10; i++)
    {
      if (e.getSource() == numberButtons[i])
      {
        textfield.setText(textfield.getText().concat(String.valueOf(i)));
      }
    }
    if (e.getSource() == decButton)
    {
      textfield.setText(textfield.getText().concat(DOT));
    }
    if (e.getSource() == addButton)
    {
      if (textfield.getText().contains("=")) 
      {
        textfield.setText("");
      }
      if (!pastResult.equals("") && textfield.getText().equals(""))
      {
        textfield.setText(pastResult);
      }
      textfield.setText(textfield.getText() + PLUS);
    }
    if (e.getSource() == subButton)
    {
      if (textfield.getText().contains("=")) 
      {
        textfield.setText("");
      }
      if (!pastResult.equals("") && textfield.getText().equals(""))
      {
        textfield.setText(pastResult);
      }
      textfield.setText(textfield.getText() + MINUS);
    }
    if (e.getSource() == mulButton)
    {
      if (textfield.getText().contains("=")) 
      {
        textfield.setText("");
      }
      if (!pastResult.equals("") && textfield.getText().equals(""))
      {
        textfield.setText(pastResult);
      }
      textfield.setText(textfield.getText() + ASTERISK);
    }
    if (e.getSource() == divButton)
    {
      if (textfield.getText().contains("=")) 
      {
        textfield.setText("");
      }
      if (!pastResult.equals("") && textfield.getText().equals(""))
      {
        textfield.setText(pastResult);
      }
      textfield.setText(textfield.getText() + SLASH);
    }
    if (e.getSource() == resetButton)
    {
      textfield.setText("");
    }
    if (e.getSource() == clrButton)
    {
      String string = textfield.getText();
      textfield.setText("");
      for (int i = 0; i < string.length() - 1; i++)
      {
        textfield.setText(textfield.getText() + string.charAt(i));
      }
    }
    if (e.getSource() == expButton)
    {
      if (textfield.getText().contains("=")) 
      {
        textfield.setText("");
      }
      if (!pastResult.equals("") && textfield.getText().equals(""))
      {
        textfield.setText(textfield.getText() + "(exp)^");
        textfield.setText(textfield.getText() + pastResult);
      } else {
        textfield.setText(textfield.getText() + "(exp)^(");
      }
    }
    if (e.getSource() == imaginaryNum)
    {
      textfield.setText(textfield.getText() + "i");
    }
    if (e.getSource() == leftParenth)
    {
      textfield.setText(textfield.getText() + "(");
    }
    if (e.getSource() == rightParenth)
    {
      textfield.setText(textfield.getText() + ")");
    }
    if (e.getSource() == logButton)
    {
      if (textfield.getText().contains("=")) 
      {
        textfield.setText("(10)log" + pastResult);
      } else {
        textfield.setText(textfield.getText() + "(10)log(");
      }
    }
    if (e.getSource() == sqrtButton)
    {
      if (textfield.getText().contains("=")) 
      {
        textfield.setText("sqrt" + pastResult);
      } else {
        textfield.setText(textfield.getText() + "sqrt(");
      }
    }
    if (e.getSource() == invButton)
    {
      if (textfield.getText().contains("=")) 
      {
        textfield.setText("Inv" + pastResult);
      } else {
        textfield.setText(textfield.getText() + "Inv(");
      }
    }
    if (e.getSource() == realPart)
    {
      if (textfield.getText().contains("=")) 
      {
        textfield.setText("re" + pastResult);
      } else {
        textfield.setText(textfield.getText() + "re(");
      }
    }
    if (e.getSource() == imaginaryPart)
    {
      if (textfield.getText().contains("=")) 
      {
        textfield.setText("im" + pastResult);
      } else {
        textfield.setText(textfield.getText() + "im(");
      }
    }
    if (e.getSource() == conjugate)
    {
      if (textfield.getText().contains("=")) 
      {
        textfield.setText("conj" + pastResult);
      } else {
        textfield.setText(textfield.getText() + "conj(");
      }
    }
    if (e.getSource() == equButton)
    {
      try
      {
        ComplexNumber res = Evaluation.evaluateExpression(textfield.getText());
        if (isPolarActive)
        {
          res = Calculate.convertRectangularToPolar(res);
        }
        textfield.setText(textfield.getText() + "=" + res);
        result = textfield.getText();
        pastResult = "(" + res.toString() + ")";
        isClicked = true;
        his.add();
      }
      catch (ExpressionEvaluationException ex)
      {
        JOptionPane.showMessageDialog(null, "ERROR: Invalid Expression Format.", "ERROR",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }


  /*public int print(Graphics g, PageFormat pf, int page) throws PrinterException
  {
    if (page > 0)
    {
      return NO_SUCH_PAGE;
    }

    Graphics2D g2d = (Graphics2D) g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());

    // Print the entire visible contents of a
    // java.awt.Frame.
    frame.printAll(g);

    return PAGE_EXISTS;
  }*/

  // Menu Bar Code
  class MenuBar implements ActionListener
  {
    String aboutMessage =
        "This calculator performs operations on the given complex number operands. "
            + "A history of results from previosu calculations are stored in the history "
            + "panel.";
    String aboutTitle = "About";
    String printTitle = "Print";
    JMenuBar menuBar;
    JMenu file, mode, help;
    JMenuItem print, exit, about;
    //MenuItemWindow modeWindow = new MenuItemWindow("Mode", 250, 200);

    public JMenuBar createMenuBar()
    {
      // modeWindow.setVisible(false);

      menuBar = new JMenuBar();

      // file menu along menubar
      file = new JMenu("File");
      menuBar.add(file);
      
      

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
      mode = new JMenu("Mode");
      menuBar.add(mode);

      JMenuItem rect = new JMenuItem("Rectangular");
      mode.add(rect);
      rect.addActionListener(this);
      rect.addActionListener(new ActionListener()
      {
        @Override public void actionPerformed(ActionEvent e)
        {

          isPolarActive = false;
        }
      });
      JMenuItem polar = new JMenuItem("Polar");
      mode.add(polar);
      polar.addActionListener(this);
      polar.addActionListener(new ActionListener()
      {
        @Override public void actionPerformed(ActionEvent e)
        {

          isPolarActive = true;

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
          JOptionPane.showMessageDialog(null,
              aboutMessage, "About",
              JOptionPane.INFORMATION_MESSAGE);
        }
      });

      JMenu langs = new JMenu("Language");
      menuBar.add(langs);

      JButton hist = new JButton("History");
      menuBar.add(hist);
      hist.addActionListener(new ActionListener()
      {
        @Override public void actionPerformed(ActionEvent e)
        {
          his.createAndShowGUI();
          frame.pack();
        }
      });

      JMenuItem span = new JMenuItem("Spanish");
      langs.add(span);
      span.addActionListener(this);

      span.addActionListener(new ActionListener()
      {
        @Override public void actionPerformed(ActionEvent e)
        {
          printTitle = "Impresión";
          aboutMessage = "Esta calculadora realiza operaciones en los operandos de números "
              + "complejos dados. Un historial de resultados de cálculos anteriores se almacena "
              + "en el panel de historial.";
          aboutTitle = "Sobre";
          hist.setText("Historia");
          // modeWindow.setTitle("Modo");
          frame.setTitle("Calculadora");
          langs.setText("Idioma");
          file.setText("Expediente");
          help.setText("Ayuda");
          about.setText("Sobre");
          mode.setText("Modo");
          print.setText("Impresión");
          exit.setText("Salida");
          rect.setText("Rectangular");
          polar.setText("Polar");
        }
      });

      JMenuItem german = new JMenuItem("German");
      langs.add(german);
      german.addActionListener(this);

      german.addActionListener(new ActionListener()
      {
        @Override public void actionPerformed(ActionEvent e)
        {
          printTitle = "Drucken";
          aboutMessage = "Dieser Rechner führt Operationen an den gegebenen Operanden für "
              + "komplexe Zahlen aus. Ein Verlauf der Ergebnisse früherer Berechnungen wird im "
              + "Verlaufsfeld gespeichert.";
          aboutTitle = "Um";
          hist.setText("Geschichte");
          // modeWindow.setTitle("Modus");
          frame.setTitle("Taschenrechner");
          langs.setText("Sprachen");
          file.setText("Datei");
          help.setText("Hilfe");
          about.setText("Um");
          mode.setText("Modus");
          print.setText("Drucken");
          exit.setText("Ausfahrt");
          rect.setText("Rechteckig");
          polar.setText("Polar");
        }
      });

      JMenuItem french = new JMenuItem("French");
      langs.add(french);
      french.addActionListener(this);

      french.addActionListener(new ActionListener()
      {
        @Override public void actionPerformed(ActionEvent e)
        {
          printTitle = "Imprimer";
          aboutMessage = "Cette calculatrice effectue des opérations sur les opérandes de nombres"
              + " complexes donnés. Un historique des résultats des calculs précédents est stocké"
              + " dans le panneau d'historique.";
          aboutTitle = "Sur";
          hist.setText("Histoire");
          // modeWindow.setTitle("Mode");
          frame.setTitle("Calculatrice");
          langs.setText("Langue");
          file.setText("Dossier");
          help.setText("Aider");
          about.setText("Sur");
          mode.setText("Mode");
          print.setText("Imprimer");
          exit.setText("Sortir");
          rect.setText("Rectangulaire");
          polar.setText("Polaire");
        }
      });

      JMenuItem english = new JMenuItem("English");
      langs.add(english);
      english.addActionListener(this);

      english.addActionListener(new ActionListener()
      {
        @Override public void actionPerformed(ActionEvent e)
        {
          printTitle = "Print";
          aboutMessage =
              "This calculator performs operations on the given complex number operands. "
                  + "A history of results from previosu calculations are stored in the history "
                  + "panel.";
          aboutTitle = "About";
          hist.setText("History");
          // modeWindow.setTitle("Mode");
          frame.setTitle("Calculator");
          langs.setText("Language");
          file.setText("File");
          help.setText("Help");
          about.setText("About");
          mode.setText("Mode");
          print.setText("Print");
          exit.setText("Exit");
          rect.setText("Polar");
          polar.setText("Rectangular");
        }
      });
      return menuBar;
    }

    @Override public void actionPerformed(ActionEvent e)
    {
      // TODO Auto-generated method stub

    }
  }



}
