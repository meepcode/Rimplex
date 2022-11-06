package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilities.ComplexNumber;

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

  // negatives
  private final double realN = -4.0;
  private final double imagN = -11.0;

  private ComplexNumber test = new ComplexNumber(real, imag);
  private ComplexNumber test1 = new ComplexNumber(real1, imag1);
  private ComplexNumber test2 = new ComplexNumber(real2, imag2);

  // negative imaginary part
  private ComplexNumber negI = new ComplexNumber(real, imagN);
  // both negative real and imaginary
  private ComplexNumber bothNeg = new ComplexNumber(realN, imagN);

  /**
   * complexNumberTest.
   *
   */
  @Test
  void complexNumberTest()
  {

    // getReal()
    assertEquals(3.0, test.getReal());
    assertEquals(5.0, test1.getReal());
    assertEquals(10.0, test2.getReal());
    // getImaginary()
    assertEquals(2.0, test.getImaginary());
    assertEquals(7.0, test1.getImaginary());
    assertEquals(8.0, test2.getImaginary());
    // toString()
    // when testing the decimal should naturally round up 
    String sTest = String.format("%f+%fi", real, imag);
    assertEquals(sTest, test.toString());
    String sTest1 = String.format("%f+%fi", real1, imag1);
    assertEquals(sTest1, test1.toString());
    // should not be accounting for negative imaginary parts and should throw an error but doesnt
    // String sNegI = String.format("%.1f-%.1fi", real1, imagN);
    // assertEquals(sNegI, negI.toString());
  }

}

