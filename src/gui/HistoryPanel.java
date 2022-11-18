package gui;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Utilities;

/**
 * 
 * @author Team D
 *
 */
public class HistoryPanel extends JFrame
{

  private final JPanel mainPanel;
  private final JScrollPane pane;
  private final JEditorPane area;
  private final Point curr;
  private static final String SERIF = "Serif";
  private final Font myFont = new Font(SERIF, Font.BOLD, 20);
  private String word;
  private DefaultStyledDocument document;
  private ArrayList<String> list;
  private String historyList = "--------History--------\n";
  private int index = 0;

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  // size: 420 x 480

  /**
   * Constructor.
   */
  public HistoryPanel()
  {
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBounds(50, 100, 300, 300);
    mainPanel.setVisible(false);

    curr = mainPanel.getLocation();

    Border b1 = BorderFactory.createEmptyBorder(20, 20, 20, 20);
    mainPanel.setBorder(b1);

    document = new DefaultStyledDocument();
    area = new JTextPane(document);
    area.setEditable(false);
    pane = new JScrollPane(area);
    mainPanel.add(pane, BorderLayout.CENTER);

    mainPanel.add(area);

    area.setText(historyList);
    area.setBorder(b1);
    area.setFont(myFont);

    word = null;
    copyExpression();

    list = new ArrayList<>();
  }

  /**
   * Adds expression to history panel.
   */
  public void add()
  {

    if (ComplexCalc.isClicked)
    {
      list.add(ComplexCalc.result);
      historyList += list.get(index) + "\n";
      index++;

      area.setText(historyList);
      ComplexCalc.setClick();
    }
  }

  /**
   * Copy expression to clipboard
   */
  private void copyExpression()
  {

    area.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        try
        {

          int point = area.viewToModel2D(e.getPoint());
          int startPoint = Utilities.getRowStart(area, point);
          int endPoint = Utilities.getRowEnd(area, point);

          word = area.getText(startPoint, endPoint - startPoint);
          // System.out.println("word: " + word);

          StringSelection selection = new StringSelection(word);
          Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
          clipboard.setContents(selection, selection);

        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }
      }

      public void mouseEntered(MouseEvent e)
      {

        // fill

      }
    });

  }

  /**
   * Generates History panel.
   */
  public void createAndShowGUI()
  {
    boolean visible = mainPanel.isVisible();
    mainPanel.setVisible(!visible);
    area.setVisible(!visible);
//    if (!visible)
//    {
//      animate(mainPanel, new Point(308, 35), 15, 10);
//    }
//    else
//    {
//      mainPanel.setLocation(curr);
//    }
  }

  /**
   * Get History panel.
   * @return
   */
  public JPanel getPanel()
  {
    return mainPanel;
  }

  /**
   * Helper to animate history panel.
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

        if (currentFrame != frames)
        {
          currentFrame++;
        }
        else
        {
          ((Timer) e.getSource()).stop();
        }
      }
    }).start(); 
  }

}