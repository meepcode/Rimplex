package testing;

import org.junit.jupiter.api.Test;
import calculation.ComplexNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static calculation.Parse.evaluateExpression;

/**
 * Tests the Parse class.
 */
public class ParseTest
{
  @Test void parsePemdasTest()
  {
    assertEquals(new ComplexNumber(35.0, 47.0), evaluateExpression("(5+2i)+(6+3i)*(7+4i)"));
  }

  @Test void parseDivision()
  {
    assertEquals(new ComplexNumber(2.0, 0.0), evaluateExpression("(6+4i)/(3+2i)"));
  }
}
