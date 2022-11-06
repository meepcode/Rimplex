package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilities.ComplexNumber;
import java.util.Deque;
import utilities.Evaluatable;
class ComplexNumberTest
{
  // even odd

  private final double real = 3.0;
  private final double imag = 2.0;
  // odd odd
  private final double real1 = 5.0;
  private final double imag1 = 7.0;
  // even even
  private final double real2 = 10.0;
  private final double imag2 = 8.0;
  
  private final double real3 = 10.0;
  private final double imag3 = 4.0;

  // negatives
  private final double realN = -4.0;
  private final double imagN = -11.0;
  
  private final String formatText = "%.1f+%.1f𝘪";

  private ComplexNumber test = new ComplexNumber(real, imag);
  private ComplexNumber test1 = new ComplexNumber(real1, imag1);
  private ComplexNumber test2 = new ComplexNumber(real2, imag2);
  private ComplexNumber test3 = new ComplexNumber(real3, imag3);

  // negative imaginary part
  private ComplexNumber negI = new ComplexNumber(real, imagN);
  // both negative real and imaginary
  private ComplexNumber bothNeg = new ComplexNumber(realN, imagN);

  /**
   *  Test getReal.
   */
  @Test
  void testGetReal()
  {
    assertEquals(3.0, test.getReal());
    assertEquals(5.0, test1.getReal());
    assertEquals(10.0, test2.getReal());
  }
  
  /**
   *  Test getImaginary.
   */
  @Test
  void testGetImaginary()
  {
    assertEquals(2.0, test.getImaginary());
    assertEquals(7.0, test1.getImaginary());
    assertEquals(8.0, test2.getImaginary());
  }
  
  /**
   * Test toString.
   */
  @Test
  void testToString() 
  {
    // when testing the decimal should naturally round up 
    String sTest = String.format(formatText, real, imag);
    assertEquals(sTest, test.toString());
    String sTest1 = String.format(formatText, real1, imag1);
    assertEquals(sTest1, test1.toString());
    String sNegI = String.format("%.1f-%.1f𝘪", real, Math.abs(imagN));
    assertEquals(sNegI, negI.toString());
  }
  
  /**
   * Test evaluate.
   */
  @Test
  void testEvaluate() 
  {
    assertEquals(test, test.evaluate(null));
  }
  
  /**
   * Test equals with two equal complex number.
   */
  @Test
  void testEqualsTrue() 
  {
    assertEquals(test, test);
  }
  
  /**
   * Test equals with different complex numbers.
   */
  @Test
  void testEqualsFalse() 
  {
    assertEquals(false, test2.equals(test));
  }
  
  /**
   * Test equals with an object other than a complex number.
   */
  @Test
  void testEqualsNotComplex() 
  {
    assertEquals(false, test2.equals(real));
  }
  
  /**
   * Test equals with when real part differs.
   */
  @Test
  void testEqualsDiffReal() 
  {
    assertEquals(false, test2.equals(test1));
  }
  
  /**
   * Test equals with when imaginary part differs.
   */
  @Test
  void testEqualsDiffImaginary() 
  {
    assertEquals(false, test2.equals(test3));
  }
  
  /**
   * Test hashcode.
   */
  @Test
  void testHashcode()
  {
    test.hashCode();
  }

}

