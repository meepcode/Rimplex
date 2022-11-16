package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculation.PolarComplexNumber;
import org.junit.jupiter.api.Test;

public class PolarComplexNumberTest
{

  @Test
  public void testToString()
  {
    PolarComplexNumber test = new PolarComplexNumber(120.0, 120.0, 2.0);
    assertEquals("2.0(cos(120.0°) + isin(120.0°))", test.toString());
  }
}
