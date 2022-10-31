package utilities;

/**
 * Complex number.
 *
 * @author TeamD
 * @version 11/4/22 This work complies with the JMU Honor Code.
 */
public class ComplexNumber
{
  int real;
  int imaginary;

  /**
   * Constructor from floating point numbers.
   *
   * @param real
   *     the real part of the complex number
   * @param imaginary
   *     the imaginary part of the complex number
   */
  public ComplexNumber(final int real, final int imaginary)
  {
    this.real = real;
    this.imaginary = imaginary;
  }

  /**
   * Gets the real number part of a complex number.
   *
   * @return real number.
   */
  public int getReal()
  {
    return real;
  }

  /**
   * Gets the imaginary number part of a complex number.
   *
   * @return real number.
   */
  public int getImaginary()
  {
    return imaginary;
  }

  /**
   * To String.
   *
   * @return String representation of complex number.
   */
  public String toString()
  {
    return null;
  }
}
