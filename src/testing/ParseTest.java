package testing;

import org.junit.jupiter.api.Test;
import utilities.Calculate;
import utilities.ComplexNumber;
import utilities.Parse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static utilities.Parse.evaluateExpression;

/**
 * Tests the Parse class.
 */
public class ParseTest
{
  @Test void multiplyTest()
  {
    assertEquals("57.0-17.0i",
        Calculate.multiply(new ComplexNumber(5.0, 6.0), new ComplexNumber(3.0, -7.0)).toString());
  }

  @Test void parsePemdasTest()
  {
    assertNull(evaluateExpression("(5+2i)+(6+3i)*(7+4i)"));
  }
}
