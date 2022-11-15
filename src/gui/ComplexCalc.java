package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Calculator GUI.
 *
 * @author TeamD
 * @version 11/4/22 This work complies with the JMU Honor Code.
 */
public class ComplexCalc extends JFrame implements ActionListener
{
  private static final String SERIF = "Serif";
  private static final String MINUS = "-";
  private static final String PLUS = "+";
  private static final String ASTERISK = "*";
  private static final String SLASH = "/";
  private static final String DOT = ".";
  private final JFrame frame;
  private final JTextField textfield;
  private final JButton[] numberButtons = new JButton[10];
  private final JButton[] functionButtons = new JButton[16];
  private final JButton addButton, subButton, mulButton, divButton;
  private final JButton decButton, equButton, resetButton, clrButton, negButton, invButton, leftParenth, rightParenth, leftArrow, imaginaryNum, logButton, sqrtButton;
  private final JPanel panel;

  private final Font myFont = new Font(SERIF, Font.BOLD, 30);

  private final double num = 0;
  private char operator;

  ComplexCalc()
  {
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 480);
    frame.setLayout(null);
    frame.setResizable(false);

    // adding file menu
    MenuBar mb = new MenuBar();
    frame.setJMenuBar(mb.createMenuBar());

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
    clrButton = new JButton("C");
    negButton = new JButton("(-)");
    leftParenth = new JButton("(");
    rightParenth = new JButton(")");
    leftArrow = new JButton("<");
    invButton = new JButton("Inv");
    imaginaryNum = new JButton("i");
    logButton = new JButton("Log");
    sqrtButton = new JButton("\u221A");

    functionButtons[0] = addButton;
    functionButtons[1] = subButton;
    functionButtons[2] = mulButton;
    functionButtons[3] = divButton;
    functionButtons[4] = decButton;
    functionButtons[5] = equButton;
    functionButtons[6] = resetButton;
    functionButtons[7] = clrButton;
    functionButtons[8] = negButton;
    functionButtons[9] = invButton;
    functionButtons[10] = leftParenth;
    functionButtons[11] = rightParenth;
    functionButtons[12] = leftArrow;
    functionButtons[13] = imaginaryNum;
    functionButtons[14] = logButton;
    functionButtons[15] = sqrtButton;

    for (int i = 0; i < 16; i++)
    {
      functionButtons[i].addActionListener(this);
      functionButtons[i].setFont(myFont);
      functionButtons[i].setFocusable(false);
    }

    imaginaryNum.setFont(new Font(SERIF, Font.ITALIC, 30));
    logButton.setFont(new Font(SERIF, Font.BOLD, 10));
    invButton.setFont(new Font(SERIF, Font.BOLD, 10));
    negButton.setFont(new Font(SERIF, Font.BOLD, 10));
    resetButton.setFont(new Font(SERIF, Font.BOLD, 20));
    clrButton.setFont(new Font(SERIF, Font.BOLD, 20));
    sqrtButton.setFont(new Font(SERIF, Font.BOLD, 20));

    for (int i = 0; i < 10; i++)
    {
      numberButtons[i] = new JButton(String.valueOf(i));
      numberButtons[i].addActionListener(this);
      numberButtons[i].setFont(myFont);
      numberButtons[i].setFocusable(false);
    }

    panel = new JPanel();
    panel.setBounds(50, 100, 300, 300);
    panel.setLayout(new GridLayout(5, 4, 10, 10));

    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(numberButtons[3]);
    panel.add(addButton);
    panel.add(subButton);

    panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(numberButtons[6]);
    panel.add(mulButton);
    panel.add(divButton);

    panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(numberButtons[9]);
    panel.add(leftParenth);
    panel.add(rightParenth);
    panel.add(decButton);
    panel.add(numberButtons[0]);
    panel.add(equButton);
    panel.add(negButton);
    panel.add(invButton);
    panel.add(resetButton);
    panel.add(clrButton);
    panel.add(logButton);
    panel.add(imaginaryNum);
    panel.add(sqrtButton);
    frame.add(textfield);
    frame.add(panel);

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
      textfield.setText(textfield.getText() + PLUS);
    }
    if (e.getSource() == subButton)
    {
      textfield.setText(textfield.getText() + MINUS);
    }
    if (e.getSource() == mulButton)
    {
      textfield.setText(textfield.getText() + ASTERISK);
    }
    if (e.getSource() == divButton)
    {
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
    if (e.getSource() == negButton)
    {
      double temp = Double.parseDouble(textfield.getText());
      temp *= -1;
      textfield.setText(String.valueOf(temp));
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
      textfield.setText(textfield.getText() + "log");
    }
    if (e.getSource() == sqrtButton)
    {
      textfield.setText(textfield.getText() + "sqrt()");
    }
    if (e.getSource() == invButton)
    {
      textfield.setText(textfield.getText() + "Inv()");
    }
  }
}
