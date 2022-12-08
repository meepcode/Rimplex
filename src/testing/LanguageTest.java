package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import settings.Language;
import settings.Language.LanguageException;

/**
 * Language test cases.
 *
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
class LanguageTest
{

  @Test
  void testConstructor()
  {
    Language test = new Language("English");
  }
  
  @Test
  void testGet()
  {
    Language test = new Language("English");
    test.put("English", "aboutMessage");
    assertEquals("aboutMessage", test.get("English"));
  }
  
  @Test
  void testGetNull()
  {
    Language test = new Language("English");
    assertEquals("", test.get("aboutMessage"));
  }
  
  @Test
  void testLanguageException()
  {
    LanguageException test = new LanguageException("English", "English");
  }
  

}
