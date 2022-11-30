package gui;

import javax.swing.BorderFactory;

//import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
//import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Utilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
//import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @author Team D
 */
public class HistoryPanel extends JFrame
{

  private static final String SERIF = "Serif";
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private final JPanel mainPanel;
  private final JScrollPane pane;
  private final JEditorPane area;
  private final Point curr;
  private final Font myFont = new Font(SERIF, Font.BOLD, 20);
  private String word;
  private final DefaultStyledDocument document;
  private final ArrayList<String> list;
  private String historyList = "";
  private int index = 0;
  
  
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
    area.setPreferredSize(new Dimension(400, 240));
    word = null;
    copyExpression();

    list = new ArrayList<>();
  }

  // size: 420 x 480

  /**
   * Accessor method for area.
   *
   * @return the area
   */
  public JEditorPane getArea()
  {
    return area;
  }

  /**
   * Adds expression to history panel.
   */
  public void add()
  {
    String ex = ComplexCalc.result;
    if (ex.length() >= 35)
    {
      area.setFont(new Font(SERIF, Font.BOLD, 15));
    }

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
   * Copy expression to clipboard.
   */
  private void copyExpression()
  {

    area.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(final MouseEvent e)
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
        catch (BadLocationException ex)
        {
          ex.printStackTrace();
        }
      }

      public void mouseEntered(final MouseEvent e)
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
   *
   * @return main panel.
   */
  public JPanel getPanel()
  {
    return mainPanel;
  }

  /**
   * Helper to animate history panel.
   *
   * @param component
   * @param newPoint
   * @param frames
   * @param interval
   */
<<<<<<< HEAD
  private void animate(JComponent component, final Point newPoint, int frames, int interval)
=======
  /*private void animate(final JComponent component, final Point newPoint, 
      final int frames, final int interval)
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {
    Rectangle compBounds = component.getBounds();

    Point oldPoint = new Point(compBounds.x, compBounds.y), animFrame = new Point(
        (newPoint.x - oldPoint.x) / frames, (newPoint.y - oldPoint.y) / frames);

    new Timer(interval, new ActionListener()
    {
      int currentFrame = 0;

      public void actionPerformed(final ActionEvent e)
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
  }*/

}
