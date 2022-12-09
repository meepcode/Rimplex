package calculation;

/**
 * Complex number.
 *
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
public class ComplexNumber
{
  public static final String I = "\uD835\uDE2A";
  public static final double EPSILON = 0.000000000001;

  // These will be doubles representing the parts of a complex number.
  // Ex. 3 + 2i would save 3 to realPart and 2 to imaginaryPart.
  private Double realPart;
  private Double imaginaryPart;
  
  private String formatText;
  private boolean trailingZeroes;


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
    formatText = "%.2f";
    trailingZeroes = false;
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
      String real = String.format(formatText, realPart);
      String imag = String.format(formatText, Math.abs(imaginaryPart));
      if (!trailingZeroes) 
      {
        while (real.charAt(real.length() - 1) == '0')
        {
          real = real.substring(0, real.length() - 1);
        }
        while (imag.charAt(imag.length() - 1) == '0')
        {
          imag = imag.substring(0, imag.length() - 1);
        }
        if (real.charAt(real.length() - 1) == '.') 
        {
          real = real.substring(0, real.length() - 1);
        }
        if (imag.charAt(imag.length() - 1) == '.') 
        {
          imag = imag.substring(0, imag.length() - 1);
        }
      }
      return real
          + "-" + imag + I;
    }
    else
    {
      String real = String.format(formatText, realPart);
      String imag = String.format(formatText, imaginaryPart);
      if (!trailingZeroes) 
      {
        while (real.charAt(real.length() - 1) == '0')
        {
          real = real.substring(0, real.length() - 1);
        }
        while (imag.charAt(imag.length() - 1) == '0')
        {
          imag = imag.substring(0, imag.length() - 1);
        }
        if (real.charAt(real.length() - 1) == '.') 
        {
          real = real.substring(0, real.length() - 1);
        }
        if (imag.charAt(imag.length() - 1) == '.') 
        {
          imag = imag.substring(0, imag.length() - 1);
        }
      }
      return real
          + "+" + imag + I;
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
  
  /**
   * Set the formatting for the complex number (number of decimals).
   * @param formatString String
   */
  public void setFormat(final String formatString)
  {
    formatText = formatString;
  }
  
  /**
   * Get the formatting.
   * @return The format string.
   */
  public String getFormat()
  {
    return formatText;
  }
  
  /**
   * Set the formatting for trailing zeroes.
   * @param zeroes true to turn zeroes on
   */
  public void setTrailingZeroes(final boolean zeroes)
  {
    trailingZeroes = zeroes;
  }
  
  /**
   * Get the formatting for trailing zeroes.
   * @return true if zeroes should be included
   */
  public boolean getTrailingZeroes()
  {
    return trailingZeroes;
  }

}
