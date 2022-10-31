package utilities;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;

/**
 * A class with utilities for parsing strings into complex numbers.
 */
public class Parse
{
  /**
   * Checks if the operand string given is a valid operand.
   *
   * @param operand
   *     the operand to check
   * @return if it is a valid operand.
   */
  public static boolean isValidOperand(final String operand)
  {
    return Pattern.matches("-?[0-9]+([+\\-])[0-9]+i", operand);
  }

  /**
   * Evaluates the given expression.
   *
   * @param expressionStr
   *     the expression to evaluate
   * @return the evaluation of this expression
   * @throws IllegalFormatExpressionException
   *     when the expression is not properly formatted
   */
  public static ComplexNumber evaluateExpression(final String expressionStr)
      throws IllegalFormatExpressionException
  {
    if (!Pattern.matches(
        "(\\((-?[0-9]+([+\\-])[0-9]+i)\\)([+\\-*/]))?(\\(-?[0-9]+" + "([+\\-])[0-9]+i\\))",
        expressionStr))
    {
      throw new IllegalFormatExpressionException(expressionStr + " is not properly formatted");
    }

    String[] tokens = expressionStr.split("[(\\\\)]");
    Deque<Evaluatable> expression = new ArrayDeque<>();

    for (int i = 0; i < tokens.length; i++)
    {
      if (i % 2 == 0)
      {
        expression.push(parseComplexNumber(tokens[i]));
      }
      else
      {
        expression.push(Operator.fromString(tokens[i]));
      }
    }

    return expression.pop().evaluate(expression);
  }

  private static ComplexNumber parseComplexNumber(final String token)
  {
    return null;
  }
}
