package rimplex.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import rimplex.settings.Language;
import rimplex.settings.Language.LanguageException;

/**
 * Language test cases.
 *
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
class LanguageTest
{
  private static final String ENGLISH = "English";
  private static final String ABOUT = "aboutMessage";
  
  /**
   * Tests the constructor.
   */
  @Test
  void testConstructor()
  {
    Language test = new Language(ENGLISH);
  }
  
  /**
   * Tests get().
   */
  @Test
  void testGet()
  {
    Language test = new Language(ENGLISH);
    test.put(ENGLISH, ABOUT);
    assertEquals(ABOUT, test.get(ENGLISH));
  }
  
  /**
   * Tests get() with an unmapped value.
   */
  @Test
  void testGetNull()
  {
    Language test = new Language(ENGLISH);
    assertEquals("", test.get(ABOUT));
  }
  
  /**
   * Tests the LanguageException constuctor.
   */
  @Test
  void testLanguageException()
  {
    LanguageException test = new LanguageException(ENGLISH, ENGLISH);
  }
  

}
