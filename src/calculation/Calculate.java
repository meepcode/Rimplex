package calculation;

/**
 * Complex number methods for calculations.
 *
 * @author TeamD
 * @version 11/18/22 This work complies with the JMU Honor Code.
 */
public class Calculate
{

  private static final String BAD_ARGUMENT_COUNT_STRING = "Argument Count: Expected %d, Actual %d";

  /**
   * Adds two complex numbers.
   *
   * @param operands
   *     the operands to be added
   * @return The resulting complex number
   * @throws IllegalArgumentException
   *     if the number of arguments is not equal to 2
   */
  public static ComplexNumber add(final ComplexNumber... operands)
  {
    if (operands.length != 2)
    {
      throw new IllegalArgumentException(
          String.format(BAD_ARGUMENT_COUNT_STRING, 2, operands.length));
    }

    ComplexNumber op1 = operands[0];
    ComplexNumber op2 = operands[1];
    Double realResult = op1.getReal() + op2.getReal();
    Double imaginaryResult = op1.getImaginary() + op2.getImaginary();
    return new ComplexNumber(realResult, imaginaryResult);
  }

  /**
   * Subtracts two complex numbers.
   *
   * @param operands
   *     the operands to be subtracted
   * @return The resulting complex number
   * @throws IllegalArgumentException
   *     if the number of operands is not equal to 2
   */
  public static ComplexNumber subtract(final ComplexNumber... operands)
  {
    if (operands.length != 2)
    {
      throw new IllegalArgumentException(
          String.format(BAD_ARGUMENT_COUNT_STRING, 2, operands.length));
    }

    ComplexNumber op1 = operands[0];
    ComplexNumber op2 = operands[1];
    Double realResult = op1.getReal() - op2.getReal();
    Double imaginaryResult = op1.getImaginary() - op2.getImaginary();
    return new ComplexNumber(realResult, imaginaryResult);
  }

  /**
   * Multiplies two complex numbers.
   *
   * @param operands
   *     the operands to be multiplied
   * @return The resulting complex number
   * @throws IllegalArgumentException
   *     if the number of arguments is not equal to 2
   */
  public static ComplexNumber multiply(final ComplexNumber... operands)
  {
    if (operands.length != 2)
    {
      throw new IllegalArgumentException(
          String.format(BAD_ARGUMENT_COUNT_STRING, 2, operands.length));
    }

    ComplexNumber op1 = operands[0];
    ComplexNumber op2 = operands[1];
    Double realResult = op1.getReal() * op2.getReal() - op1.getImaginary() * op2.getImaginary();
    Double imaginaryResult =
        op1.getReal() * op2.getImaginary() + op1.getImaginary() * op2.getReal();

    return new ComplexNumber(realResult, imaginaryResult);
  }

  /**
   * Divides two complex numbers.
   *
   * @param operands
   *     the operands to divide together
   * @return The resulting complex number.
   */
  public static ComplexNumber divide(final ComplexNumber... operands)
  {
    if (operands.length != 2)
    {
      throw new IllegalArgumentException(
          String.format(BAD_ARGUMENT_COUNT_STRING, 2, operands.length));
    }

    ComplexNumber op1 = operands[0];
    ComplexNumber op2 = operands[1];

    if (op2.getReal() == 0.0 && op2.getImaginary() == 0.0)
    {
      throw new ArithmeticException("Divide by 0");
    }
    // For op1 / op2
    // Both numerator and divisor have to be multiplied by the divisior's reciprocal
    ComplexNumber reciprocal = new ComplexNumber(op2.getReal(), op2.getImaginary() * -1);
    ComplexNumber numerator = multiply(op1, reciprocal);
    ComplexNumber denominator = multiply(op2, reciprocal);
    // This should result in a complex number of the form a + bi / a + bi
    Double realResult;

    if (numerator.getReal() == 0.0) // Avoid zero division error
    {
      realResult = numerator.getReal();
    }
    else
    {
      realResult = numerator.getReal() / denominator.getReal();
    }

    // Because you have to multiply by conjugate, the denominator will always end up as a real num
    Double imaginaryResult = numerator.getImaginary() / denominator.getReal();

    return new ComplexNumber(realResult, imaginaryResult);
  }
  
