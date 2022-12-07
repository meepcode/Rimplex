package calculation;

import java.util.Objects;

/**
 * Polar Complex number.
 *
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
public class PolarComplexNumber extends ComplexNumber
{
  private static final String COS = "(cos(";
  private static final String SIN = "sin(";
  private static final String END = "°))";

  private Double r; // The polar magnitude

  /**
   * Constructor.
   * 
   * @param realPart
   *          real
   * @param imaginaryPart
   *          imaginary
   * @param r
   *          polar magnitude: a new part used for polar form
   */
  public PolarComplexNumber(final Double realPart, final Double imaginaryPart, final Double r)
  {
    super(realPart, imaginaryPart);
    this.r = r;
  }

  /**
   * Get the polar magnitude r.
   * 
   * @return r.
   */
  @Override
  public Double getPolarMagnitude()
  {
    return r;
  }

  /**
   * ToString.
   * 
   * @return a polar complex number of form r(cos(a) + isin(b))
   */
  public String toString()
  {
    Double real = getReal();
    Double imaginary = getImaginary();
    if (Math.abs(real-0) < ComplexNumber.EPSILON) 
    {
      real = 0.0;
    }
    if (Math.abs(imaginary-0) < ComplexNumber.EPSILON) 
    {
      imaginary = 0.0;
    }
    
    String mag = String.format(getFormat(), r);
    String realStr = String.format(getFormat(), real);
    String imag = String.format(getFormat(), imaginary);
    
    
    if (!getTrailingZeroes()) 
    {
      while (mag.charAt(mag.length() - 1) == '0')
      {
        mag = mag.substring(0, mag.length() - 1);
      }
      while (realStr.charAt(realStr.length() - 1) == '0')
      {
        realStr = realStr.substring(0, realStr.length() - 1);
      }
      while (imag.charAt(imag.length() - 1) == '0')
      {
        imag = imag.substring(0, imag.length() - 1);
      }
      if (realStr.charAt(realStr.length() - 1) == '.') 
      {
        realStr = realStr.substring(0, realStr.length() - 1);
      }
      if (imag.charAt(imag.length() - 1) == '.') 
      {
        imag = imag.substring(0, imag.length() - 1);
      }
      if (mag.charAt(mag.length() - 1) == '.') 
      {
        mag = mag.substring(0, mag.length() - 1);
      }
    }
    
    return mag + COS + realStr + "°) + " + I + SIN + imag + END;
  }

  /**
   * Compares two complex numbers.
   *
   * @param other
   *          complex number to compare.
   * @return true if same complex numbers.
   */
  @Override
  public boolean equals(final Object other)
  {
    if (other instanceof PolarComplexNumber op2)
    {
      return (Objects.equals(this.getReal(), op2.getReal())
          && Objects.equals(this.getImaginary(), op2.getImaginary())
          && Objects.equals(this.r, op2.r));
    }
    return false;
  }

  /**
   * Gets the hashcode.
   *
   * @return hashcode.
   */
  @Override
  public int hashCode()
  {
    return (int) (getReal() + 31 * getImaginary());
  }

}
