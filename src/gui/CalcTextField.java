package gui;

import settings.Settings;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CalcTextField extends JTextField
{
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
