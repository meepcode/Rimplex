package settings;

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
 * Represents the settings of this program.
 * 
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
public class Settings implements Serializable
{
  /**
   * The constant ON.
   */
  public static final int ON = 0;
  /**
   * The constant OFF.
   */
  public static final int OFF = 1;

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
  private static final String saveFile = "complexCalc.pref";
  private static Settings instance;
  private static Set<LanguageChangeable> languageChangeables;
  private int thousandsSeparatorMode;
  private int complexNumberMode;
  private Language language;

  private Settings()
  {
    thousandsSeparatorMode = OFF;
    complexNumberMode = RECTANGULAR;
    languageChangeables = new HashSet<>();
    language = null;
    setLanguage(ENGLISH);
  }

  /**
   * Returns the singleton settings instance.
   *
   * @return the singleton settings instance
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
    try (FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream serializer = new ObjectOutputStream(bufferedOutputStream))
    {
      serializer.writeObject(instance);
    }
  }

  /**
   * Loads the settings file.
   */
  private static Settings loadSettings()
  {
    try (FileInputStream fileOutputStream = new FileInputStream(saveFile);
        BufferedInputStream bufferedOutputStream = new BufferedInputStream(fileOutputStream);
        ObjectInputStream serializer = new ObjectInputStream(bufferedOutputStream))
    {
      return (Settings) serializer.readObject();
    }
    catch (IOException e)
    {
      System.out.println("Unable to load " + saveFile);
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Able to load " + saveFile + " but error in reading");
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
    languageChangeables.add(languageChangeable);
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
   * @param languageNum
   *     the language number
   */
  public void setLanguage(final int languageNum)
  {
    if (languageNum == ENGLISH)
    {
      language = new Language("English");
      language.put("printTitle", "Print");
      language.put("aboutMessage", "This calculator performs calculations on the " 
          + "given complex number operands. The equation can be graphed on a complex plane."
          + " A history of results from previous calculations from previous "
          + "calculations are stored in the history panel.");
      language.put("aboutTitle", "About");
      language.put("hist", "History");
      language.put("title", "Calculator");
      language.put("fileMenu", "File");
      language.put("help", "Help");
      language.put("about", "About");
      language.put("print", "Print");
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
      language.put("doubleParen", "Double Parenthesis");
      language.put("historysc", "History Shortcut");
      language.put("graphsc", "Graph Shortcut");
    }
    else if (languageNum == FRENCH)
    {
      language = new Language("French");
      language.put("printTitle", "Imprimer");
      language.put("aboutMessage", "Cette calculatrice effectue des calculs sur les opérandes"
          + " de nombres complexes donnés. L’équation peut être représentée graphiquement sur un"
          + " plan complexe. Un historique des résultats des calculs précédents des calculs"
          + " précédents est stocké dans le panneau Historique.");
      language.put("aboutTitle", "Sur");
      language.put("hist", "Histoire");
      language.put("title", "Calculatrice");
      language.put("fileMenu", "Dossier");
      language.put("help", "Aider");
      language.put("about", "Sur");
      language.put("print", "Imprimer");
      language.put("exit", "Sortir");
      language.put("pref", "Préférences");
      language.put("prefWindow", "Préférences");
      language.put("plot", "Complot");
      language.put("helpPage", "Page d’aide");
      language.put("newWindow", "Nouvelle fenêtre");
      language.put("polar", "Polaire");
      language.put("thousands", "Séparateur de Milliers");
      language.put("zeroes", "\"Zéros à Droite");
      language.put("decimalPlaces", "Décimales");
      language.put("doubleParen", "Double parenthèse");
      language.put("historysc", "Raccourci Historique");
      language.put("graphsc", "Raccourci Graphique");
    }
    else if (languageNum == SPANISH)
    {
      language = new Language("Spanish");
      language.put("printTitle", "Impresión");
      language.put("aboutMessage", "Esta calculadora realiza cálculos en los operandos de" 
          + "números complejos dados. La ecuación se puede graficar en un plano complejo."
          + " En el panel Historial se almacena un historial de resultados de cálculos "
          +" anteriores de cálculos anteriores.");
      language.put("aboutTitle", "Sobre");
      language.put("hist", "Historia");
      language.put("title", "Calculadora");
      language.put("fileMenu", "Expediente");
      language.put("help", "Ayuda");
      language.put("about", "Sobre");
      language.put("print", "Impresión");
      language.put("exit", "Salida");
      language.put("pref", "Preferencias");
      language.put("prefWindow", "Preferencias");
      language.put("plot", "Conspirar");
      language.put("helpPage", "Página de ayuda");
      language.put("newWindow", "Nueva ventana");
      language.put("polar", "MultiPolar");
      language.put("thousands", "Separador de Miles");
      language.put("zeroes", "Ceros Finales");
      language.put("decimalPlaces", "Número de Decimales");
      language.put("doubleParen", "Doble Paréntesis");
      language.put("historysc", "Acceso Directo al Historial");
      language.put("graphsc", "Acceso Directo de Gráfico");
    }
    else if (languageNum == GERMAN)
    {
      language = new Language("German");
      language.put("printTitle", "Drucken");
      language.put("aboutMessage", "Dieser Rechner führt Berechnungen für die gegebenen" 
          + " komplexen Zahlenoperanden durch. Die Gleichung kann auf einer komplexen" 
          + " Ebene grafisch dargestellt werden. Ein Verlauf der Ergebnisse früherer"
          + " Berechnungen aus früheren Berechnungen wird im Bedienfeld \"Verlauf\" gespeichert.");
      language.put("aboutTitle", "Um");
      language.put("hist", "Geschichte");
      language.put("title", "Taschenrechner");
      language.put("fileMenu", "Datei");
      language.put("help", "Hilfe");
      language.put("about", "Um");
      language.put("print", "Drucken");
      language.put("exit", "Drucken");
      language.put("pref", "Einstellungen");
      language.put("prefWindow", "Einstellungen");
      language.put("plot", "Handlung");
      language.put("helpPage", "Hilfeseite");
      language.put("newWindow", "Neues Fenster");
      language.put("polar", "Polar");
      language.put("thousands", "Tausendertrennzeichen");
      language.put("zeroes", "Nachgestellte Nullen");
      language.put("decimalPlaces", "Dezimalstellen");
      language.put("doubleParen", "Doppelte Klammern");
      language.put("historysc", "Verknüpfung Verlauf");
      language.put("graphsc", "Diagramm-Verknüpfung");
    }
    else
    {
      throw new IllegalArgumentException();
    }

    for (LanguageChangeable languageChangeable : languageChangeables)
    {
      languageChangeable.changeLanguage();
    }
  }
}
