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
    }
    else if (languageNum == FRENCH)
    {
      language = new Language("French");
    }
    else if (languageNum == SPANISH)
    {
      language = new Language("Spanish");
    }
    else if (languageNum == GERMAN)
    {
      language = new Language("German");
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
