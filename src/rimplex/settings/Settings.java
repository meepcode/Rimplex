package rimplex.settings;

import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents the rimplex.settings of this program.
 *
 * @author TeamD
 * @version 12 /9/22 This work complies with the JMU Honor Code.
 */
public class Settings implements Serializable
{
  public static final String GERMAN_TEXT = "Einstellungen";
  public static final String UM = "Um";
  public static final String DRUCKEN = "Drucken";
  public static final String PREF = "Preferencias";
  public static final String SOBRE = "Sobre";
  public static final String IMPRESION = "Impresión";
  public static final String PRINT_TITLE = "printTitle";
  public static final String ABOUT_TITLE = "aboutTitle";
  public static final String ABOUT_MESSAGE = "aboutMessage";
  public static final String PREFERENCES ="Préférences";
  public static final String SUR ="Sur";
  public static final String IMPRIMER ="Imprimer";
  public static final String ABOUT ="About";
  public static final String PRINT ="Print";
  public static final String CALCULATOR ="Calculator";
  public static final String FILE ="File";
  public static final String HELP ="Help";
  public static final String HIST ="hist";
  public static final String FILE_MENU ="fileMenu";
  
  /**
   * The constant ON.
   */
  public static final int ON = 1;
  /**
   * The constant OFF.
   */
  public static final int OFF = 0;

  /**
   * The constant RECTANGULAR.
   */
  public static final int RECTANGULAR = 0;
  /**
   * The constant POLAR.
   */
  public static final int POLAR = 1;

  /**
   * The constant ENGLISH.
   */
  public static final int ENGLISH = 0;
  /**
   * The constant FRENCH.
   */
  public static final int FRENCH = 1;
  /**
   * The constant SPANISH.
   */
  public static final int SPANISH = 2;
  /**
   * The constant GERMAN.
   */
  public static final int GERMAN = 3;
  private static final String SAVE_FILE = "complexCalc.pref";
  private static final Set<LanguageChangeable> LANGUAGE_CHANGEABLES = new HashSet<>();
  private static Settings instance;
  private int thousandsSeparatorMode;
  private int trailingZerosMode;
  private int complexNumberMode;
  private int numDecimals;
  private Language language;
  private int languageNum;
  private KeyStroke openHistory;
  private KeyStroke openGraph;

  private Settings()
  {
    thousandsSeparatorMode = OFF;
    trailingZerosMode = OFF;
    complexNumberMode = RECTANGULAR;
    numDecimals = 2;
    language = null;
    setLanguage(ENGLISH);
    openHistory = KeyStroke.getKeyStroke('A', KeyEvent.CTRL_DOWN_MASK);
    openGraph = KeyStroke.getKeyStroke('J', KeyEvent.CTRL_DOWN_MASK);
  }

  /**
   * Returns the singleton rimplex.settings instance.
   *
   * @return the singleton rimplex.settings instance
   */
  public static Settings getInstance()
  {
    if (instance == null)
    {
      instance = loadSettings();
    }

    return instance;
  }

  /**
   * Serialize instance variable and save it.
   *
   * @throws IOException
   *     if something goes wrong saving the file.
   */
  public static void saveSettings() throws IOException
  {
    try (FileOutputStream fileOutputStream = new FileOutputStream(SAVE_FILE);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream serializer = new ObjectOutputStream(bufferedOutputStream))
    {
      serializer.writeObject(instance);
    }
  }

  /**
   * Loads the rimplex.settings file.
   * @return the rimplex.settings
   */
  private static Settings loadSettings()
  {
    try (FileInputStream fileOutputStream = new FileInputStream(SAVE_FILE);
        BufferedInputStream bufferedOutputStream = new BufferedInputStream(fileOutputStream);
        ObjectInputStream serializer = new ObjectInputStream(bufferedOutputStream))
    {
      return (Settings) serializer.readObject();
    }
    catch (IOException e)
    {
      System.out.println("Unable to load " + SAVE_FILE);
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Able to load " + SAVE_FILE + " but error in reading");
    }

    return new Settings();
  }

  /**
   * Adds a new language changeable to be changed when the language is updated.
   *
   * @param languageChangeable
   *     the language changeable
   */
  public static void addLanguageChangeable(final LanguageChangeable languageChangeable)
  {
    LANGUAGE_CHANGEABLES.add(languageChangeable);
  }
  
