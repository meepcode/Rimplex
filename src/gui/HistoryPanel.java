package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
  public HistoryPanel()
  {
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
  public void createAndShowGUI()
  {

    boolean visible = mainPanel.isVisible();
    mainPanel.setVisible(!visible);
    animate(mainPanel, new Point(308, 35), 15, 10);
  }

  /**
   * 
   * @return
   */
  public JPanel getPanel()
  {
    return mainPanel;
  }

  /**
   * 
   * @param component
   * @param newPoint
   * @param frames
   * @param interval
   */
  private void animate(JComponent component, Point newPoint, int frames, int interval)
  {
    Rectangle compBounds = component.getBounds();

    Point oldPoint = new Point(compBounds.x, compBounds.y),
        animFrame = new Point((newPoint.x - oldPoint.x) / frames,
            (newPoint.y - oldPoint.y) / frames);

    new Timer(interval, new ActionListener()
    {
      int currentFrame = 0;

      public void actionPerformed(ActionEvent e)
      {
        component.setBounds(oldPoint.x + (animFrame.x * currentFrame),
            oldPoint.y + (animFrame.y * currentFrame), compBounds.width, compBounds.height);

        if (currentFrame != frames) {
          currentFrame++;
        }
        else {
          ((Timer) e.getSource()).stop();
        }
      }
    }).start();
  }

}
