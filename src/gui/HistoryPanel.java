package gui;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.Utilities;

public class HistoryPanel extends JFrame
{

  private final JPanel mainPanel;
  private final JScrollPane pane;
  private final JTextPane area;
  private final Point curr;
  private static final String SERIF = "Serif";
  private final Font myFont = new Font(SERIF, Font.BOLD, 30);

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
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBounds(50, 100, 300, 300);
    mainPanel.setVisible(false);
    
    curr = mainPanel.getLocation();

    Border b1 = BorderFactory.createEmptyBorder(20, 20, 20, 20);
    //mainPanel.setBorder(b1);

    area = new JTextPane();
    area.setEditable(false);
    pane = new JScrollPane(area);
    mainPanel.add(pane, BorderLayout.CENTER);
    
    mainPanel.add(area);
    //test string
    area.setText("x + 5 = 8");
    area.setBorder(b1);
    area.setFont(myFont);
    
    copyExpression();

  }
  
  /**
   * 
   */
  private void copyExpression() {
    
    area.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        try {
          String word = null;
          
          int point = area.viewToModel2D(e.getPoint());
          int startPoint = Utilities.getWordStart(area, point);
          int endPoint = Utilities.getWordEnd(area, point);
          
          word = area.getText(startPoint, endPoint - startPoint);
          System.out.println("word: " + word);
          
          StringSelection selection = new StringSelection(word);
          Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
          clipboard.setContents(selection, selection);
          
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });
    
  }

  /**
   * 
   */
  public void createAndShowGUI()
  {
    boolean visible = mainPanel.isVisible();
    mainPanel.setVisible(!visible);
    if (!visible) {
    animate(mainPanel, new Point(308, 35), 15, 10);
    } else {
      mainPanel.setLocation(curr);
    }
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
