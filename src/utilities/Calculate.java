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
   * Adds two complex numbers.
   * @param op1 First operand.
   * @param op2 Second operand.
   * @return The resulting complex number.
   */
  public static String add(final ComplexNumber op1, final ComplexNumber op2)
  {
    Double realResult = op1.getReal() + op2.getReal();
    Double imaginaryResult = op1.getImaginary() + op2.getImaginary();
    return realResult + PLUS + imaginaryResult;
  }
  
  /**
   * Subtracts two complex numbers.
   * @param op1 First operand.
   * @param op2 Second operand.
   * @return The resulting complex number.
   */
  public static String subtract(final ComplexNumber op1, final ComplexNumber op2)
  {
    Double realResult = op1.getReal() - op2.getReal();
    Double imaginaryResult = op1.getImaginary() - op2.getImaginary();
    return realResult + PLUS + imaginaryResult;
  }
  
  /**
   * Multiplies two complex numbers.
   * @param op1 First operand.
   * @param op2 Second operand.
   * @return The resulting complex number.
   */
  public static String multiply(final ComplexNumber op1, final ComplexNumber op2)
  {
    return null;
  }
  
  /**
   * Divides two complex numbers.
   * @param op1 First operand.
   * @param op2 Second operand.
   * @return The resulting complex number.
   */
  public static String divide(final ComplexNumber op1, final ComplexNumber op2)
  {
    return null;
  }
}
