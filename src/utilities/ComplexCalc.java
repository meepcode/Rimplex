package utilities;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextArea;
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
  private static final long serialVersionUID = 1L;
  // protected Shell shell;
  private final JTextField textField;
  private final String tahoma = "Tahoma";
  private String finalExpression = "";
  private boolean equalsPressed = false;
  private ComplexNumber result = null;

  /**
   * constructor.
   */
  public ComplexCalc()
  {
    setSize(500, 210);
    setAlwaysOnTop(true);
    setResizable(false);
    setTitle("Complex Calculator");
    getContentPane().setLayout(new BorderLayout(0, 0));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel displayPanel = new JPanel();
    getContentPane().add(displayPanel, BorderLayout.NORTH);

    JTextArea textArea = new JTextArea();
    textArea.setRows(5);
    textArea.setColumns(50);
    textArea.setEditable(false);
    textArea.setTabSize(50);
    displayPanel.add(textArea);

    JPanel inputPanel = new JPanel();
    getContentPane().add(inputPanel, BorderLayout.CENTER);

    textField = new JTextField();
    textField.setHorizontalAlignment(SwingConstants.RIGHT);
    textField.setFont(new Font(tahoma, Font.PLAIN, 11));
    inputPanel.add(textField);
    textField.setColumns(45);

    // buttons
    JPanel buttonPanel = new JPanel();
    getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    JButton resetButton = new JButton("R");
    resetButton.setFont(new Font(tahoma, Font.BOLD, 20));
    buttonPanel.add(resetButton);

    // reset button action listener
    resetButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        finalExpression = "";
        textArea.setText("");
        textField.setText("");
      }
    });

    JButton clearButton = new JButton("C");
    clearButton.setFont(new Font(tahoma, Font.BOLD, 20));
    buttonPanel.add(clearButton);

    // clear button action listener
    clearButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {// TODO
        textField.setText("");
      }
    });

    JButton addButton = new JButton("+");
    addButton.setFont(new Font(tahoma, Font.BOLD, 20));
    buttonPanel.add(addButton);

    // add button action listener
    addButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        
        // running calculations
        if (equalsPressed)
        {
          finalExpression = "(" + result.toString() + ") + ";
          textArea.setText(finalExpression);
          textField.setText("");
          equalsPressed = false;
        }
        else
        {
          if (Parse.isValidOperand(getTextField()))
          {
          // start calculation
          finalExpression += ("(" + getTextField() + ") + ");
          textArea.setText(finalExpression);
          textField.setText("");
          }
          else
          {
          JOptionPane.showMessageDialog(null, "Invalid operand");
          }
        }
        
      }
    });

    JButton subtractionButton = new JButton("-");
    subtractionButton.setFont(new Font(tahoma, Font.BOLD, 20));
    buttonPanel.add(subtractionButton);

    // subtraction button action listener
    subtractionButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        // if (Parse.isValidOperand(getTextField()))
        // {
        if (equalsPressed)
        {
          finalExpression = "(" + result.toString() + ") - ";
          textArea.setText(finalExpression);
          textField.setText("");
          equalsPressed = false;
        }
        else
        {
          finalExpression += ("(" + getTextField() + ") - ");
          textArea.setText(finalExpression);
          textField.setText("");
        }
        // }
        // else
        // {
        // JOptionPane.showMessageDialog(null, "Invalid operand");
        // }
      }
    });

    JButton multButton = new JButton("*");
    multButton.setFont(new Font(tahoma, Font.BOLD, 20));
    buttonPanel.add(multButton);

    // multiplication button action listener
    multButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        // if (Parse.isValidOperand(getTextField()))
        // {
        if (equalsPressed)
        {
          finalExpression = "(" + result.toString() + ") * ";
          textArea.setText(finalExpression);
          textField.setText("");
          equalsPressed = false;
        }
        else
        {
          finalExpression += ("(" + getTextField() + ") * ");
          textArea.setText(finalExpression);
          textField.setText("");
        }
        // }
        // else
        // {
        // JOptionPane.showMessageDialog(null, "Invalid operand");
        // }
      }
    });

    JButton divideButton = new JButton("/");
    divideButton.setFont(new Font(tahoma, Font.BOLD, 20));
    buttonPanel.add(divideButton);

    // divide button action listener
    divideButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        // if (Parse.isValidOperand(getTextField()))
        // {

        // running expression
        if (equalsPressed)
        {
          finalExpression = "(" + result.toString() + ") / ";
          textArea.setText(finalExpression);
          textField.setText("");
          equalsPressed = false;
        }
        else
        {
          finalExpression += ("(" + getTextField() + ") / ");
          textArea.setText(finalExpression);
          textField.setText("");
        }
        // }
        // else
        // {
        // JOptionPane.showMessageDialog(null, "Invalid operand");
        // }
      }
    });

    JButton equalsButton = new JButton("=");
    equalsButton.setFont(new Font(tahoma, Font.BOLD, 20));
    buttonPanel.add(equalsButton);

    // equals button action listener
    equalsButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        try
        {
          String operand = getTextField();
          if (Parse.isValidOperand(operand))
          {
            finalExpression += ("(" + getTextField() + ")");
            result = Parse.evaluateExpression(finalExpression);
            finalExpression += " = " + result.toString();
            textArea.setText(finalExpression);
            textField.setText("");
            equalsPressed = true;
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Invalid operand");
          }
        }
        catch (IllegalFormatExpressionException exception)
        {
          JOptionPane.showMessageDialog(null, "Invalid expression");
        }

      }
    });

  }

  /**
   * Launch the application.
   *
   * @param args
   *          String array
   */
  public static void main(final String[] args)
  {
    ComplexCalc window = new ComplexCalc();
    window.setVisible(true);
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // TODO Auto-generated method stub

  }

  /**
   * Getter method for text field input.
   *
   * @return String input
   */
  public String getTextField()
  {
    return this.textField.getText();
  }

  /**
   * Getter method for final expression.
   *
   * @return String expression
   */
  public String getExpression()
  {
    return finalExpression;
  }
  
}
