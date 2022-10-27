package utilities;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * Calculator GUI
 * @author TeamD
 * @version 11/4/22
 * This work complies with the JMU Honor Code.
 *
 */

public class ComplexCalc extends JDialog {

	/**
	 * Constructor.
	 */
	public ComplexCalc() {
		super();
		setupLayout();
	}

	/**
	 * Helper method.
	 */
	public void setupLayout() {
		
		// size of calculator
		setSize(350, 200);

		Container contentPane;
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		// make panel to hold operator buttons
	    JPanel p = new JPanel();
	    p.setLayout(new GridLayout(1, 2));
	    add(p, BorderLayout.SOUTH);
	    JPanel operators = new JPanel();
	    
	    // adding buttons to panel
	    operators.add(new JButton("R")); // reset
	    operators.add(new JButton("C")); // clear
	    operators.add(new JButton("+")); // addition
	    operators.add(new JButton("-")); // subtraction
	    operators.add(new JButton("x")); // multiplication
	    operators.add(new JButton("/")); // division
	    operators.add(new JButton("=")); // equals
	    operators.setLayout((new FlowLayout(FlowLayout.TRAILING)));
	    p.add(operators);
	    
	    setVisible(true);
	}

	/**
	 * @param args String array
	 */
	public static void main(final String[] args) {
		ComplexCalc gui = new ComplexCalc();
	}
}

