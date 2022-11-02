package testing;

import org.junit.jupiter.api.Test;
import utilities.Calculate;
import utilities.ComplexNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

  @Test void divideTest()
  {
    assertEquals(new ComplexNumber(1.0, 0.0),
        Calculate.divide(new ComplexNumber(1.0, 1.0), new ComplexNumber(1.0, 1.0)));
  }

  @Test void parsePemdasTest()
  {
    assertEquals(new ComplexNumber(35.0, 47.0), evaluateExpression("(5+2i)+(6+3i)*(7+4i)"));
  }
}
