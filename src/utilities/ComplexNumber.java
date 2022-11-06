package utilities;

import java.util.Deque;
import java.util.Objects;

/**
 * Complex number.
 *
 * @author TeamD
 * @version 11/4/22 This work complies with the JMU Honor Code.
 */
public class ComplexNumber implements Evaluatable
{
  private static final String I = "\uD835\uDE2A";

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
  @Override
  public boolean equals(final Object other)
  {
    if (other instanceof ComplexNumber)
    {
      ComplexNumber op2 = (ComplexNumber) other;
      return (Objects.equals(this.getReal(), op2.getReal()) && Objects.equals(this.getImaginary(),
          op2.getImaginary()));
    }
    return false;
  }

  @Override public int hashCode()
  {
    return super.hashCode();
  }
}
