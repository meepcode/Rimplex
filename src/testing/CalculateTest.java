package testing;

import org.junit.jupiter.api.Test;
import utilities.Calculate;
import utilities.ComplexNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTest
{
  private final ComplexNumber comp1 = new ComplexNumber(6.0, 4.0);
  private final ComplexNumber comp2 = new ComplexNumber(3.0, 2.0);

  @Test void addTest()
  {
    assertEquals(new ComplexNumber(9.0, 6.0), Calculate.add(comp1, comp2));
  }

  @Test void subtractTest()
  {
    assertEquals(new ComplexNumber(3.0, 2.0), Calculate.subtract(comp1, comp2));
  }

  @Test void divideTest()
  {
    assertEquals(new ComplexNumber(2.0, 0.0), Calculate.divide(comp1, comp2));
  }

  @Test void multiplyTest()
  {
    assertEquals(new ComplexNumber(10.0, 24.0), Calculate.multiply(comp1, comp2));
  }
}
