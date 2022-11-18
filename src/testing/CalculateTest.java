
package testing;

import org.junit.jupiter.api.Test;
import calculation.Calculate;
import calculation.ComplexNumber;
import calculation.PolarComplexNumber;

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
   * Test divide with a 0 value in numerator and denominator.
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

  @Test
  void testAddPolar()
  {
    ComplexNumber op1 = new ComplexNumber(2.0, 8.8);
    PolarComplexNumber test = Calculate.convertRectangularToPolar(op1);
    PolarComplexNumber res = new PolarComplexNumber(1.34, 1.34, 18.04);
    ComplexNumber temp = Calculate.add(test, test);
    PolarComplexNumber test1 = new PolarComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0,
        ((int) (temp.getPolarMagnitude() * 100)) / 100.0);
    assertEquals(res, test1);
  }

  @Test
  void testSubtractPolar()
  {
    ComplexNumber op1 = new ComplexNumber(2.0, 8.8);
    PolarComplexNumber test = Calculate.convertRectangularToPolar(op1);
    PolarComplexNumber res = new PolarComplexNumber(0.0, 0.0, 0.0);
    ComplexNumber temp = Calculate.subtract(test, test);
    PolarComplexNumber test1 = new PolarComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0,
        ((int) (temp.getPolarMagnitude() * 100)) / 100.0);
    assertEquals(res, test1);
  }

  @Test
  void testMultiplyPolar()
  {
    ComplexNumber op1 = new ComplexNumber(2.0, 8.8);
    PolarComplexNumber test = Calculate.convertRectangularToPolar(op1);
    PolarComplexNumber res = new PolarComplexNumber(1.34, 1.34, 18.04);
    ComplexNumber temp = Calculate.multiply(test, new ComplexNumber(2.0, 0.0));
    PolarComplexNumber test1 = new PolarComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0,
        ((int) (temp.getPolarMagnitude() * 100)) / 100.0);
    assertEquals(res, test1);
  }

  @Test
  void testDividePolar()
  {
    ComplexNumber op1 = new ComplexNumber(2.0, 8.8);
    PolarComplexNumber test = Calculate.convertRectangularToPolar(op1);
    PolarComplexNumber res = new PolarComplexNumber(1.34, 1.34, 4.51);
    ComplexNumber temp = Calculate.divide(test, new ComplexNumber(2.0, 0.0));
    PolarComplexNumber test1 = new PolarComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0,
        ((int) (temp.getPolarMagnitude() * 100)) / 100.0);
    assertEquals(res, test1);
  }

  @Test
  void testLogPolar()
  {
    ComplexNumber op = new ComplexNumber(2.0, 2.0);
    PolarComplexNumber op1 = Calculate.convertRectangularToPolar(op);
    ComplexNumber res = new ComplexNumber(1.5, 1.13);
    PolarComplexNumber res1 = Calculate.convertRectangularToPolar(res);
    res1 = new PolarComplexNumber(((int) (res1.getReal() * 100)) / 100.0,
        ((int) (res1.getImaginary() * 100)) / 100.0,
        ((int) (res1.getPolarMagnitude() * 100)) / 100.0);
    ComplexNumber temp = Calculate.log(2.0, op1);
    // Round result of log function to two digits.
    PolarComplexNumber test = new PolarComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0,
        ((int) (temp.getPolarMagnitude() * 100)) / 100.0);
    assertEquals(res1, test);
  }

  @Test
  void testExponentPolar()
  {
    ComplexNumber op = new ComplexNumber(2.0, 2.0);
    PolarComplexNumber op1 = Calculate.convertRectangularToPolar(op);
    ComplexNumber res = new ComplexNumber(0.0, 8.0);
    PolarComplexNumber res1 = Calculate.convertRectangularToPolar(res);
    ComplexNumber temp = Calculate.exponent(2.0, op1);
    temp = new PolarComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0,
        ((int) (temp.getPolarMagnitude() * 100)) / 100.0);
    res1 = new PolarComplexNumber(((int) (res1.getReal() * 100)) / 100.0,
        ((int) (res1.getImaginary() * 100)) / 100.0,
        ((int) (res1.getPolarMagnitude() * 100)) / 100.0);
    assertEquals(res1, temp);
  }

  @Test
  void testSquareRootPolar()
  {
    ComplexNumber op = new ComplexNumber(4.0, 0.0);
    PolarComplexNumber op1 = Calculate.convertRectangularToPolar(op);
    ComplexNumber res = new ComplexNumber(2.0, 0.0);
    PolarComplexNumber res1 = Calculate.convertRectangularToPolar(res);
    ComplexNumber temp = Calculate.convertPolarToRectangular(Calculate.squareRoot(op1));
    assertEquals(res, temp);
  }

  @Test
  void testConjugatePolar()
  {
    ComplexNumber op = new ComplexNumber(2.0, 2.0);
    PolarComplexNumber test = Calculate.convertRectangularToPolar(op);
    ComplexNumber temp = new ComplexNumber(2.0, -2.0);
    PolarComplexNumber res = Calculate.convertRectangularToPolar(temp);
    res = new PolarComplexNumber(((int) (res.getReal() * 100)) / 100.0,
        ((int) (res.getImaginary() * 100)) / 100.0,
        ((int) (res.getPolarMagnitude() * 100)) / 100.0);
    temp = Calculate.conjugate(test);
    temp = new PolarComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0,
        ((int) (temp.getPolarMagnitude() * 100)) / 100.0);
    assertEquals(res, temp);
  }

  @Test
  void testInvertPolar()
  {
    ComplexNumber op = new ComplexNumber(2.0, 2.0);
    PolarComplexNumber test = Calculate.convertRectangularToPolar(op);
    ComplexNumber temp = new ComplexNumber(1 / 2.0, 1 / 2.0);
    PolarComplexNumber res = Calculate.convertRectangularToPolar(temp);
    res = new PolarComplexNumber(((int) (res.getReal() * 100)) / 100.0,
        ((int) (res.getImaginary() * 100)) / 100.0,
        ((int) (res.getPolarMagnitude() * 100)) / 100.0);
    temp = Calculate.invert(test);
    temp = new PolarComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0,
        ((int) (temp.getPolarMagnitude() * 100)) / 100.0);
    assertEquals(res, temp);
  }

  @Test
  void testLog()
  {
    ComplexNumber op = new ComplexNumber(2.0, 2.0);
    ComplexNumber res = new ComplexNumber(1.5, 1.13);
    ComplexNumber temp = Calculate.log(2.0, op);
    // Round result of log function to two digits.
    ComplexNumber test = new ComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0);
    assertEquals(res, test);
  }

  @Test
  void testLogRealOnly()
  {
    ComplexNumber op = new ComplexNumber(2.0, 0.0);
    ComplexNumber res = new ComplexNumber(1.0, 0.0);
    assertEquals(res, Calculate.log(2.0, op));
  }

  @Test
  void testLogImaginaryOnly()
  {
    ComplexNumber op = new ComplexNumber(0.0, 2.0);
    ComplexNumber res = new ComplexNumber(1.0, 2.26);
    ComplexNumber temp = Calculate.log(2.0, op);
    // Round result of log function to two digits.
    ComplexNumber test = new ComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0);
    assertEquals(res, test);
  }

  @Test
  void testExponent()
  {
    ComplexNumber op = new ComplexNumber(2.0, 2.0);
    ComplexNumber res = new ComplexNumber(0.0, 8.0);
    assertEquals(res, Calculate.exponent(2.0, op));
  }

  @Test
  void testExponentRealOnly()
  {
    ComplexNumber op = new ComplexNumber(2.0, 0.0);
    ComplexNumber res = new ComplexNumber(4.0, 0.0);
    assertEquals(res, Calculate.exponent(2.0, op));
  }

  @Test
  void testExponentImaginaryOnlyEven()
  {
    ComplexNumber op = new ComplexNumber(0.0, 2.0);
    ComplexNumber res = new ComplexNumber(-4.0, 0.0);
    assertEquals(res, Calculate.exponent(2.0, op));
  }

  @Test
  void testExponentImaginaryOnlyOdd()
  {
    ComplexNumber op = new ComplexNumber(0.0, 2.0);
    ComplexNumber res = new ComplexNumber(0.0, -8.0);
    assertEquals(res, Calculate.exponent(3.0, op));
  }

  @Test
  void testSquareRoot()
  {
    ComplexNumber op = new ComplexNumber(2.0, 2.0);
    ComplexNumber res = new ComplexNumber(1.55, 0.64);
    ComplexNumber temp = Calculate.squareRoot(op);
    // Round result of sqrt function to two digits.
    ComplexNumber test = new ComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0);
    assertEquals(res, test);
  }

  @Test
  void testSquareRootRealOnly()
  {
    ComplexNumber op = new ComplexNumber(4.0, 0.0);
    ComplexNumber res = new ComplexNumber(2.0, 0.0);
    assertEquals(res, Calculate.squareRoot(op));
  }

  @Test
  void testSquareRootImaginaryOnly()
  {
    ComplexNumber op = new ComplexNumber(0.0, 4.0);
    ComplexNumber res = new ComplexNumber(0.0, 2.0);
    assertEquals(res, Calculate.squareRoot(op));
  }

  @Test
  void testConjugate()
  {
    ComplexNumber op = new ComplexNumber(2.0, 2.0);
    ComplexNumber res = new ComplexNumber(2.0, -2.0);
    assertEquals(res, Calculate.conjugate(op));
  }

  @Test
  void testInvert()
  {
    ComplexNumber op = new ComplexNumber(2.0, 2.0);
    ComplexNumber res = new ComplexNumber(1 / 2.0, 1 / 2.0);
    assertEquals(res, Calculate.invert(op));
  }

  @Test
  void testPToR()
  {
    ComplexNumber op = new ComplexNumber(1.99, 1.99);
    PolarComplexNumber res = new PolarComplexNumber(0.78540, 0.78540, 2.8284);
    ComplexNumber temp = Calculate.convertPolarToRectangular(res);
    // Round result of conversion function to two digits.
    ComplexNumber test = new ComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0);
    assertEquals(op, test);
  }

  @Test
  void testRToP()
  {
    ComplexNumber op = new ComplexNumber(2.0, 2.0);
    PolarComplexNumber res = new PolarComplexNumber(0.78, 0.78, 2.82);
    PolarComplexNumber temp = Calculate.convertRectangularToPolar(op);
    // Round result of conversion function to two digits.
    PolarComplexNumber test = new PolarComplexNumber(((int) (temp.getReal() * 100)) / 100.0,
        ((int) (temp.getImaginary() * 100)) / 100.0,
        ((int) (temp.getPolarMagnitude() * 100)) / 100.0);

    assertEquals(res, test);
  }

}
