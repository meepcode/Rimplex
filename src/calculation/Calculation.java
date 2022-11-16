package calculation;

/**
 * Represents a calculation of two complex numbers.
 */
@FunctionalInterface
public interface Calculation
{
  /**
   * Returns the evaluation of this calculation.
   * 
   * @param operands
   *          the operands this expression takes
   * @return the evaluation
   */
  ComplexNumber calculate(ComplexNumber... operands);
}
