package rimplex.testing;

import rimplex.calculation.PolarComplexNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Test cases for PolarComplexNumber.
 *
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
public class PolarComplexNumberTest
{
  // when the imaginary part if greater than or equal to zero
  private final PolarComplexNumber test = new PolarComplexNumber(120.0, 120.0, 2.0);
  // when the imaginary part is less than zero
  private final PolarComplexNumber test2 = new PolarComplexNumber(120.0, -120.0, 4.0);
  private final PolarComplexNumber test3 = new PolarComplexNumber(121.0, -120.0, 4.0);
  private final PolarComplexNumber test4 = new PolarComplexNumber(120.0, -120.0, 3.0);

  /**
   * toString test.
   */
  @Test public void testToString()
  {
    // covers the else
    test.setTrailingZeroes(true);
    assertEquals("2.00(cos(6875.49°) + 𝘪sin(6875.49°))", test.toString());
    // covers the if
    test2.setTrailingZeroes(true);
    assertEquals("4.00(cos(6875.49°) + 𝘪sin(-6875.49°))", test2.toString());
  }
  
  /**
   * toString test.
   */
  @Test public void testToStringZeroValues()
  {
    PolarComplexNumber c = new PolarComplexNumber(0.0, 0.0, 0.0);
    assertEquals("0(cos(0°) + 𝘪sin(0°))", c.toString());
  }
  
  /**
   * toString test.
   */
  @Test public void testToStringRemoveTrailingZeroes()
  {
    PolarComplexNumber c = new PolarComplexNumber(1.10, 1.10, 1.10);
    assertEquals("1.1(cos(63.03°) + 𝘪sin(63.03°))", c.toString());
  }
  
  

  /**
   * getPolarMagnitude test.
   */
  @Test public void testGetPolarMagnitude()
  {
    assertEquals(2.0, test.getPolarMagnitude());
    assertEquals(4.0, test2.getPolarMagnitude());
  }

  /**
   * Equals test.
   */
  @Test public void testEquals()
  {
    assertEquals(test, test);
    assertNotEquals(test, 0);
  }

  /**
   * Tests equals with non-equal polar complex number.
   */
  @Test public void testNotEqual()
  {
    assertNotEquals(test, test2);
    assertNotEquals(test2, test4);
    assertNotEquals(test, test3);
    assertNotEquals(test, test4);
  }

  /**
   * hashCode test.
   */
  @Test public void testHashCode()
  {
    assertEquals(3840.0, test.hashCode());
  }

}
