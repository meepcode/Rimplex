package calculation;

/**
 * Polar Complex number.
 *
 * @author TeamD
 * @version 11/18/22 This work complies with the JMU Honor Code.
 */
public class PolarComplexNumber extends ComplexNumber
{

  private Double r; // The polar magnitude
  
  /**
   * Constructor.
   * @param realPart real
   * @param imaginaryPart imaginary
   * @param r polar magnitude: a new part used for polar form
   */
  public PolarComplexNumber(final Double realPart, final Double imaginaryPart, final Double r)
  {
    super(realPart, imaginaryPart);
    this.r = r;
  }
  
  /**
   * Get the polar magnitude r.
   * @return r.
   */
  public Double getPolarMagnitude()
  {
    return r;
  }
  
  /**
   * ToString.
   * @return a polar complex number of form r(cos(a) + isin(b))
   */
  public String toString()
  {
    if (getImaginary() < 0)
    {
      return String.format(FORMAT_TEXT, r) + "(cos(" + 
          String.format(FORMAT_TEXT, getReal()) 
          + "°) - " + I + "sin(" + String.format(FORMAT_TEXT, Math.abs(getImaginary())) + "°))";
    }
    else
    {
      return String.format(FORMAT_TEXT, r) + "(cos(" + 
          String.format(FORMAT_TEXT, getReal()) 
          + "°) + " + I + "sin(" + String.format(FORMAT_TEXT, Math.abs(getImaginary())) + "°))";
    }
  }

}
