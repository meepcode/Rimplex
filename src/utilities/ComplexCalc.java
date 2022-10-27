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

  /**
   * constructor
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

    JPanel buttonPanel = new JPanel();
    getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    JButton resetButton = new JButton("R");
    resetButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(resetButton);

    JButton clearButton = new JButton("C");
    clearButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(clearButton);

    JButton addButton = new JButton("+");
    addButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(addButton);

    JButton subtractionButton = new JButton("-");
    subtractionButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(subtractionButton);

    JButton multButton = new JButton("x");
    multButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(multButton);

    JButton divideButton = new JButton("/");
    divideButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(divideButton);

    JButton equalsButton = new JButton("=");
    equalsButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    buttonPanel.add(equalsButton);

  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  // protected Shell shell;
  private JTextField textField;

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

  // public class ComplexCalc extends JDialog
  // {
  //
  // /**
  // * Constructor.
  // */
  // public ComplexCalc()
  // {
  // super();
  // setupLayout();
  // }
  //
  // /**
  // * @param args
  // * String array
  // */
  // public static void main(final String[] args)
  // {
  // ComplexCalc gui = new ComplexCalc();
  // }
  //
  // /**
  // * Helper method.
  // */
  // public void setupLayout()
  // {
  //
  // // size of calculator
  // setSize(350, 200);
  //
  // Container contentPane;
  // contentPane = getContentPane();
  // contentPane.setLayout(new BorderLayout());
  //
  // // make panel to hold operator buttons
  // JPanel p = new JPanel();
  // p.setLayout(new GridLayout(1, 2));
  // add(p, BorderLayout.SOUTH);
  // JPanel operators = new JPanel();
  //
  // // adding buttons to panel
  // operators.add(new JButton("R")); // reset
  // operators.add(new JButton("C")); // clear
  // operators.add(new JButton("+")); // addition
  // operators.add(new JButton("-")); // subtraction
  // operators.add(new JButton("x")); // multiplication
  // operators.add(new JButton("/")); // division
  // operators.add(new JButton("=")); // equals
  // operators.setLayout((new FlowLayout(FlowLayout.TRAILING)));
  // p.add(operators);
  //
  // setVisible(true);
  // }
}
