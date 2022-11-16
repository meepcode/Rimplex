
package testing;

import org.junit.jupiter.api.Test;
import calculation.Calculate;
import calculation.ComplexNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculateTest
{
  private final ComplexNumber comp1 = new ComplexNumber(6.0, 4.0);
  private final ComplexNumber comp2 = new ComplexNumber(3.0, 2.0);
  private final ComplexNumber comp3 = new ComplexNumber(0.0, 2.0);
  private final ComplexNumber comp4 = new ComplexNumber(2.0, 0.0);
  private final ComplexNumber comp5 = new ComplexNumber(0.0, 0.0);
  private final ComplexNumber comp6 = new ComplexNumber(0.0, -1.0);

  /**
   * Test IllegalArgumentException for - add, subtract, multiply and divide
   */
  @Test
  void testIllegalArgumentException()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      Calculate.add(comp1);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Calculate.divide(comp1);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Calculate.multiply(comp1);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Calculate.subtract(comp1);
    });
  }

  /**
   * Test subtract.
   */
  @Test
  void testSubtract()
  {
    assertEquals(new ComplexNumber(3.0, 2.0), Calculate.subtract(comp1, comp2));
  }

  /**
   * Test add.
   */
  @Test
  void testAdd()
  {
    assertEquals(new ComplexNumber(9.0, 6.0), Calculate.add(comp1, comp2));
  }

  /**
   * Test divide.
   */
  @Test
  void testDivide()
  {
    assertEquals(new ComplexNumber(2.0, 0.0), Calculate.divide(comp1, comp2));
  }

  /**
   * Test multiply.
   */
  @Test
  void testMultiply()
  {
    assertEquals(new ComplexNumber(10.0, 24.0), Calculate.multiply(comp1, comp2));
  }

  /**
   * Test multiply with a 0 real value.
   */
  @Test
  void testMultiplyZeroReal()
  {
    assertEquals(new ComplexNumber(-8.0, 12.0), Calculate.multiply(comp1, comp3));
  }

  /**
   * Test multiply with a 0 imaginary value.
   */
  @Test
  void testMultiplyZeroImaginary()
  {
    assertEquals(new ComplexNumber(12.0, 8.0), Calculate.multiply(comp1, comp4));
  }

  /**
   * Test divide with a 0 real value in divisor.
   */
  @Test
  void testDivideZeroRealDivisor()
  {
    assertEquals(new ComplexNumber(2.0, -3.0), Calculate.divide(comp1, comp3));
  }

  /**
   * Test divide with a 0 imaginary value in divisor.
   */
  @Test
  void testDivideZeroImaginaryDivisor()
  {
    assertEquals(new ComplexNumber(3.0, 2.0), Calculate.divide(comp1, comp4));
  }

  /**
   * Test divide with a 0 real value in numerator.
   */
  @Test
  void testDivideZeroRealNumerator()
  {
    assertEquals(new ComplexNumber(2.0 / 13, 3.0 / 13), Calculate.divide(comp3, comp1));
  }

  /**
   * Test divide with a 0 imaginary value in numerator.
   */
  @Test
  void testDivideZeroImaginaryNumerator()
  {
    assertEquals(new ComplexNumber(3.0 / 13, -2.0 / 13), Calculate.divide(comp4, comp1));
  }

  /**
   * Test divide with by 0 + 0i.
   */
  @Test
  void testDivideByZero()
  {
    assertThrows(ArithmeticException.class, () -> Calculate.divide(comp1, comp5));
  }

  /**
   * Test divide with a 0 values in numerator and denominator.
   */
  @Test
  void testDivideMultipleZero()
  {
    assertEquals(new ComplexNumber(0.0, 2.0), Calculate.divide(comp4, comp6));
  }

  /**
   * Test constructor.
   */
  // @SuppressWarnings("InstantiationOfUtilityClass")
  @Test
  void testConstructor()
  {
    new Calculate();
  }

  @Test
  void subtractTest()
  {
    assertEquals(new ComplexNumber(3.0, 2.0), Calculate.subtract(comp1, comp2));
  }

  @Test
  void divideTest()
  {
    assertEquals(new ComplexNumber(2.0, 0.0), Calculate.divide(comp1, comp2));
  }

  @Test
  void multiplyTest()
  {
    assertEquals(new ComplexNumber(10.0, 24.0), Calculate.multiply(comp1, comp2));
  }
}
