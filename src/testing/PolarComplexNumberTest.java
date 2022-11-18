package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculation.PolarComplexNumber;
import org.junit.jupiter.api.Test;

/**
 * Test cases for PolarComplexNumber.
 * @author TeamD
 * @version 11/18/22 This work complies with the JMU Honor Code.
 *
 */
public class PolarComplexNumberTest
{
  // when the imaginary part if greater than or equal to zero
  private PolarComplexNumber test = new PolarComplexNumber(120.0, 120.0, 2.0);
  // when the imaginary part is less than zero
  private PolarComplexNumber test2 = new PolarComplexNumber(120.0, -120.0, 4.0);
  private PolarComplexNumber test3 = new PolarComplexNumber(121.0, -120.0, 4.0);
  private PolarComplexNumber test4 = new PolarComplexNumber(120.0, -120.0, 3.0);



  /**
   * toString test.
   */
  @Test
  public void testToString()
  {
    // covers the else
<<<<<<< HEAD
    assertEquals("2.0(cos(120.0°) + isin(120.0°))", test.toString());
=======
    assertEquals("2.00(cos(120.00Â°) + isin(120.00Â°))", test.toString());
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
    // covers the if
<<<<<<< HEAD
    assertEquals("4.0(cos(120.0°) - isin(120.0°))", test2.toString());
=======
    assertEquals("4.00(cos(120.00Â°) - isin(120.00Â°))", test2.toString());
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  }

  /**
   * getPolarMagnitude test.
   */
  @Test
  public void testGetPolarMagnitude()
  {
    assertEquals(2.0, test.getPolarMagnitude());
    assertEquals(4.0, test2.getPolarMagnitude());
  }
  
  /**
   * Equals test.
   */
  @Test
  public void testEquals()
  {
    assertEquals(test, test);
  }
  
  /**
   * Tests equals with non-equal polar complex number.
   */
  @Test
  public void testNotEqual()
  {
    assertEquals(false, test.equals(test2));
    assertEquals(false, test2.equals(test4));
    assertEquals(false, test.equals(test3));
    assertEquals(false, test.equals(test4));
  }
  
  
  /**
   * hashCode test.
   */
  @Test
  public void testHashCode()
  {
    assertEquals(3840.0, test.hashCode());
  }

}
