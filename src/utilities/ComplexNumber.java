package utilities;

import java.util.Deque;

/**
 * Complex number.
 *
 * @author TeamD
 * @version 11/4/22 This work complies with the JMU Honor Code.
 */
public class ComplexNumber implements Evaluatable
{
  private static String I = "i";

  // These will be doubles representing the parts of a complex number.
  // Ex. 3 + 2i would save 3 to realPart and 2 to imaginaryPart.
  private Double realPart;
  private Double imaginaryPart;

  /**
   * Constructor from floating point numbers.
   *
   * @param realPart
   *          the real part of the complex number
   * @param imaginaryPart
   *          the imaginary part of the complex number
   */
  public ComplexNumber(final Double realPart, final Double imaginaryPart)
  {
    this.realPart = realPart;
    this.imaginaryPart = imaginaryPart;
  }

  /**
   * Gets the real number part of a complex number.
   *
   * @return real number.
   */
  public Double getReal()
  {
    return realPart;
  }

  /**
   * Gets the imaginary number part of a complex number.
   *
   * @return real number.
   */
  public Double getImaginary()
  {
    return imaginaryPart;
  }

  /**
   * To String.
   *
   * @return String representation of complex number.
   */
  public String toString()
  {
    if (imaginaryPart < 0)
      return realPart + "-" + Math.abs(imaginaryPart) + I;
    else
      return realPart + "+" + imaginaryPart + I;
  }

  @Override
  public ComplexNumber evaluate(final Deque<Evaluatable> expression)
  {
    return this;
  }
  
  public boolean equals(final Object other)
  {
    ComplexNumber op2 = null;
    if (other instanceof ComplexNumber)
    {
      op2 = (ComplexNumber) other;
      return (this.getReal() == op2.getReal() && this.getImaginary() == op2.getImaginary());
    }
    return false;

  }

}
