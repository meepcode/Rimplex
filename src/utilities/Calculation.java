package utilities;

/**
 * Represents a calculation of two complex numbers.
 */
@FunctionalInterface
public interface Calculation
{
  /**
   * Returns the evaluation of this calculation given the two complex numbers.
   * @param c1 the left operand
   * @param c2 the right operand
   * @return the evaluation
   */
  ComplexNumber calculate(ComplexNumber c1, ComplexNumber c2);
}
