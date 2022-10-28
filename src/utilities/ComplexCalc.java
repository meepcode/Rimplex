package utilities;

import javax.swing.*;
import java.awt.*;
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
  private JTextField textField;

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
    textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
    inputPanel.add(textField);
    textField.setColumns(45);

    // buttons 
    JPanel buttonPanel = new JPanel();
    getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    JButton resetButton = new JButton("R");
    resetButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(resetButton);

    // reset button action listener
    resetButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        // TODO
      }
    });

    JButton clearButton = new JButton("C");
    clearButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(clearButton);

    // reset button action listener
    resetButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        // TODO
      }
    });

    JButton addButton = new JButton("+");
    addButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(addButton);

    // add button action listener
    addButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        // TODO
      }
    });

    JButton subtractionButton = new JButton("-");
    subtractionButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(subtractionButton);

    // subtraction button action listener
    subtractionButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        // TODO
      }
    });

    JButton multButton = new JButton("x");
    multButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(multButton);

    // multiplication button action listener
    multButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        // TODO
      }
    });

    JButton divideButton = new JButton("/");
    divideButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(divideButton);

    // divide button action listener
    divideButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        // TODO
      }
    });

    JButton equalsButton = new JButton("=");
    equalsButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(equalsButton);

    // equals button action listener
    equalsButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        // TODO
      }
    });

  }

  /**
   * Launch the application.
   *
   * @param args
   */
  public static void main(String[] args)
  {
    ComplexCalc window = new ComplexCalc();
    window.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e)
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
}
