package settings;

import java.util.HashMap;

public class Language extends HashMap<String, String>
{
  private final String languageName;

  public Language(final String languageName)
  {
    super();
    this.languageName = languageName;
  }

  @Override public String get(final Object key)
  {
    String result = super.get(key);


    if (result == null)
    {
      result = "";
      // throw new LanguageException((String) key, languageName);
    }

    return result;
  }

  public static class LanguageException extends RuntimeException
  {
    public LanguageException(final String key, final String language)
    {
      super(String.format("%s not found in %s language", key, language));
    }
  }
}
