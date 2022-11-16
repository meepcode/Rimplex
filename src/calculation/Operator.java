package calculation;

import java.util.Deque;

/**
 * Represents the operators in the expression.
 */
public enum Operator implements Evaluatable
{
  ADD("+", 0, 2, Calculate::add), SUBTRACT("-", 0, 2, Calculate::subtract), MULTIPLY("*", 1, 2,
      Calculate::multiply), DIVIDE("/", 1, 2, Calculate::divide);

  private final String token;
  private final int precedence;
  private final int operandCount;
  private final Calculation calculation;

  Operator(final String token, final int precedence, final int operandCount,
      final Calculation calculation)
  {
    this.token = token;
    this.precedence = precedence;
    this.operandCount = operandCount;
    this.calculation = calculation;
  }

  /**
   * Returns the operator associated with the given token.
   *
   * @param token
   *          the given token
   * @return the operator
   */
  public static Operator fromString(final String token)
  {
    for (Operator operator : operators())
    {
      if (token.equals(operator.token))
      {
        return operator;
      }
    }

    return null;
  }

  /**
   * Gets an array of all the operators.
   *
   * @return an array of all the operators
   */
  public static Operator[] operators()
  {
    return new Operator[] {ADD, SUBTRACT, MULTIPLY, DIVIDE};
  }

  @Override
  public ComplexNumber evaluate(final Deque<Evaluatable> expression)
  {
    ComplexNumber[] operands = new ComplexNumber[operandCount];

    for (int i = operandCount - 1; i >= 0; i--)
    {
      operands[i] = expression.pop().evaluate(expression);
    }

    return calculation.calculate(operands);
  }

  /**
   * Returns the string representation of this operator.
   *
   * @return the string representation of this operator
   */
  public String toString()
  {
    return token;
  }

  /**
   * Returns the precedence of this operator.
   *
   * @return the precedence
   */
  public int getPrecedence()
  {
    return precedence;
  }
}
