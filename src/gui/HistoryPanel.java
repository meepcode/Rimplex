package gui;

import java.awt.*;

import javax.swing.*;

public class HistoryPanel extends JFrame
{
  
  private JPanel mainPanel;
  private JTextArea area;

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  // size: 420 x 480
  
  public HistoryPanel() {
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout(0, 0));
    mainPanel.setSize(320, 320);
    
    area = new JTextArea();
    area.setEditable(false);
    area.setRows(22);
    area.setColumns(30);
    mainPanel.add(area);
    
  }
  
  /**
   * 
   */
  public void createAndShowGUI() {
    boolean visible = this.isVisible();
    this.setVisible(!visible);
  }
  
  
  
}
