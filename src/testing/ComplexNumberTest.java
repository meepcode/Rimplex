package testing;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import calculation.ComplexNumber;
/**
 * Complex number tests.
 *
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
class ComplexNumberTest
{
  // odd even
  private final double real = 3.0;
  private final double imag = 2.0;
  // odd odd
  private final double real1 = 5.0;
  private final double imag1 = 7.0;
  // even even
  private final double real2 = 10.0;
  private final double imag2 = 8.0;

  private final double real3 = 6.0;
  private final double imag3 = 4.0;

  private final double imagN = -11.0;
  // private final double realN = -9.0;

  private final ComplexNumber test = new ComplexNumber(real, imag);
  private final ComplexNumber test1 = new ComplexNumber(real1, imag1);
  private final ComplexNumber test2 = new ComplexNumber(real2, imag2);
  private final ComplexNumber test3 = new ComplexNumber(real3, imag3);

  // negative imaginary part
  private final ComplexNumber negI = new ComplexNumber(real, imagN);
  // both negative real and imaginary
  // private final ComplexNumber bothNeg = new ComplexNumber(realN, imagN);

  /**
   * Test getReal.
   */
  @Test
  void testGetReal()
  {
    assertEquals(3.0, test.getReal());
    assertEquals(5.0, test1.getReal());
    assertEquals(10.0, test2.getReal());
  }

  /**
   * Test getImaginary.
   */
  @Test
  void testGetImaginary()
  {
    assertEquals(2.0, test.getImaginary());
    assertEquals(7.0, test1.getImaginary());
    assertEquals(8.0, test2.getImaginary());
  }

  /**
   * Test toString returns -i.
   */
  @Test
  void testToStringMinus()
  {
    ComplexNumber c = new ComplexNumber(0.0, -1.0);
    assertEquals("0-1𝘪", c.toString());
  }
  
  /**
   * Test toString returns +i.
   */
  @Test
  void testToStringPos()
  {
    ComplexNumber c = new ComplexNumber(0.0, 1.0);
    assertEquals("0+1𝘪", c.toString());
  }
  
  /**
   * Test toString with trialing zeroes removed.
   */
  @Test
  void testToStringTrailingZeroes()
  {
    ComplexNumber c = new ComplexNumber(0.0, 1.0);
    c.setTrailingZeroes(true);
    assertEquals("0.00+1.00𝘪", c.toString());
  }
  
  /**
   * Test toString with trialing zeroes removed.
   */
  @Test
  void testToStringTrailingZeroesNegative()
  {
    ComplexNumber c = new ComplexNumber(0.0, -1.0);
    c.setTrailingZeroes(true);
    assertEquals("0.00-1.00𝘪", c.toString());
  }
  
  /**
   * Test toString with trialing zeroes removed.
   */
  @Test
  void testToStringTrailingZeroes2()
  {
    ComplexNumber c = new ComplexNumber(1.1, -1.10);
    assertEquals("1.1-1.1𝘪", c.toString());
  }
  
  /**
   * Test toString with trialing zeroes removed.
   */
  @Test
  void testToStringTrailingZeroes3()
  {
    ComplexNumber c = new ComplexNumber(1.1, 1.10);
    assertEquals("1.1+1.1𝘪", c.toString());
  }
  
  

  /**
   * Test equals with two equal complex number.
   */
  @Test
  void testEqualsTrue()
  {
    assertEquals(test, test);
    assertEquals(test, new ComplexNumber(real, imag));
  }

  /**
   * Test equals with different complex numbers.
   */
  @Test
  void testEqualsFalse()
  {
    assertNotEquals(test2, test);
    assertNotEquals(test3, test);
  }

  /**
   * Test equals with an object other than a complex number.
   */
  @Test
  void testEqualsNotComplex()
  {
    assertNotEquals(real, test2, String.valueOf(0.0));
    // without this return false isn't covered
    assertNotEquals(test2, 0);
    // assertFalse(test2.equals(null));
    // assertNotEquals(null, test2);
    // one branch is still missing but Berstein said not to worry about it
  }

  /**
   * Test equals when real part differs.
   */
  @Test
  void testEqualsDiffReal()
  {
    assertNotEquals(test2, new ComplexNumber(real3, imag2));
  }

  /**
   * Test equals when imaginary part differs.
   */
  @Test
  void testEqualsDiffImaginary()
  {
    assertNotEquals(test2, new ComplexNumber(real2, imag3));
  }

  /**
   * Test hashcode.
   */
  @Test
  void testHashcode()
  {
    assertEquals(32, new ComplexNumber(1.0, 1.0).hashCode());
  }
  
  /**
   * Test getPolarMagnitude.
   */
  @Test
  void testGetMagnitude()
  {
    assertEquals(0.0, new ComplexNumber(1.0, 1.0).getPolarMagnitude());
  }
  
  /**
   * Test getFormat.
   */
  @Test
  void testgetFormat()
  {
    ComplexNumber temp = new ComplexNumber(1.0, 1.0);
    String format = "%.2f";
    temp.setFormat(format);
    
    assertEquals(format, temp.getFormat());
  }
  
  /**
   * Test getTrailingZeroes.
   */
  @Test
  void testgetTrailingZeroes()
  {
    ComplexNumber temp = new ComplexNumber(1.0, 1.0);
    temp.setTrailingZeroes(true);
    
    assertEquals(true, temp.getTrailingZeroes());
  }
  
  /**
   * Test constructor with a negative zero input.
   */
  @Test
  void testConstructorNegativeZero()
  {
    ComplexNumber temp = new ComplexNumber(0.0, -0.0);    
    assertEquals(0.0, temp.getImaginary());
  }

}
