package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import calculation.ComplexNumber;
import calculation.IllegalFormatExpressionException;
import calculation.Operator;
import calculation.Parse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

/**
 * Calculator GUI.
 *
 * @author TeamD
 * @version 11/4/22 This work complies with the JMU Honor Code.
 */
public class ComplexCalc extends JFrame implements ActionListener
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  JFrame frame;
  JTextField textfield;
  JButton[] numberButtons = new JButton[10];
  JButton[] functionButtons = new JButton[15];
  JButton addButton, subButton, mulButton, divButton;
  JButton decButton, equButton, resetButton, clrButton, negButton, invButton, leftParenth, rightParenth, leftArrow, imaginaryNum, logButton;
  JPanel panel;

  Font myFont = new Font("Serif", Font.BOLD, 30);

  double num = 0;
  char operator;

  ComplexCalc()
  {
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 460);
    frame.setLayout(null);
    frame.setResizable(false);
    
    // menu bar
    MenuBar bar = new MenuBar();
    frame.add(bar.get());
    

    textfield = new JTextField();
    textfield.setBounds(50, 25, 300, 50);
    textfield.setFont(myFont);
    textfield.setEditable(false);

    resetButton = new JButton("R");
    subButton = new JButton("-");
    addButton = new JButton("+");
    mulButton = new JButton("*");
    divButton = new JButton("/");
    decButton = new JButton(".");
    equButton = new JButton("=");
    clrButton = new JButton("C");
    negButton = new JButton("(-)");
    leftParenth = new JButton("(");
    rightParenth = new JButton(")");
    leftArrow = new JButton("<");
    invButton = new JButton("Inv");
    imaginaryNum = new JButton("i");
    logButton = new JButton("Log");

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

    for (int i = 0; i < 14; i++)
    {
      functionButtons[i].addActionListener(this);
      functionButtons[i].setFont(myFont);
      functionButtons[i].setFocusable(false);
    }

    imaginaryNum.setFont(new Font("Serif", Font.ITALIC, 30));
    logButton.setFont(new Font("Serif", Font.BOLD, 10));
    invButton.setFont(new Font("Serif", Font.BOLD, 10));
    negButton.setFont(new Font("Serif", Font.BOLD, 10));
    resetButton.setFont(new Font("Serif", Font.BOLD, 20));
    clrButton.setFont(new Font("Serif", Font.BOLD, 20));

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
    frame.add(textfield);
    frame.add(panel);

    frame.setVisible(true);
  }

  public static void main(String[] args)
  {
    ComplexCalc calc = new ComplexCalc();
    System.out.println();
  }

  @Override
  public void actionPerformed(ActionEvent e)
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
      textfield.setText(textfield.getText().concat("."));
    }
    if (e.getSource() == addButton)
    {
      textfield.setText(textfield.getText() + "+");
    }
    if (e.getSource() == subButton)
    {
      textfield.setText(textfield.getText() + "-");
    }
    if (e.getSource() == mulButton)
    {
      textfield.setText(textfield.getText() + "*");
    }
    if (e.getSource() == divButton)
    {
      textfield.setText(textfield.getText() + "/");
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
  }
}

