package parse;

import calculation.ComplexNumber;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;

/**
 * A class with utilities for parsing strings into complex numbers.
 */
public class Parse
{

  /**
   * Evaluates the given expression.
   *
   * @param expressionStr
   *     the expression to evaluate
   * @return the evaluation of this expression
   * @throws ExpressionEvaluationException
   *     when the expression is not properly formatted
   */
  public static ComplexNumber evaluateExpression(final String expressionStr)
      throws ExpressionEvaluationException
  {
    Token[] tokens = tokenize(expressionStr);

    for (Token token : tokens)
    {
      System.out.println(token);
    }

    return null;
  }

  private static Token[] tokenize(final String expressionStr)
      throws ExpressionEvaluationException
  {
    String expression = expressionStr;
    Deque<Token> tokenDeque = new ArrayDeque<>();

    while (!expression.isEmpty())
    {
      boolean isMatch = false;
      for (TokenType type : TokenType.values())
      {
        Matcher matcher = type.getPattern().matcher(expression);
        if (matcher.find())
        {
          isMatch = true;

          tokenDeque.add(new Token(type, matcher.group().trim()));

          expression = matcher.replaceFirst("");
          break;
        }
      }

      if (!isMatch)
      {
        throw new ExpressionEvaluationException("Invalid token: " + expression);
      }
    }

    Token[] tokens = new Token[tokenDeque.size()];
    return tokenDeque.toArray(tokens);
  }

  private record Token(TokenType type, String sequence)
  {
    @Override public String toString()
    {
      return type + ": " + sequence;
    }
  }
}
