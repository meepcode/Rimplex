package rimplex.gui;

import rimplex.settings.Settings;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * CalcTextField.
 *
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
public class CalcTextField extends JTextField
{
  /**
   * CalcTextField Constructor.
   * @param settings saved preferences.
   * @param font font to use.
   */
  public CalcTextField(final Settings settings, final Font font)
  {
    super();
    setBounds(50, 25, 300, 50);
    setFont(font);
    setEditable(true);

    addKeyListener(new KeyAdapter()
    {
      @Override public void keyTyped(final KeyEvent e)
      {
        char c = e.getKeyChar();
        if (c == 'i' && (getText().isEmpty() || getText().charAt(getText().length() - 1) != 's'))
        {
          e.consume();
          setText(getText() + "𝘪");
        }
      }
    });
  }
}