  /**
   * Calculate the log of a number.
   * @param operands the operands to calculate log for
   * @return the log as a complex number
   */
  public ComplexNumber log(final ComplexNumber... operands) 
  {
     ComplexNumber op1 = operands[0];
     if (op1.getReal() == 0) 
     {
       // If only imaginary part is valid
       return new ComplexNumber(Math.log(op1.getImaginary()), Math.PI / 2);
     } else if (op1.getImaginary() == 0) 
     {
       // If only real part is valid
       return new ComplexNumber(Math.log(op1.getReal()), 0.0);
     } else 
     {
       // If operand is full complex number
       return new ComplexNumber(Math.log(op1.getImaginary() + Math.log(op1.getReal())), Math.PI / 2);
     }
  }
  
  /**
   * Calculate the exponentiation of a number.
   * @param operands the operands to use
   * @param exp power to use
   * @return the exponentiation as a complex number
   */
  public ComplexNumber exponent(Double exp, final ComplexNumber... operands) 
  {
    ComplexNumber op1 = operands[0];
    
    if (op1.getImaginary() == 0)
    {
      // If only real part is valid.
      return new ComplexNumber(Math.pow(op1.getReal(), exp), 0.0);
    } else if (op1.getReal() == 0)
    {
      // If only imaginary part is valid.
      
      
      // If power is even, just return a realNumber
      if (exp % 2 == 0)
      {
        return new ComplexNumber(Math.pow(op1.getImaginary(), exp), 0.0);
      } else 
      { // Otherwise return an imaginary part
        return new ComplexNumber(0.0, Math.pow(op1.getImaginary(), exp) * -1);
      }
    } else
    {
      ComplexNumber temp = op1;
      for (int i = 0; i < exp; i++) {
        temp = multiply(temp, temp);
      }
      return temp;
    }
  }
  
  /**
   * Calculate the square root of a number.
   * @param operands the operands to use.
   * @return the square root as a complex number.
   */
  public ComplexNumber squareRoot(final ComplexNumber...operands)
  {
    ComplexNumber op1 = operands[0];
    if (op1.getImaginary() == 0) // If only real part is valid.
    {
      return new ComplexNumber(Math.sqrt(op1.getReal()), 0.0);
    } else if (op1.getReal() == 0) // If only imaginary part is valid.
    {
      return new ComplexNumber(0.0, Math.sqrt(op1.getImaginary()));
    } else { // If operand is a full complex number.
      //√(a + ib) = ± (√{[√(a^2 + b^2) + a]/2} + ib/|b| √{[√(a^2 + b^2) - a]/2})
      Double a = op1.getReal();
      Double b = op1.getImaginary();
      
      Double temp1 = Math.sqrt(Math.sqrt(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) + a) / 2);
      Double temp2 = Math.sqrt(Math.sqrt(Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2)) + a) / 2);
      
      return new ComplexNumber(temp1, temp2 * (b / Math.abs(b)));
    }
  }
  
  /**
   * Calculate the conjugate of a number.
   * @param operands the operands to use
   * @return the conjugate as a complex number.
   */
  public ComplexNumber conjugate(final ComplexNumber... operands)
  {
    ComplexNumber op1 = operands[0];
    return new ComplexNumber(op1.getReal(), op1.getImaginary() * -1);
  }
  
  /**
   * Calculate the inverse of a number.
   * @param operands
   * @return the inverse as a complex number.
   */
  public ComplexNumber invert(final ComplexNumber... operands)
  {
    ComplexNumber op1 = operands[0];
    return divide(new ComplexNumber(1.0, 0.0), op1);
  }
  
  /**
   * Converts a polar complex number to rectangular complex number
   * @param operands polar complex number
   * @return a complex number
   */
  public ComplexNumber convertPolarToImaginary(final PolarComplexNumber... operands)
  {
    PolarComplexNumber op1 = operands[0];
    Double realPart = op1.getPolarMagnitude() * Math.cos(op1.getReal());
    Double imaginaryPart = op1.getPolarMagnitude() * Math.sin(op1.getImaginary());
    return new ComplexNumber(realPart, imaginaryPart);
  }
  
  /**
   * Converts a rectangular complex number to polar complex number
   * @param operands rectangular complex number
   * @return a complex number
   */
  public ComplexNumber convertRectangularToPolar(final ComplexNumber... operands)
  {
    ComplexNumber op1 = operands[0];
    Double polarMagnitude = Math.sqrt(Math.pow(op1.getReal(), 2) 
        + Math.pow(op1.getImaginary(), 2));
    Double polarAngle = Math.atan(op1.getReal()/op1.getImaginary());
    return new PolarComplexNumber(polarMagnitude, polarMagnitude, polarAngle);
  }
}
