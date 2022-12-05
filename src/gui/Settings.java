package gui;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/**
 * Represents the settings of this program.
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
  private int thousandsSeparatorMode;
  private int complexNumberMode;
  private Map<String, String> language;

  private Settings()
  {
    thousandsSeparatorMode = OFF;
    complexNumberMode = RECTANGULAR;
    language = null;
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
   * @throws IOException if something goes wrong saving the file.
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
  public Map<String, String> getLanguage()
  {
    return language;
  }

  /**
   * Sets language.
   *
   * @param language
   *     the language
   */
  public void setLanguage(final int language)
  {
    this.language = null;
  }
}
