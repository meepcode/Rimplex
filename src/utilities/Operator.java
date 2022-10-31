package utilities;

import java.util.Deque;

/**
 * Represents the operators in the expression.
 */
public enum Operator implements Evaluatable
{
  ADD("+", 0, Calculate::add), SUBTRACT("-", 0, Calculate::subtract), MULTIPLY("*", 1,
    Calculate::multiply), DIVIDE("/", 1, Calculate::divide);

  private final String token;
  private final int precedence;
  private final Calculation calculation;

  Operator(final String token, final int precedence, final Calculation calculation)
  {
    this.token = token;
    this.precedence = precedence;
    this.calculation = calculation;
  }

  @Override public ComplexNumber evaluate(final Deque<Evaluatable> expression)
  {
    return calculation.calculate(expression.pop().evaluate(expression),
        expression.pop().evaluate(expression));
  }

  /**
   * Returns the string representation of this operator.
   * @return the string representation of this operator
   */
  public String toString()
  {
    return token;
  }

  /**
   * Returns the precedence of this operator.
   * @return the precedence
   */
  public int getPrecedence()
  {
    return precedence;
  }

  /**
   * Returns the operator associated with the given token.
   *
   * @param token
   *     the given token
   * @return the operator
   */
  public static Operator fromString(final String token)
  {
    return null;
  }
}
