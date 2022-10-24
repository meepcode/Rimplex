package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilities.Check;

class CheckTest
{

  @Test
  void forContainsTest()
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

  @Test
  void forContainsTest_empty()
  {
    String[] haystack = {};
    assertFalse(Check.forContains(haystack, "Aardvark"));
  }

  @Test
  void forContainsTest_null()
  {
    assertEquals(Check.forContains(null, "Aardvark"));
    assertEquals(Check.forContains(null, null));
  }
}
