package gui;

import settings.Settings;

import javax.swing.JTextField;
import java.awt.Font;

public class CalcTextField extends JTextField
{
  public CalcTextField(final Settings settings, final Font font)
  {
    super();
    setBounds(50, 25, 300, 50);
    setFont(font);
    setEditable(true);
  }
}
