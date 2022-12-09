package gui;

import calculation.Calculate;

import calculation.ComplexNumber;
import parse.Evaluation;
import parse.ExpressionEvaluationException;
import settings.LanguageChangeable;
import settings.Settings;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serial;
import java.security.Key;
import java.awt.print.PrinterJob;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;

/**
 * Calculator GUI.
 *
 * @author TeamD
 * @version 11/4/22 This work complies with the JMU Honor Code.
 */

public class ComplexCalc extends JFrame implements ActionListener, LanguageChangeable
{
  @Serial
  private static final long serialVersionUID = 1L;
  private static final String SERIF = "Serif";
  private static final String MINUS = "-";
  private static final String PLUS = "+";
  private static final String ASTERISK = "*";
  private static final String SLASH = "/";
  private static final String DOT = ".";
  protected static String result = "";
  protected static boolean isClicked = false;
  private static int windowCount = 0; // close windows of all other windows when last window is
                                      // closed
  private final JTextField textfield;
  private final JButton[] numberButtons = new JButton[10];
  private final JButton[] functionButtons = new JButton[19];
  private final JButton addButton, subButton, mulButton, divButton;
  private final JButton decButton, equButton, resetButton, clrButton, expButton, invButton,
      leftParenth, rightParenth, leftArrow, imaginaryNum, logButton, sqrtButton, realPart,
      conjugate, imaginaryPart;
  private final JPanel panel;
  private final HistoryPanel his;
  private final Font myFont = new Font(SERIF, Font.PLAIN, 30);
  private final String calculatorStr = "Calculator";
  private final ComplexPlane complexPlane = new ComplexPlane();
  private final Color colorScheme = Color.CYAN;
  private Settings settings;
  private boolean isPolarActive = false;
  private String pastResult = "";
  private boolean thousandsSeparator = false;
  private boolean trailingZeroes = false;
  private boolean doubleParenthesis = false;
  private int numDecimals = 2; // Default is 2, ask him if this is ok
  private String printTitle, aboutTitle, aboutMessage;
  private JMenuBar menuBar;
  private JMenu fileMenu, help, helpPage;
  private JMenuItem pref, print, exit, about, newWindow, englishHelpPage, spanishHelpPage,
      frenchHelpPage, germanHelpPage;
  private JButton hist, plot;
  private MenuItemWindow prefWindow;
  private JCheckBox polar, thousands, zeroes, doubleParen;
  private JTextField decimalPlaces;
  private String helpPageStr;

  private ComplexCalc(final Settings settings) throws FileNotFoundException
  {
    super();

    this.settings = settings;

    windowCount++;
    setupFrame();
    setupMenuBar();
    his = new HistoryPanel();
    textfield = new CalcTextField(settings, myFont);

    resetButton = new JButton("R");
    subButton = new JButton("-");
    addButton = new JButton("+");
    mulButton = new JButton("*");
    divButton = new JButton("/");
    decButton = new JButton(".");
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
    this.add(textfield, BorderLayout.NORTH);
    this.add(panel, BorderLayout.CENTER);
    this.add(his.getPanel(), BorderLayout.EAST);

    panel.setBackground(ColorSchemeUtil.backgroundColor());

    for (int i = 0; i < functionButtons.length; i++)
    {
      functionButtons[i].setBackground(ColorSchemeUtil.functionButtonsColor());
    }

    for (int i = 0; i < numberButtons.length; i++)
    {
      numberButtons[i].setBackground(ColorSchemeUtil.numberButtonsColor());
    }

    changeLanguage();

    this.setVisible(true);
    Settings.addLanguageChangeable(this);
  }

  /**
   * Main method.
   *
   * @param args
   *          cmd line args
   */
  public static void main(final String[] args) throws FileNotFoundException
  {
    Settings settings = Settings.getInstance();
    ComplexCalc calc = new ComplexCalc(settings);
  }

  /**
   * Sets boolean click.
   */
  public static void setClick()
  {
    isClicked = !isClicked;
  }

  private void setupHistoryPanel()
  {

  }

  private void setupFrame()
  {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(420, 480);
    setLayout(new BorderLayout());
    setResizable(true);
    setLocationRelativeTo(null);
  }

  private void setupMenuBar() throws FileNotFoundException
  {
    MenuBar mb = new MenuBar();
    this.setJMenuBar(mb.createMenuBar());
  }

