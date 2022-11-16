package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculation.PolarComplexNumber;
import org.junit.jupiter.api.Test;

public class PolarComplexNumberTest
{
  // when the imaginary part if greater than or equal to zero
  private PolarComplexNumber test = new PolarComplexNumber(120.0, 120.0, 2.0);
  // when the imaginary part is less than zero
  private PolarComplexNumber test2 = new PolarComplexNumber(120.0, -120.0, 4.0);

  /**
   * toString test.
   */
  @Test
  public void testToString()
  {
    // covers the else
    assertEquals("2.0(cos(120.0°) + isin(120.0°))", test.toString());
    // covers the if
    assertEquals("4.0(cos(120.0°) - isin(120.0°))", test2.toString());
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

}
