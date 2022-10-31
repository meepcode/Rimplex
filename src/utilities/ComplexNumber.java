package utilities;

/**
 * Complex number.
 *
 * @author TeamD
 * @version 11/4/22 This work complies with the JMU Honor Code.
 */
public class ComplexNumber
{
  private static String I = "i";
  
  // These will be integers representing the parts of a complex number.
  // Ex. 3 + 2i would save 3 to realPart and 2 to imaginaryPart.
  private Double realPart;
  private Double imaginaryPart;
  
  /**
   * Default constructor.
   * @param input String from user input.
   */
  public ComplexNumber(Double realPart, Double imaginaryPart) 
  {
    this.realPart = realPart;
    this.imaginaryPart = imaginaryPart;
  }
  
  /**
   * Gets the real number part of a complex number.
   * @return real number.
   */
  public Double getReal()
  {
    return realPart;
  }
  
  /**
   * Gets the imaginary number part of a complex number.
   * @return real number.
   */
  public Double getImaginary()
  {
    return imaginaryPart;
  }
  
  /**
   * To String.
   * @return String representation of complex number.
   */
  public String toString()
  {
    if (imaginaryPart < 0) 
      return realPart + " - " + Math.abs(imaginaryPart) + I;
    else
      return realPart + " + " + imaginaryPart + I;
  }
}