  @Override
  public void actionPerformed(final ActionEvent e)
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
      }
      else
      {
        textfield.setText(textfield.getText() + "^");
      }
    }
    if (e.getSource() == imaginaryNum)
    {
      textfield.setText(textfield.getText() + "𝘪");
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
      }
      else
      {
        textfield.setText(textfield.getText() + "(10)log(");
      }
    }
    if (e.getSource() == sqrtButton)
    {
      if (textfield.getText().contains("="))
      {
        textfield.setText("sqrt" + pastResult);
      }
      else
      {
        textfield.setText(textfield.getText() + "sqrt(");
      }
    }
    if (e.getSource() == invButton)
    {
      if (textfield.getText().contains("="))
      {
        textfield.setText("Inv" + pastResult);
      }
      else
      {
        textfield.setText(textfield.getText() + "Inv(");
      }
    }
    if (e.getSource() == realPart)
    {
      if (textfield.getText().contains("="))
      {
        textfield.setText("re" + pastResult);
      }
      else
      {
        textfield.setText(textfield.getText() + "re(");
      }
    }
    if (e.getSource() == imaginaryPart)
    {
      if (textfield.getText().contains("="))
      {
        textfield.setText("im" + pastResult);
      }
      else
      {
        textfield.setText(textfield.getText() + "im(");
      }
    }
    if (e.getSource() == conjugate)
    {
      if (textfield.getText().contains("="))
      {
        textfield.setText("conj" + pastResult);
      }
      else
      {
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
        if (doubleParenthesis)
        {
          if (e.getSource() == leftParenth)
          {
            textfield.setText(textfield.getText() + "()");
          }
        }

        /* String formatting */
        // numDecimals = Integer.parseInt();

        /*
         * if (thousandsSeparator && trailingZeroes) { res.setTrailingZeroes(true);
         * res.setFormat("%,." + numDecimals + "f"); } else if (thousandsSeparator) {
         * res.setTrailingZeroes(false); res.setFormat("%,." + numDecimals + "f"); } else if
         * (trailingZeroes) { res.setTrailingZeroes(true); res.setFormat("%." + numDecimals + "f");
         * } else { res.setTrailingZeroes(false); res.setFormat("%." + numDecimals + "f"); }
         */

        if (thousandsSeparator)
        {
          res.setFormat("%,." + numDecimals + "f");
        }
        else
        {
          res.setFormat("%." + numDecimals + "f");
        }

        res.setTrailingZeroes(trailingZeroes);

        textfield.setText(textfield.getText() + "=" + res);
        result = textfield.getText();
        pastResult = "(" + res + ")";
        isClicked = true;
        his.add();
        // numZeroesToRemove = 0;
      }
      catch (ExpressionEvaluationException ex)
      {
        JOptionPane.showMessageDialog(null, "ERROR: Invalid Expression Format.", "ERROR",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  @Override
  public void changeLanguage()
  {
    printTitle = settings.getLanguage().get("printTitle");
    aboutMessage = settings.getLanguage().get("aboutMessage");
    aboutTitle = settings.getLanguage().get("aboutTitle");
    hist.setText(settings.getLanguage().get("histTitle"));
    setTitle(settings.getLanguage().get("title"));
    fileMenu.setText(settings.getLanguage().get("file"));
    help.setText("Help");
    about.setText("About");
    print.setText("Print");
    exit.setText("Exit");
    pref.setText("Preferences");
    if (prefWindow != null)
    {
      prefWindow.setTitle("Preferences");
      polar.setText("Polar");
      thousands.setText("Thounsands Separator");
      zeroes.setText("Trailing Zeroes");
      decimalPlaces.setText("Decimal Places");
      doubleParen.setText("Double Parenthesis");
    }
    plot.setText("Graph");
    helpPage.setText("Help Page");
    newWindow.setText("New Window");
  }

  // Menu Bar Code
  class MenuBar implements ActionListener
  {
    String aboutMessage = "This calculator performs operations on the given complex number operands. "
        + "A history of results from previosu calculations are stored in the history " + "panel.";
    String aboutTitle = "About";
    String printTitle = "Print";

    public JMenuBar createMenuBar() throws FileNotFoundException
    {

      menuBar = new JMenuBar();

      ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
      JLabel label = new JLabel(icon);
      menuBar.add(label);

      plot = new JButton("Graph");
      plot.addActionListener(e -> {
        // fill
        complexPlane.setVisible(true);
      });

      hist = new JButton("History");
      hist.addActionListener(e -> {
        his.createAndShowGUI();
        pack();
      });

      // help jmenuitem under Help menu
      help = new JMenu("Help");

      about = new JMenuItem("About");
      help.add(about);
      about.addActionListener(this);
      about.addActionListener(e -> JOptionPane.showMessageDialog(null, aboutMessage));

      helpPage = new JMenu(helpPageStr);

      englishHelpPage = new JMenuItem("Help in English");
      helpPage.add(englishHelpPage);

      englishHelpPage.addActionListener(this);
      englishHelpPage.addActionListener(e -> {
        if (e.getSource() == englishHelpPage)
        {
          try
          {
            File file = new File("src/helpfile/helpPage.html").getAbsoluteFile();
            Desktop.getDesktop().open(file);
          }
          catch (IOException e1)
          {
            e1.printStackTrace();
          }
        }
      });

      spanishHelpPage = new JMenuItem("Ayuda en Español");
      helpPage.add(spanishHelpPage);

      spanishHelpPage.addActionListener(this);
      spanishHelpPage.addActionListener(e -> {
        if (e.getSource() == spanishHelpPage)
        {
          try
          {
            File file = new File("src/helpfile/helpPageSpanish.html").getAbsoluteFile();
            Desktop.getDesktop().open(file);
          }
          catch (IOException e1)
          {
            e1.printStackTrace();
          }
        }
      });

      frenchHelpPage = new JMenuItem("Aide en Français");
      helpPage.add(frenchHelpPage);

      frenchHelpPage.addActionListener(this);
      frenchHelpPage.addActionListener(e -> {
        if (e.getSource() == frenchHelpPage)
        {
          try
          {
            File file = new File("src/helpfile/helpPageFrench.html").getAbsoluteFile();
            Desktop.getDesktop().open(file);
          }
          catch (IOException e1)
          {
            e1.printStackTrace();
          }
        }
      });

      germanHelpPage = new JMenuItem("Aide en Allemand");
      helpPage.add(germanHelpPage);

      germanHelpPage.addActionListener(this);
      germanHelpPage.addActionListener(e -> {
        if (e.getSource() == germanHelpPage)
        {
          try
          {
            File file = new File("src/helpfile/helpPageGerman.html").getAbsoluteFile();
            Desktop.getDesktop().open(file);
          }
          catch (IOException e1)
          {
            e1.printStackTrace();
          }
        }
      });

      // file menu along menubar
      fileMenu = new JMenu("File");
      menuBar.add(fileMenu);

      // new window sub menu
      newWindow = new JMenuItem("New Window");
      fileMenu.add(newWindow);
      newWindow.addActionListener(this);
      newWindow.addActionListener(new ActionListener()
      {
        @Override
        public void actionPerformed(ActionEvent e)
        {
          try
          {
            new ComplexCalc(settings);
          }
          catch (FileNotFoundException ex)
          {
            throw new RuntimeException(ex);
          }
        }
      });

      // preference sub menu
      pref = new JMenuItem("Preferences");
      fileMenu.add(pref);
      pref.addActionListener(this);
      pref.addActionListener(e -> {
        prefWindow = new MenuItemWindow("Preferences", 900, 300);

        JPanel all = new JPanel();
        all.setLayout(new GridLayout(4, 1));
        prefWindow.add(all);
        JPanel modes = new JPanel();
        modes.setLayout(new GridLayout(1, 3));
        all.add(modes);

        JCheckBox polar = new JCheckBox("Polar");
        modes.add(polar);
        polar.addActionListener(this);
        polar.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(ActionEvent e)
          {
            isPolarActive = !isPolarActive;
          }
        });

        JCheckBox thousands = new JCheckBox("Thousands Separator");
        modes.add(thousands);
        thousands.addActionListener(this);
        thousands.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(ActionEvent e)
          {
            thousandsSeparator = !thousandsSeparator;
          }
        });

        JCheckBox zeroes = new JCheckBox("Trailing zeroes");
        modes.add(zeroes);
        zeroes.addActionListener(this);
        zeroes.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(ActionEvent e)
          {
            trailingZeroes = !trailingZeroes;
          }
        });

        JPanel decimalPanel = new JPanel();
        decimalPanel.setLayout(new FlowLayout());
        DefaultStyledDocument doc = new DefaultStyledDocument();
        JTextPane decimalPlaces = new JTextPane(doc);
        decimalPlaces.setText("Decimal Places");
        decimalPlaces.setEditable(false);
        JTextArea decimals = new JTextArea("2");
        decimals.setEditable(false);
        JButton up = new JButton("↑");
        up.addActionListener(this);
        up.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(ActionEvent e)
          {
            numDecimals++;
            decimals.setText(String.valueOf(numDecimals));
          }
        });
        JButton down = new JButton("↓");
        down.addActionListener(this);
        down.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(ActionEvent e)
          {
            if (numDecimals != 0)
            {
              numDecimals--;
              decimals.setText(String.valueOf(numDecimals));
            }
          }
        });

        decimalPanel.add(decimalPlaces);
        decimalPanel.add(up);
        decimalPanel.add(decimals);
        decimalPanel.add(down);

        all.add(decimalPanel);

        // shortcut user options

        JPanel shortcuts = new JPanel();
        shortcuts.setLayout(new GridLayout(1, 5));
        all.add(shortcuts);
        JCheckBox doubleParen = new JCheckBox("Double Parenthesis");
        shortcuts.add(doubleParen);
        doubleParen.addActionListener(this);
        doubleParen.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(final ActionEvent e)
          {
            doubleParenthesis = !doubleParenthesis;
          }
        });

        // opening history using keyboard shortcut dropdown menu

        DefaultStyledDocument dsd = new DefaultStyledDocument();
        JTextPane historysc = new JTextPane(dsd);
        historysc.setText("History Shortcut");
        historysc.setEditable(false);
        shortcuts.add(historysc);

        String[] hisShortcuts = new String[5];
        hisShortcuts[0] = "a";
        hisShortcuts[1] = "b";
        hisShortcuts[2] = "c";
        hisShortcuts[3] = "d";
        hisShortcuts[4] = "e";
        JComboBox<String> historyDropDown = new JComboBox<String>(hisShortcuts);
        historyDropDown.setVisible(true);
        shortcuts.add(historyDropDown);

        // opening graph using keyboard shortcut dropdown menu

        DefaultStyledDocument dsd2 = new DefaultStyledDocument();
        JTextPane graphsc = new JTextPane(dsd2);
        graphsc.setText("Graph Shortcut");
        graphsc.setEditable(false);
        shortcuts.add(graphsc);

        String[] grShortcuts = new String[5];
        grShortcuts[0] = "j";
        grShortcuts[1] = "k";
        grShortcuts[2] = "l";
        grShortcuts[3] = "m";
        grShortcuts[4] = "n";
        JComboBox<String> graphDropDown = new JComboBox<String>(grShortcuts);
        graphDropDown.setVisible(true);
        shortcuts.add(graphDropDown);

        // languages options

        JPanel langs = new JPanel();
        langs.setLayout(new FlowLayout());
        prefWindow.add(langs, BorderLayout.SOUTH);

        JButton english = new JButton("English");
        JButton spanish = new JButton("Español");
        JButton german = new JButton("Deutsch");
        JButton french = new JButton("Français");

        langs.add(english);
        english.addActionListener(this);

        english.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(final ActionEvent e)
          {
            setSize(420, 480);
            english.setBackground(Color.GRAY);
            french.setBackground(null);
            german.setBackground(null);
            spanish.setBackground(null);
          }
        });

        langs.add(spanish);
        spanish.addActionListener(this);

        spanish.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(final ActionEvent e)
          {
            setSize(460, 480);

            spanish.setBackground(Color.GRAY);
            english.setBackground(null);
            german.setBackground(null);
            french.setBackground(null);

          }
        });

        langs.add(german);
        german.addActionListener(this);

        german.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(final ActionEvent e)
          {
            setSize(440, 480);

            german.setBackground(Color.GRAY);
            english.setBackground(null);
            french.setBackground(null);
            spanish.setBackground(null);
            
          }
        });

        langs.add(french);
        french.addActionListener(this);

        french.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(final ActionEvent e)
          {
            setSize(430, 480);
            french.setBackground(Color.GRAY);
            english.setBackground(null);
            german.setBackground(null);
            spanish.setBackground(null);
            
          }
        });
      });

      // print file menu
      print = new JMenuItem("Print");
      fileMenu.add(print);

      print.addActionListener(this);
      print.addActionListener(e -> {
        MenuItemWindow historyPrint = new MenuItemWindow("Print", 600, 300);

        JButton printButton = new JButton("Print");
        historyPrint.add(printButton, BorderLayout.SOUTH);
        // action listener for print button
        printButton.addActionListener(this);
        printButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(final ActionEvent e)
          {

            PrinterJob pjob = PrinterJob.getPrinterJob();
            PageFormat pf = pjob.defaultPage();
            pjob.setPrintable(null, pf);

            if (pjob.printDialog())
            { 
              try
              {
                pjob.print();
              }
              catch (PrinterException e1)
              {
                // TODO Auto-generated catch block
                e1.printStackTrace();
              }
            }
          }
        });

        DefaultStyledDocument doc = new DefaultStyledDocument();
        JTextPane copiedHistory = new JTextPane(doc);
        copiedHistory.setEditable(false);
        copiedHistory.setText(his.getHistoryList());
        historyPrint.add(copiedHistory);
      });

      // exit sub menu
      exit = new JMenuItem("Exit");
      fileMenu.add(exit);
      exit.addActionListener(this);
      exit.addActionListener(new ActionListener()
      {
        public void actionPerformed(final ActionEvent e)
        {
          System.exit(0);
        }
      });

      addWindowListener(new WindowAdapter()
      {
        public void windowClosing(WindowEvent e)
        {
          windowCount--;
          if (windowCount == 0)
          {
            System.exit(0);
          }
        }
      });

      menuBar.add(help);

      help.add(helpPage);

      menuBar.add(plot);

      menuBar.add(hist);

      menuBar.setBackground(ColorSchemeUtil.menuBarColor());

      return menuBar;
    }

    @Override
    public void actionPerformed(final ActionEvent e)
    {
      // TODO Auto-generated method stub

    }

  }

}
