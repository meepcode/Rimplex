package testing;

import org.junit.jupiter.api.Test;
import utilities.Check;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckTest
{

  @Test void forContainsTest()
  {
    String[] haystack = {"Horse", "Cow", "Dog", "Cat"};
    assertTrue(Check.forContains(haystack, "Horse"));
    assertTrue(Check.forContains(haystack, "Cow"));
    assertTrue(Check.forContains(haystack, "Dog"));
    assertTrue(Check.forContains(haystack, "Cat"));
    assertFalse(Check.forContains(haystack, "Aardvark"));

    assertFalse(Check.forContains(haystack, "HORSE"));
    assertFalse(Check.forContains(haystack, "COW"));
  }

  @Test void forContainsTest_empty()
  {
    String[] haystack = {};
    assertFalse(Check.forContains(haystack, "Aardvark"));
  }

  @Test void forContainsTest_null()
  {
    assertFalse(Check.forContains((String[]) null, "Aardvark"));
    assertNull(Check.forContains((String[]) null, null));
  }
}
