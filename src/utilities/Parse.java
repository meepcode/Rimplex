package utilities;

import java.util.regex.Pattern;

/**
 * A class with utilities for parsing strings into complex numbers.
 */
public class Parse
{
  /**
   * Checks if the operand string given is a valid operand.
   *
   * @param operand the operand to check
   * @return if it is a valid operand.
   */
  public static boolean isValidOperand(final String operand)
  {
    return Pattern.matches("-?[0-9]+([+\\-])[0-9]+i", operand);
  }

  /**
   * Evaluates the given expression.
   *
   * @param expression the expression to evaluate
   * @return the evaluation of this expression
   */
  public static ComplexNumber evaluateExpression(final String expression)
  {
    return null;
  }
}
