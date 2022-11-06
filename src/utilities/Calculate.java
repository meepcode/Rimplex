package utilities;

/**
 * Complex number methods for calculations.
 *
 * @author TeamD
 * @version 11/4/22 This work complies with the JMU Honor Code.
 */
public class Calculate
{
  
  /**
   * Adds two complex numbers.
   * @param op1 First operand.
   * @param op2 Second operand.
   * @return The resulting complex number.
   */
  public static ComplexNumber add(final ComplexNumber op1, final ComplexNumber op2)
  {
    Double realResult = op1.getReal() + op2.getReal();
    Double imaginaryResult = op1.getImaginary() + op2.getImaginary();
    return new ComplexNumber(realResult, imaginaryResult);  
  }
  
  /**
   * Subtracts two complex numbers.
   * @param op1 First operand.
   * @param op2 Second operand.
   * @return The resulting complex number.
   */
  public static ComplexNumber subtract(final ComplexNumber op1, final ComplexNumber op2)
  {
    Double realResult = op1.getReal() - op2.getReal();
    Double imaginaryResult = op1.getImaginary() - op2.getImaginary();
    return new ComplexNumber(realResult, imaginaryResult);
  }
  
  /**
   * Multiplies two complex numbers.
   * @param op1 First operand.
   * @param op2 Second operand.
   * @return The resulting complex number.
   */
  public static ComplexNumber multiply(final ComplexNumber op1, final ComplexNumber op2)
  {    
    Double realResult = op1.getReal() * op2.getReal() - op1.getImaginary() * op2.getImaginary();
    Double imaginaryResult = op1.getReal() * op2.getImaginary() 
        + op1.getImaginary() * op2.getReal();

    return new ComplexNumber(realResult, imaginaryResult);
  }
  
  /**
   * Divides two complex numbers.
   * @param op1 First operand.
   * @param op2 Second operand.
   * @return The resulting complex number.
   */
  public static ComplexNumber divide(final ComplexNumber op1, final ComplexNumber op2)
  {
    
    if (op2.getReal() == 0.0 && op2.getImaginary() == 0.0) 
    {
      throw new IllegalFormatExpressionException();
    }
    // For op1 / op2
    // Both numerator and divisor have to be multiplied by the divisior's reciprocal
    ComplexNumber reciprocal = new ComplexNumber(op2.getReal(), op2.getImaginary() * -1);
    ComplexNumber numerator = multiply(op1, reciprocal);
    ComplexNumber denominator = multiply(op2, reciprocal);
    // This should result in a complex number of the form a + bi / a + bi
    Double realResult = null;
    if (denominator.getReal() == 0.0) // Avoid zero division error
    { 
      realResult = numerator.getReal();
    } else 
    {
      realResult = numerator.getReal() / denominator.getReal();
    }
    
    Double imaginaryResult = null;

    if (denominator.getImaginary() == 0.0) // Avoid zero division error
    { 
      imaginaryResult = numerator.getImaginary() / denominator.getReal();
    } else 
    {
      imaginaryResult = numerator.getImaginary() / denominator.getImaginary();
    }
    return new ComplexNumber(realResult, imaginaryResult);
  }
}
