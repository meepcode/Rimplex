package utilities;

/**
 * Complex number methods for calculations.
 *
 * @author TeamD
 * @version 11/4/22 This work complies with the JMU Honor Code.
 */
public class Calculate
{
  private static final String PLUS = " + ";
  
  /**
   * Add.
   * @param op1
   * @param op2
   * @return string.
   */
  public static ComplexNumber add(final ComplexNumber op1, final ComplexNumber op2)
  {
    int realResult = op1.getReal() + op2.getReal();
    int imaginaryResult = op1.getImaginary() + op2.getImaginary();
    return new ComplexNumber(realResult, imaginaryResult);
  }
  
  /**
   * Subtract.
   * @param op1
   * @param op2
   * @return string
   */
  public static ComplexNumber subtract(final ComplexNumber op1, final ComplexNumber op2)
  {
    int realResult = op1.getReal() - op2.getReal();
    int imaginaryResult = op1.getImaginary() - op2.getImaginary();
    return new ComplexNumber(realResult, imaginaryResult);
  }
  
  /**
   * Multiply.
   * @param op1
   * @param op2
   * @return a string
   */
  public static ComplexNumber multiply(final ComplexNumber op1, final ComplexNumber op2)
  {
    return null;
  }
  
  /**
   * Divide.
   * @return a string
   */
  public static ComplexNumber divide(final ComplexNumber op1, final ComplexNumber op2)
  {
    return null;
  }
}
