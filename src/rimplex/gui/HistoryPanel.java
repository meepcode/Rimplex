package rimplex.gui;

import javax.swing.JButton;

//import javax.swing.JComponent;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.Utilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Color;
//import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * HistoryPanel.
 * 
 * @author Team D
 * @version 12/9/22
 */
public class HistoryPanel extends JFrame
{

  private static final String SERIF = "Serif";

  private static final long serialVersionUID = 1L;
  private final JWindow mainPanel; // changed from JPanel
  private final JScrollPane pane;
  private final JEditorPane area;
  private final Point curr;
  private final Font myFont = new Font(SERIF, Font.PLAIN, 20);
  private String word;
  private final DefaultStyledDocument document;
  private final ArrayList<String> list;
  private String historyList = "";
  private int index = 0;
  private int wid = 0;
  private Timer tim;

  /**
   * Constructor.
   */
  public HistoryPanel()
  {

    // mainPanel = new JPanel();
    mainPanel = new JWindow();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBounds(50, 100, 30, 300); // setting the bounds else where
    mainPanel.setVisible(false);
    wid = mainPanel.getWidth();
    curr = mainPanel.getLocation();

    // Border b1 = BorderFactory.createEmptyBorder(20, 20, 20, 20);
    // mainPanel.setBorder(b1);

    document = new DefaultStyledDocument();
    area = new JTextPane(document);
    area.setEditable(false);
    pane = new JScrollPane(area);
    mainPanel.add(pane, BorderLayout.CENTER);

    mainPanel.add(area);
    mainPanel.add(pane);

    area.setText(historyList);
    // area.setBorder(b1);
    area.setFont(myFont);
    area.setPreferredSize(new Dimension(400, 240));
    word = null;
    // copyExpression();

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
          String[] words = word.split("=");
          StringSelection selection = new StringSelection(words[0]);
          Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
          clipboard.setContents(selection, selection);

          /* Highlight text to copy */
          Highlighter highlighter = area.getHighlighter();
          HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);
          // int p0 = word.indexOf(startPoint);
          // int p1 = p0 + "world".length();
          highlighter.addHighlight(startPoint, endPoint - words[1].length() - 1, painter);

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
   * Getter method for historyList.
   * 
   * @return String historyList
   */
  public String getHistoryList()
  {
    return historyList;
  }

  /**
   * Generates History panel.
   */
  public void createAndShowGUI(Point p, int width, int height)
  {
    System.out.println(p);
    System.out.println("The panel width:" + width + "----The panel height:" + height);
    // values to add x + 843 , y + 180
    int x = p.x + 843; // - (width / 50);//- 10; had to change it to an random value bc we switch to
                       // panel from frame
    int y = p.y + 180;
    System.out.print("x:" + x + "y:" + y);
    boolean visible = mainPanel.isVisible();
    mainPanel.setVisible(!visible);
    mainPanel.setLocation(x, y);
    JButton slideout = new JButton(">");
    area.setVisible(!visible);
    slideout.setBackground(new Color(115, 147, 179));
    slideout.setBounds(x + width, y + height, 10, 300);
    //area.add(slideout);
    mainPanel.add(slideout, BorderLayout.EAST);
    slideout.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      { 
        animate();
      }
    });
    System.out.println(mainPanel.getLocation());
    System.out.println(mainPanel.getSize());

  }

  /**
   * Get History panel.
   *
   * @return rimplex.main panel.
   */
  public JWindow getWindow() // changed to window
  {
    return mainPanel;
  }

  /**
   * Helper to animate history panel.
   */
  private void animate()
  {
    // a timer, swing packge
    // construct a timer
    int delay = 100; // milliseconds
    ActionListener taskPerformer = new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        wid += 10;
        mainPanel.setSize(wid, 300);
        System.out.print("the curr width" + wid);
        if (wid == 300) {
          tim.stop();
        }
      }
    };
    tim = new Timer(delay, taskPerformer);
    tim.start(); 
    
  }

}
