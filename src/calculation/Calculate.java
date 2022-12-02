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
  private static final String DIVIDE_BY_ZERO = "Divide by 0";

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
    boolean polar = false;

    if (operands.length != 2)
    {
      throw new IllegalArgumentException(
          String.format(BAD_ARGUMENT_COUNT_STRING, 2, operands.length));
    }

    ComplexNumber op1 = operands[0];
    ComplexNumber op2 = operands[1];

    if (op1 instanceof PolarComplexNumber || op2 instanceof PolarComplexNumber)
    {
      polar = true;
      if (op1 instanceof PolarComplexNumber)
      {
        op1 = convertPolarToRectangular(op1);
      }

      if (op2 instanceof PolarComplexNumber)
      {
        op2 = convertPolarToRectangular(op2);
      }
    }

    Double realResult = op1.getReal() + op2.getReal();
    Double imaginaryResult = op1.getImaginary() + op2.getImaginary();
    ComplexNumber ret = new ComplexNumber(realResult, imaginaryResult);
    if (polar)
    {
      return convertRectangularToPolar(ret);
    }
    return ret;
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
    boolean polar = false;

    if (operands.length != 2)
    {
      throw new IllegalArgumentException(
          String.format(BAD_ARGUMENT_COUNT_STRING, 2, operands.length));
    }

    ComplexNumber op1 = operands[0];
    ComplexNumber op2 = operands[1];

    if (op1 instanceof PolarComplexNumber || op2 instanceof PolarComplexNumber)
    {
      polar = true;

      if (op1 instanceof PolarComplexNumber)
      {
        op1 = convertPolarToRectangular(op1);
      }

      if (op2 instanceof PolarComplexNumber)
      {
        op2 = convertPolarToRectangular(op2);
      }
    }
    Double realResult = op1.getReal() - op2.getReal();
    Double imaginaryResult = op1.getImaginary() - op2.getImaginary();
    ComplexNumber ret = new ComplexNumber(realResult, imaginaryResult);
    if (polar)
    {
      return convertRectangularToPolar(ret);
    }
    return ret;
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
    boolean polar = false;

    if (operands.length != 2)
    {
      throw new IllegalArgumentException(
          String.format(BAD_ARGUMENT_COUNT_STRING, 2, operands.length));
    }

    ComplexNumber op1 = operands[0];
    ComplexNumber op2 = operands[1];

    if (op1 instanceof PolarComplexNumber || op2 instanceof PolarComplexNumber)
    {
      polar = true;

      if (op1 instanceof PolarComplexNumber)
      {
        op1 = convertPolarToRectangular(op1);
      }

      if (op2 instanceof PolarComplexNumber)
      {
        op2 = convertPolarToRectangular(op2);
      }
    }

    Double realResult = op1.getReal() * op2.getReal() - op1.getImaginary() * op2.getImaginary();
    Double imaginaryResult =
        op1.getReal() * op2.getImaginary() + op1.getImaginary() * op2.getReal();
    ComplexNumber ret = new ComplexNumber(realResult, imaginaryResult);
    if (polar)
    {
      return convertRectangularToPolar(ret);
    }
    return ret;
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
    boolean polar = false;

    if (operands.length != 2)
    {
      throw new IllegalArgumentException(
          String.format(BAD_ARGUMENT_COUNT_STRING, 2, operands.length));
    }

    ComplexNumber op1 = operands[0];
    ComplexNumber op2 = operands[1];

    if (op1 instanceof PolarComplexNumber || op2 instanceof PolarComplexNumber)
    {
      polar = true;

      if (op1 instanceof PolarComplexNumber)
      {
        op1 = convertPolarToRectangular(op1);
      }

      if (op2 instanceof PolarComplexNumber)
      {
        op2 = convertPolarToRectangular(op2);
      }

    }

    if (op2.getReal() == 0.0 && op2.getImaginary() == 0.0)
    {
      throw new ArithmeticException(DIVIDE_BY_ZERO);
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
    ComplexNumber ret = new ComplexNumber(realResult, imaginaryResult);
    if (polar)
    {
      return convertRectangularToPolar(ret);
    }
    return ret;
  }

  /**
   * Calculate the log of a number.
   *
   * @param base
   *     base to use for log calculation
   * @param operand
   *     the operand to calculate log for
   * @return the log as a complex number
   */
  public static ComplexNumber log(final Double base, final ComplexNumber operand)
  {
    boolean polar = false;
    if (base == 0)
    {
      throw new IllegalArgumentException("Base is invalid");
    }

    ComplexNumber op1 = operand;
    if (op1 instanceof PolarComplexNumber)
    {
      polar = true;
      op1 = convertPolarToRectangular(op1);
    }

    if (op1.getReal() == 0 && op1.getImaginary() == 0)
    {
      // If operand will result in infinity
      PolarComplexNumber temp = convertRectangularToPolar(op1);
      op1 = new ComplexNumber(Math.log(temp.getPolarMagnitude()) / Math.log(base), 0.0);
    }
    else
    {
      if (op1.getReal() == 0)
      {
        // If only imaginary part is valid
        op1 = new ComplexNumber(Math.log(op1.getImaginary()) / Math.log(base),
            (Math.PI / 2) / Math.log(base));
      }
      else if (op1.getImaginary() == 0)
      {
        // If only real part is valid
        op1 = new ComplexNumber(Math.log(op1.getReal()) / Math.log(base), 0.0);
      }
      else
      {
        // If operand is full complex number
        PolarComplexNumber temp = convertRectangularToPolar(op1);
        op1 = new ComplexNumber(Math.log(temp.getPolarMagnitude()) / Math.log(base),
            temp.getImaginary() / Math.log(base));
      }
    }
    if (polar)
    {
      return convertRectangularToPolar(op1);
    }
    return op1;
  }

  /**
   * Calculate the exponentiation of a number.
   *
   * @param operand
   *     the operands to use
   * @param exp
   *     power to use
   * @return the exponentiation as a complex number
   */
  public static ComplexNumber exponent(final Double exp, final ComplexNumber operand)
  {
    boolean polar = false;

    ComplexNumber op1 = operand;
    if (op1 instanceof PolarComplexNumber)
    {
      polar = true;
      op1 = convertPolarToRectangular(op1);
    }

    if (op1.getImaginary() == 0)
    {
      // If only real part is valid.
      op1 = new ComplexNumber(Math.pow(op1.getReal(), exp), 0.0);
    }
    else if (op1.getReal() == 0)
    {
      // If only imaginary part is valid.

      // If power is even, just return a realNumber
      if (exp % 2 == 0)
      {
        op1 = new ComplexNumber(Math.pow(op1.getImaginary(), exp) * -1, 0.0);
      }
      else
      { // Otherwise return an imaginary part
        op1 = new ComplexNumber(0.0, Math.pow(op1.getImaginary(), exp) * -1);
      }
    }
    else
    {
      ComplexNumber temp = op1;
      ComplexNumber ret = new ComplexNumber(op1.getReal(), op1.getImaginary());

      for (int i = 0; i < exp - 1; i++)
      {
        ret = multiply(ret, temp);
      }
      op1 = ret;
    }

    if (polar)
    {
      return convertRectangularToPolar(op1);
    }
    return op1;
  }

  /**
   * Calculate the square root of a number.
   *
   * @param operand
   *     the operand to use.
   * @return the square root as a complex number.
   */
  public static ComplexNumber squareRoot(final ComplexNumber operand)
  {
    boolean polar = false;

    ComplexNumber op1 = operand;
    if (op1 instanceof PolarComplexNumber)
    {
      polar = true;
      op1 = convertPolarToRectangular(op1);
    }

    if (op1.getImaginary() == 0) // If only real part is valid.
    {
      op1 = new ComplexNumber(Math.sqrt(op1.getReal()), 0.0);
    }
    else if (op1.getReal() == 0) // If only imaginary part is valid.
    {
      op1 = new ComplexNumber(0.0, Math.sqrt(op1.getImaginary()));
    }
    else
    { // If operand is a full complex number.
      //√(a + ib) = ± (√{     [√(a^2 + b^2) + a]    /2} + ib/|b| √{[√(a^2 + b^2) - a]/2})

      Double a = op1.getReal();
      Double b = op1.getImaginary();

      Double temp1 = Math.sqrt((Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) + a) / 2);
      Double temp2 = Math.sqrt((Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) - a) / 2);
      op1 = new ComplexNumber(temp1, temp2 * (b / Math.abs(b)));
    }
    if (polar)
    {
      return convertRectangularToPolar(op1);
    }
    return op1;
  }

  /**
   * Calculate the conjugate of a number.
   *
   * @param operand
   *     the operand to use
   * @return the conjugate as a complex number.
   */
  public static ComplexNumber conjugate(final ComplexNumber operand)
  {
    ComplexNumber op1 = operand;
    if (op1 instanceof PolarComplexNumber)
    {
      op1 = convertPolarToRectangular(op1);
      ComplexNumber result = new ComplexNumber(op1.getReal(), op1.getImaginary() * -1);
      return convertRectangularToPolar(result);
    }
    return new ComplexNumber(op1.getReal(), op1.getImaginary() * -1);
  }

  /**
   * Calculate the inverse of a number.
   *
   * @param operand
   *     complex number
   * @return the inverse as a complex number.
   */
  public static ComplexNumber invert(final ComplexNumber operand)
  {
    ComplexNumber op1 = operand;
    if (op1 instanceof PolarComplexNumber)
    {
      op1 = convertPolarToRectangular(op1);
      ComplexNumber numer = conjugate(op1);
      ComplexNumber denom = multiply(op1, conjugate(op1));

      ComplexNumber result = divide(numer, denom);
      return convertRectangularToPolar(result);
    }

    ComplexNumber numer = conjugate(op1);
    ComplexNumber denom = multiply(op1, conjugate(op1));

    ComplexNumber result = divide(numer, denom);
    return result;
  }

  /**
   * Converts a polar complex number to rectangular complex number.
   *
   * @param operand
   *     polar complex number
   * @return a complex number
   */
  public static ComplexNumber convertPolarToRectangular(final ComplexNumber operand)
  {
    Double realPart = operand.getPolarMagnitude() * Math.cos(operand.getReal());
    Double imaginaryPart = operand.getPolarMagnitude() * Math.sin(operand.getImaginary());
    return new ComplexNumber(realPart, imaginaryPart);
  }

  /**
   * Converts a rectangular complex number to polar complex number.
   *
   * @param operand
   *     rectangular complex number
   * @return a complex number
   */
  public static PolarComplexNumber convertRectangularToPolar(final ComplexNumber operand)
  {
    ComplexNumber op1 = operand;
    Double polarMagnitude = Math.sqrt(Math.pow(op1.getReal(), 2) + Math.pow(op1.getImaginary(), 2));
    Double polarAngle = Math.atan(op1.getImaginary() / op1.getReal());

    return new PolarComplexNumber(polarAngle, polarAngle, polarMagnitude);
  }
}
