package parse;

import calculation.ComplexNumber;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;

/**
 * A class with utilities for parsing strings into complex numbers.
 */
public class Evaluation
{

  private static final String OPEN_PAREN = "(";
  private static final String CLOSE_PAREN = ")";

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

    Deque<Token> expression = parse(tokens);

    return null;
  }

  private static Deque<Token> parse(final Token[] tokens) throws ExpressionEvaluationException
  {
    Deque<Token> output = new ArrayDeque<>();
    Deque<Token> operators = new ArrayDeque<>();

    for (Token token : tokens)
    {
      if (token.type == TokenType.NUMBER)
      {
        output.push(token);
      }
      else if (token.type == TokenType.UNARY_FUNCTION)
      {
        operators.push(token);
      }
      else if (token.type == TokenType.OPEN_PAREN)
      {
        operators.push(token);
      }
      else if (token.type == TokenType.CLOSE_PAREN)
      {
        while (operators.isEmpty() || operators.peek().type != TokenType.OPEN_PAREN)
        {
          if (operators.isEmpty())
          {
            throw new ExpressionEvaluationException("Mismatching parenthesis");
          }
          output.push(operators.pop());
        }
      }
    }

    for (Token token : output)
    {
      System.out.println(token);
    }

    return output;
  }

  private static Token[] tokenize(final String expressionStr) throws ExpressionEvaluationException
  {
    String expression = expressionStr.replaceAll("\\s", "");
    List<Token> tokens = new ArrayList<>();

    while (!expression.isEmpty())
    {
      // Break the expression string into tokens
      boolean isMatch = false;
      for (TokenType type : TokenType.values())
      {
        Matcher matcher = type.getPattern().matcher(expression);
        if (matcher.find())
        {
          isMatch = true;

          tokens.add(new Token(type, matcher.group().trim()));

          expression = matcher.replaceFirst("");
          break;
        }
      }

      if (!isMatch)
      {
        throw new ExpressionEvaluationException("Invalid token: " + expression);
      }
    }

    // Parse first element to see if it is a plus or minus and changing the type
    if (tokens.get(0).type == TokenType.PLUS)
    {
      tokens.set(0, new Token(TokenType.UNARY_FUNCTION, tokens.get(0).sequence));
    }
    else if (tokens.get(0).type == TokenType.MINUS)
    {
      tokens.set(0, new Token(TokenType.UNARY_FUNCTION, tokens.get(0).sequence));
    }

    // preprocessing to allow for certain syntax that can't be parsed by the shunting yard algorithm
    for (int i = 0; i < tokens.size() - 1; i++)
    {
      TokenType curType = tokens.get(i).type;

      // Parse + or - to be a positive or negative number
      if (curType != TokenType.NUMBER && curType != TokenType.POLAR_NUMBER
          && curType != TokenType.CLOSE_PAREN && (tokens.get(i + 1).type == TokenType.PLUS
          || tokens.get(i + 1).type == TokenType.MINUS))
      {
        tokens.set(i + 1, new Token(TokenType.UNARY_FUNCTION, tokens.get(i + 1).sequence));
      }

      if (curType == TokenType.CLOSE_PAREN && tokens.get(i + 1).type == TokenType.OPEN_PAREN)
      {
        tokens.add(i + 1, new Token(TokenType.MULTIPLY, "*"));
      }

      if (curType == TokenType.UNARY_FUNCTION && (tokens.get(i + 1).type
          == TokenType.UNARY_FUNCTION))
      {
        if (i == tokens.size() - 2)
        {
          throw new ExpressionEvaluationException(
              "Invalid end to expression: " + tokens.get(i + 1).sequence);
        }

        tokens.add(i + 1, new Token(TokenType.OPEN_PAREN, OPEN_PAREN));
        tokens.add(i + 4, new Token(TokenType.CLOSE_PAREN, CLOSE_PAREN));
      }
      else if (curType == TokenType.UNARY_FUNCTION && tokens.get(i + 1).type == TokenType.NUMBER)
      {
        tokens.add(i + 1, new Token(TokenType.OPEN_PAREN, OPEN_PAREN));
        tokens.add(i + 3, new Token(TokenType.CLOSE_PAREN, CLOSE_PAREN));
      }
    }

    Token[] tokenArr = new Token[tokens.size()];
    return tokens.toArray(tokenArr);
  }

  private record Token(TokenType type, String sequence)
  {
    @Override public String toString()
    {
      return type + ": " + sequence;
    }
  }
}
