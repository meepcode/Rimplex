package calculation;

/**
 * Complex number.
 *
 * @author TeamD
 * @version 11/4/22 This work complies with the JMU Honor Code.
 */
public class ComplexNumber
{
  // public static final String I = "\uD835\uDE2A";
  public static final String I = "i";
  public static final String FORMAT_TEXT = "%.2f";
  public static final double EPSILON = 0.000000000001;

  // These will be doubles representing the parts of a complex number.
  // Ex. 3 + 2i would save 3 to realPart and 2 to imaginaryPart.
  private final Double realPart;
  private final Double imaginaryPart;

  /**
   * Constructor from floating point numbers.
   *
   * @param realPart
   *     the real part of the complex number
   * @param imaginaryPart
   *     the imaginary part of the complex number
   */
  public ComplexNumber(final Double realPart, final Double imaginaryPart)
  {
    this.realPart = realPart;
    if (imaginaryPart == -0.0)
      this.imaginaryPart = 0.0;
    else 
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
   * Get the polar magnitude.
   *
   * @return polar magnitude.
   */
  public Double getPolarMagnitude()
  {
    return 0.0;
  }

  /**
   * To String.
   *
   * @return String representation of complex number.
   */
  public String toString()
  {
    if (imaginaryPart < 0)
    {
      return String.format(FORMAT_TEXT, realPart) + "-" + String.format(FORMAT_TEXT,
          Math.abs(imaginaryPart)) + I;
    }
    else
    {
      return String.format(FORMAT_TEXT, realPart) + "+" + String.format(FORMAT_TEXT, imaginaryPart)
          + I;
    }
  }

  /**
   * Compares two complex numbers.
   *
   * @param other
   *     complex number to compare.
   * @return true if same complex numbers.
   */
  @Override public boolean equals(final Object other)
  {
    if (other instanceof ComplexNumber that)
    {
      return (Math.abs(this.getReal() - that.getReal()) < EPSILON
          && Math.abs(this.getImaginary() - that.getImaginary()) < EPSILON);
    }
    return false;
  }

  /**
   * Gets the hashcode.
   *
   * @return hashcode.
   */
  @Override public int hashCode()
  {
    return (int) (realPart + 31 * imaginaryPart);
  }

}
