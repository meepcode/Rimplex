package calculation;

import java.util.Objects;

/**
 * Polar Complex number.
 *
 * @author TeamD
 * @version 11/18/22 This work complies with the JMU Honor Code.
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
    // if (getImaginary() < 0)
    // {
    return String.format(FORMAT_TEXT, r) + COS 
          + String.format(FORMAT_TEXT, getReal() * (180/Math.PI))
          + "°) + " + I + SIN 
          + String.format(FORMAT_TEXT, getImaginary() * (180/Math.PI)) + END;
  }
    // }
    /*}
    else
    {
      return String.format(FORMAT_TEXT, r) + COS 
          + String.format(FORMAT_TEXT, getReal() * (180/Math.PI))
          + "°) + " - I + SIN 
          + String.format(FORMAT_TEXT, Math.abs(getImaginary() * (180/Math.PI))) + END;

    }*/

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
