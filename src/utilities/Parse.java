package utilities;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;

/**
 * A class with utilities for parsing strings into complex numbers.
 */
public class Parse
{
  private static final String WHITESPACE_REGEX = "\\s";

  /**
   * Checks if the operand string given is a valid operand.
   *
   * @param operand
   *     the operand to check
   * @return if it is a valid operand.
   */
  public static boolean isValidOperand(final String operand)
  {
    String newOperand = operand.replaceAll(WHITESPACE_REGEX, "");
    return Pattern.matches("-?[0-9]+\\.?[0-9]*([+\\-])[0-9]+\\.?[0-9]*i", newOperand);
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
    String newExpressionStr = expressionStr.replaceAll(WHITESPACE_REGEX, "");

    StringBuilder regex = new StringBuilder(
        "(\\((-?[0-9]+\\.?[0-9]*([+\\-])[0-9]+\\.?[0-9]*i)\\)*([");
    Operator[] operators = Operator.operators();
    for (int i = 0; i < operators.length; i++)
    {
      regex.append(operators[i]);
      if (i == 0)
      {
        regex.append("\\");
      }
    }
    regex.append("]))*(\\(-?[0-9]+\\.?[0-9]*([+\\-])[0-9]+\\.?[0-9]*i\\))");

    if (!Pattern.matches(regex.toString(), newExpressionStr))
    {
      throw new IllegalFormatExpressionException(expressionStr + " is not properly formatted");
    }

    Deque<Evaluatable> expression = parseExpression(newExpressionStr);

    return expression.pop().evaluate(expression);
  }

  private static Deque<Evaluatable> parseExpression(final String expressionStr)
  {
    String[] tokens = expressionStr.split("[(\\\\)]");
    Deque<Operator> operators = new ArrayDeque<>();
    Deque<Evaluatable> expression = new ArrayDeque<>();

    // First element of tokens is blank
    for (int i = 1; i < tokens.length; i++)
    {
      Evaluatable current = parseToken(tokens[i]);
      if (current instanceof ComplexNumber)
      {
        expression.push(current);
      }
      else
      {
        Operator operator = (Operator) current;

        while (!operators.isEmpty() && operators.peek().getPrecedence() >= operator.getPrecedence())
        {
          expression.push(operators.pop());
        }

        operators.push(operator);
      }
    }

    while (!operators.isEmpty())
    {
      expression.push(operators.pop());
    }

    return expression;
  }

  private static Evaluatable parseToken(final String token)
  {
    Evaluatable result;
    if (Operator.fromString(token) != null)
    {
      result = Operator.fromString(token);
    }
    else if (isValidOperand(token))
    {
      String[] complexNumber = token.split("(?=[+\\-])");
      result = new ComplexNumber(Double.parseDouble(complexNumber[0]),
          Double.parseDouble(complexNumber[1].substring(0, complexNumber[1].length() - 1)));
    }
    else
    {
      throw new IllegalFormatExpressionException(token + " is not a valid token");
    }

    return result;
  }
}
