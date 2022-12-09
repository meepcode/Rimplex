
package gui;

import calculation.Calculate;
import calculation.ComplexNumber;
import parse.Evaluation;
import parse.ExpressionEvaluationException;
import settings.LanguageChangeable;
import settings.Settings;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
<<<<<<< HEAD
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
=======
import java.awt.event.*;
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serial;
import java.security.Key;
import java.util.Objects;

/**
 * Calculator GUI.
 *
 * @author TeamD
 * @version 11/4/22 This work complies with the JMU Honor Code.
 */

public class ComplexCalc extends JFrame
    implements ActionListener, ComponentListener, LanguageChangeable
{
  protected static String result = "";
  protected static boolean isClicked = false;
  @Serial
  private static final long serialVersionUID = 1L;
  private static final String SERIF = "Serif";
  private static final String MINUS = "-";
  private static final String PLUS = "+";
  private static final String ASTERISK = "*";
  private static final String SLASH = "/";
  private static final String DOT = ".";
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
  private final Settings settings;
  public boolean thousandsSeparator = false;
  public boolean isPolarActive = false;
  public boolean trailingZeroes = false;
  public boolean doubleParenthesis = false;
  public int numDecimals = 2;
  private String pastResult = "";
  private static ComplexNumber complexResult = null;
  private String printTitle, aboutTitle, aboutMessage;
  private JMenuBar menuBar;
  private JMenu fileMenu, help, helpPage;
  private JMenuItem pref, print, exit, about, newWindow, englishHelpPage, spanishHelpPage,
      frenchHelpPage, germanHelpPage;
  private JButton hist, plot;
  private MenuItemWindow prefWindow;
  private JCheckBox polar, thousands, zeroes;
  private JTextField decimalPlaces;
  private String helpPageStr;
  private JTextPane historysc, graphsc;

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
    // frame.add(his.getWindow());//, BorderLayout.EAST); // changed to getWindow
    // frame.addComponentListener();

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
      textfield.setText(textfield.getText() + "ð�˜ª");
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
        complexResult = res;
        if (settings.getComplexNumberMode() == Settings.POLAR)
        {
          res = Calculate.convertRectangularToPolar(res);
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

        if (settings.getThousandsSeparatorMode() == settings.ON)
        {
          res.setFormat("%,." + settings.getNumDecimals() + "f");
        }
        else
        {
          res.setFormat("%." + settings.getNumDecimals() + "f");
        }

        res.setTrailingZeroes(settings.getTrailingZerosMode() == settings.ON);

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
    // hist.setText(settings.getLanguage().get("hist"));
    setTitle(settings.getLanguage().get("title"));
    // fileMenu.setText(settings.getLanguage().get("fileMenu"));
    // help.setText(settings.getLanguage().get("help"));
    // about.setText(settings.getLanguage().get("about"));
    // print.setText(settings.getLanguage().get("print"));
    // exit.setText(settings.getLanguage().get("exit"));
    // pref.setText(settings.getLanguage().get("pref"));
    if (prefWindow != null)
    {
      prefWindow.setTitle(settings.getLanguage().get("prefWindow"));
      polar.setText(settings.getLanguage().get("polar"));
      thousands.setText(settings.getLanguage().get("thousands"));
      zeroes.setText(settings.getLanguage().get("zeroes"));
      decimalPlaces.setText(settings.getLanguage().get("decimalPlaces"));
      historysc.setText(settings.getLanguage().get("historysc"));
      graphsc.setText(settings.getLanguage().get("graphsc"));
    }
    // plot.setText(settings.getLanguage().get("plot"));
    // helpPage.setText(settings.getLanguage().get("helpPage"));
    // newWindow.setText(settings.getLanguage().get("newWindow"));
  }

  // Menu Bar Code
  class MenuBar implements ActionListener
  {
    String aboutMessage = "This calculator performs operations on the given complex number operands. "
        + "A history of results from previosu calculations are stored in the history " + "panel.";
    String aboutTitle = "About";
    String printTitle = "Print";
    JMenuBar menuBar;
    JMenu fileMenu, help;
    JMenuItem pref, print, exit, about, newWindow, helpPage;

    public JMenuBar createMenuBar() throws FileNotFoundException
    {

      menuBar = new JMenuBar();
      ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
      JLabel label = new JLabel(icon);
      menuBar.add(label);
      JButton plot = new JButton("Graph");
      plot.addActionListener(e -> {

        // fill
        complexPlane.setVisible(true);
      });

      JButton hist = new JButton("History"); // HISTORY PANEL------------------------------------------------------------------------------------

      // frame.addComponentListener((ComponentListener) frame);
      hist.addActionListener(e -> {
        Point corner = panel.getLocation();
        his.createAndShowGUI(corner, panel.getWidth(), panel.getHeight());
        // frame.pack();
      });

      // help jmenuitem under Help menu
      help = new JMenu();

      about = new JMenuItem();
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

      spanishHelpPage = new JMenuItem("Ayuda en EspaÃ±ol");
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

      frenchHelpPage = new JMenuItem("Aide en FranÃ§ais");
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
      fileMenu = new JMenu();
      menuBar.add(fileMenu);

      // new window sub menu
      newWindow = new JMenuItem();
      fileMenu.add(newWindow);
      newWindow.addActionListener(this);
      newWindow.addActionListener(new ActionListener()
      {
        @Override
        public void actionPerformed(final ActionEvent e)
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
      pref = new JMenuItem();
      fileMenu.add(pref);
      pref.addActionListener(this);
      pref.addActionListener(e -> {
        prefWindow = new MenuItemWindow("", 900, 300);

        JPanel all = new JPanel();
        all.setLayout(new GridLayout(4, 1));
        prefWindow.add(all);
        JPanel modes = new JPanel();
        modes.setLayout(new GridLayout(1, 3));
        all.add(modes);

        polar = new JCheckBox();
        modes.add(polar);
        // Check box if previously saved.
        if (settings.getComplexNumberMode() == Settings.POLAR)
        {
          polar.setSelected(true);
          isPolarActive = true;
        }
        else if (settings.getComplexNumberMode() == Settings.RECTANGULAR)
        {
          polar.setSelected(false);
          isPolarActive = false;
        }
        polar.addActionListener(this);

        polar.addActionListener(f -> {
          if (settings.getComplexNumberMode() == Settings.RECTANGULAR)
          {
            settings.setComplexNumberMode(Settings.POLAR);
            isPolarActive = true;
          }
          else if (settings.getThousandsSeparatorMode() == Settings.POLAR)
          {
            settings.setComplexNumberMode(Settings.RECTANGULAR);
            isPolarActive = false;
          }
        });

        JButton thousands = new JButton("Thousands Separator");
        modes.add(thousands);
        thousands.addActionListener(this);
        // Check box if previously saved.
        if (settings.getThousandsSeparatorMode() == Settings.ON)
        {
          thousands.setSelected(true);
          thousandsSeparator = true;
        }
        else if (settings.getThousandsSeparatorMode() == Settings.OFF)
        {
          thousands.setSelected(false);
          thousandsSeparator = false;
        }

        thousands.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(final ActionEvent e)
          {
            if (settings.getThousandsSeparatorMode() == Settings.ON)
            {
              settings.setThousandsSeparatorMode(Settings.OFF);
              thousandsSeparator = false;
            }
            else if (settings.getThousandsSeparatorMode() == Settings.OFF)
            {
              settings.setThousandsSeparatorMode(Settings.ON);
              thousandsSeparator = true;
            }
          }
        });

        JButton zeroes = new JButton("Trailing zeroes");
        modes.add(zeroes);
        zeroes.addActionListener(this);
        // Check box if previously saved.
        if (settings.getTrailingZerosMode() == Settings.ON)
        {
          zeroes.setSelected(true);
          trailingZeroes = true;
        }
        else if (settings.getTrailingZerosMode() == Settings.OFF)
        {
          zeroes.setSelected(false);
          trailingZeroes = false;
        }

        zeroes.addActionListener(f -> {
          if (settings.getTrailingZerosMode() == Settings.ON)
          {
            settings.setTrailingZerosMode(Settings.OFF);
            trailingZeroes = false;
          }
          else if (settings.getTrailingZerosMode() == Settings.OFF)
          {
            settings.setTrailingZerosMode(Settings.ON);
            trailingZeroes = true;
          }
        });

        JPanel decimalPanel = new JPanel();
        decimalPanel.setLayout(new FlowLayout());
        decimalPlaces = new JTextField();
        decimalPlaces.setEditable(false);
        JTextArea decimals = new JTextArea("" + settings.getNumDecimals());
        numDecimals = settings.getNumDecimals();
        decimals.setText(""+numDecimals);
        decimals.setEditable(false);
        JButton up = new JButton("â†‘");
        up.addActionListener(this);
        up.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(final ActionEvent e)
          {
            settings.incrementNumDecimals();
            numDecimals++;
            decimals.setText(settings.getNumDecimals() + "");
          }
        });
        JButton down = new JButton("â†“");
        down.addActionListener(this);
        down.addActionListener(f -> {
          settings.decrementNumDecimals();
          numDecimals--;
          decimals.setText("" + settings.getNumDecimals());
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

        // opening history using keyboard shortcut dropdown menu

        DefaultStyledDocument dsd = new DefaultStyledDocument();
        historysc = new JTextPane(dsd);
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

        historyDropDown.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(ActionEvent e)
          {
            if(e.getSource() == hisShortcuts[0]){
              hist.setMnemonic(KeyEvent.VK_C);
            }
          }
        });

        // opening graph using keyboard shortcut dropdown menu

        DefaultStyledDocument dsd2 = new DefaultStyledDocument();
        graphsc = new JTextPane(dsd2);
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

        JButton french = new JButton("FranÃ§ais");

        langs.add(english);
        english.addActionListener(this);

        english.addActionListener(f ->

        {

          setSize(420, 480);
          english.setBackground(Color.GRAY);
          french.setBackground(null);
          german.setBackground(null);
          spanish.setBackground(null);

          settings.setLanguage(Settings.ENGLISH);

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

            settings.setLanguage(Settings.SPANISH);
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

            settings.setLanguage(Settings.GERMAN);

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

            settings.setLanguage(Settings.FRENCH);

          }
        });

        prefWindow.addWindowListener(new WindowAdapter()
        {
          public void windowClosing(final WindowEvent e)
          {
            try
            {
              Settings.saveSettings();
            }
            catch (IOException ex)
            {
              System.out.println("Unable to save settings file");
            }
          }
        });

        changeLanguage();
      });

      // print file menu
      print = new JMenuItem();
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
      exit = new JMenuItem();
      fileMenu.add(exit);
      exit.addActionListener(this);
      exit.addActionListener(new ActionListener()
      {
        public void actionPerformed(final ActionEvent e)
        {
          dispose();
        }
      });

      addWindowListener(new WindowAdapter()
      {
        public void windowClosing(final WindowEvent e)
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

  public static ComplexNumber getResult()
  {
    // TODO Auto-generated method stub
    return complexResult;
  }

  @Override
  public void componentResized(ComponentEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void componentMoved(ComponentEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void componentShown(ComponentEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void componentHidden(ComponentEvent e)
  {
    // TODO Auto-generated method stub

  }

}