  /**
   * Get open history.
   * @return a keystroke.
   */
  public KeyStroke getOpenHistory()
  {
    return null;
  }
  
  /**
   * Set open history.
   * @param key a key.
   */
  public void setOpenHistory(final char key)
  {

  }

  /**
   * Get open graph.
   * @return a keystroke.
   */
  public KeyStroke getOpenGraph()
  {
    return null;
  }
  
  /**
   * Set open graph.
   * @param key a key.
   */
  public void setOpenGraph(final char key)
  {

  }

  /**
   * Gets thousands separator mode.
   *
   * @return the thousands separator mode
   */
  public int getThousandsSeparatorMode()
  {
    return thousandsSeparatorMode;
  }

  /**
   * Sets thousands separator mode.
   *
   * @param thousandsSeparatorMode
   *     the thousands separator mode
   */
  public void setThousandsSeparatorMode(final int thousandsSeparatorMode)
  {
    this.thousandsSeparatorMode = thousandsSeparatorMode;
  }

  /**
   * Gets complex number mode.
   *
   * @return the complex number mode
   */
  public int getComplexNumberMode()
  {
    return complexNumberMode;
  }

  /**
   * Sets complex number mode.
   *
   * @param complexNumberMode
   *     the complex number mode
   */
  public void setComplexNumberMode(final int complexNumberMode)
  {
    this.complexNumberMode = complexNumberMode;
  }

  /**
   * Gets language.
   *
   * @return the language
   */
  public Language getLanguage()
  {
    return language;
  }

