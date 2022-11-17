package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class HistoryPanel extends JFrame
{
  
  private JPanel mainPanel;
  private JTextArea area;

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  // size: 420 x 480
  
  /**
   * 
   */
  public HistoryPanel() {
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout(0, 0));
    mainPanel.setBounds(50, 100, 300, 300);
    mainPanel.setVisible(false);
    
    Border b1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
    mainPanel.setBorder(b1);
    
    area = new JTextArea();
    area.setEditable(false);
    area.setRows(15);
    area.setColumns(25);
    mainPanel.add(area);
    area.setText("test string");
    
  }
  
  /**
   * 
   */
  public void createAndShowGUI() {
    boolean visible = mainPanel.isVisible();
    mainPanel.setVisible(!visible);
  }
 
  /**
   * 
   * @return
   */
  public JPanel getPanel() {
    return mainPanel;
  }
  
  
  
}