  /**
   * Sets language.
   *
   * @param languageNum1
   *     the language number
   */
  public void setLanguage(final int languageNum1)
  {
    this.languageNum = languageNum1;

    if (languageNum == ENGLISH)
    {
      language = new Language("English");
      language.put(PRINT_TITLE, "Print");
      language.put("aboutMessage", "This calculator performs calculations on the "
          + "given complex number operands. The equation can be graphed on a complex plane."
          + " A history of results from previous calculations from previous "
          + "calculations are stored in the history panel.");
      language.put(ABOUT_TITLE, "About");
      language.put(HIST, "History");
      language.put("title", CALCULATOR);
      language.put(FILE_MENU, FILE);
      language.put("help", HELP);
      language.put("about", ABOUT);
      language.put("print", PRINT);
      language.put("exit", "Exit");
      language.put("pref", "Preferences");
      language.put("prefWindow", "Preferences");
      language.put("plot", "Graph");
      language.put("helpPage", "Help Page");
      language.put("newWindow", "New Window");
      language.put("polar", "Polar");
      language.put("thousands", "Thousands Place");
      language.put("zeroes", "Trailing Zeroes");
      language.put("decimalPlaces", "Decimal Places");
      language.put("historysc", "History Shortcut");
      language.put("graphsc", "Graph Shortcut");
      language.put("complexPlaneTitle", "Complex Plane");
    }
    else if (languageNum == FRENCH)
    {
      language = new Language("French");
      language.put("printTitle", IMPRIMER);
      language.put("aboutMessage", "Cette calculatrice effectue des calculs sur les opérandes"
          + " de nombres complexes donnés. L’équation peut être représentée graphiquement sur un"
          + " plan complexe. Un historique des résultats des calculs précédents des calculs"
          + " précédents est stocké dans le panneau Historique.");
      language.put("aboutTitle", SUR);
      language.put(HIST, "Histoire");
      language.put("title", "Calculatrice");
      language.put(FILE_MENU, "Dossier");
      language.put("help", "Aider");
      language.put("about", SUR);
      language.put("print", IMPRIMER);
      language.put("exit", "Sortir");
      language.put("pref", PREFERENCES);
      language.put("prefWindow", PREFERENCES);
      language.put("plot", "Complot");
      language.put("helpPage", "Page d’aide");
      language.put("newWindow", "Nouvelle fenêtre");
      language.put("polar", "Polaire");
      language.put("thousands", "Séparateur de Milliers");
      language.put("zeroes", "\"Zéros à Droite");
      language.put("decimalPlaces", "Décimales");
      language.put("historysc", "Raccourci Historique");
      language.put("graphsc", "Raccourci Graphique");
      language.put("complexPlaneTitle", "Plan complexe");

    }
    else if (languageNum == SPANISH)
    {
      language = new Language("Spanish");
      language.put("printTitle", IMPRESION);
      language.put("aboutMessage", "Esta calculadora realiza cálculos en los operandos de"
          + "números complejos dados. La ecuación se puede graficar en un plano complejo."
          + " En el panel Historial se almacena un historial de resultados de cálculos "
          + " anteriores de cálculos anteriores.");
      language.put("aboutTitle", SOBRE);
      language.put("hist", "Historia");
      language.put("title", "Calculadora");
      language.put("fileMenu", "Expediente");
      language.put("help", "Ayuda");
      language.put("about", SOBRE);
      language.put("print", IMPRESION);
      language.put("exit", "Salida");
      language.put("pref", PREF);
      language.put("prefWindow", PREF);
      language.put("plot", "Conspirar");
      language.put("helpPage", "Página de ayuda");
      language.put("newWindow", "Nueva ventana");
      language.put("polar", "MultiPolar");
      language.put("thousands", "Separador de Miles");
      language.put("zeroes", "Ceros Finales");
      language.put("decimalPlaces", "Número de Decimales");
      language.put("historysc", "Acceso Directo al Historial");
      language.put("graphsc", "Acceso Directo de Gráfico");
      language.put("complexPlaneTitle", "Plano complejo");
    }
    else if (languageNum == GERMAN)
    {
      language = new Language("German");
      language.put("printTitle", DRUCKEN);
      language.put("aboutMessage", "Dieser Rechner führt Berechnungen für die gegebenen"
          + " komplexen Zahlenoperanden durch. Die Gleichung kann auf einer komplexen"
          + " Ebene grafisch dargestellt werden. Ein Verlauf der Ergebnisse früherer"
          + " Berechnungen aus früheren Berechnungen wird im Bedienfeld \"Verlauf\" gespeichert.");
      language.put("aboutTitle", UM);
      language.put("hist", "Geschichte");
      language.put("title", "Taschenrechner");
      language.put("fileMenu", "Datei");
      language.put("help", "Hilfe");
      language.put("about", UM);
      language.put("print", DRUCKEN);
      language.put("exit", DRUCKEN);
      language.put("pref", GERMAN_TEXT);
      language.put("prefWindow", GERMAN_TEXT);
      language.put("plot", "Handlung");
      language.put("helpPage", "Hilfeseite");
      language.put("newWindow", "Neues Fenster");
      language.put("polar", "Polar");
      language.put("thousands", "Tausendertrennzeichen");
      language.put("zeroes", "Nachgestellte Nullen");
      language.put("decimalPlaces", "Dezimalstellen");
      language.put("historysc", "Verknüpfung Verlauf");
      language.put("graphsc", "Diagramm-Verknüpfung");
      language.put("complexPlaneTitle", "Komplexe Ebene");
    }
    else
    {
      throw new IllegalArgumentException();
    }

    for (LanguageChangeable languageChangeable : LANGUAGE_CHANGEABLES)
    {
      languageChangeable.changeLanguage();
    }
  }

  /**
   * Gets language num.
   *
   * @return the language num
   */
  public int getLanguageNum()
  {
    return languageNum;
  }

  /**
   * Gets trailing zeros mode.
   *
   * @return the trailing zeros mode
   */
  public int getTrailingZerosMode()
  {
    return trailingZerosMode;
  }

  /**
   * Sets trailing zeros mode.
   *
   * @param trailingZerosMode
   *     the trailing zeros mode
   */
  public void setTrailingZerosMode(final int trailingZerosMode)
  {
    this.trailingZerosMode = trailingZerosMode;
  }

  /**
   * Gets num decimals.
   *
   * @return the num decimals
   */
  public int getNumDecimals()
  {
    return numDecimals;
  }

  /**
   * Increment num decimals.
   */
  public void incrementNumDecimals()
  {
    numDecimals++;
  }

  /**
   * Decrement num decimals.
   */
  public void decrementNumDecimals()
  {
    if (numDecimals > 0)
    {
      numDecimals--;
    }
  }
}
