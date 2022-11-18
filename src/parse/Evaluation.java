package parse;

import calculation.Calculate;
import calculation.ComplexNumber;
import calculation.PolarComplexNumber;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
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
    System.out.println("\n============\nEVALUATING NEW EXPRESSION: " + expressionStr);

    Token[] tokens = tokenize(expressionStr);

    for (Token token : tokens)
    {
      System.out.println(token);
    }

    Deque<Token> expression = order(tokens);

    System.out.println("\n After ordering: ");

    for (Token token : expression)
    {
      System.out.println(token);
    }

    return evaluate(expression);
  }

  private static ComplexNumber evaluate(final Deque<Token> expression)
      throws ExpressionEvaluationException
  {
    if (expression.isEmpty())
    {
      throw new ExpressionEvaluationException("Illegal expression");
    }

    Token token = expression.pop();
    TokenType type = token.type;
    ComplexNumber result;

    try
    {
      if (type == TokenType.INV)
      {
        result = Calculate.invert(evaluate(expression));
      }
      else if (type == TokenType.SQRT)
      {
        result = Calculate.squareRoot(evaluate(expression));
      }
      else if (type == TokenType.CONJ)
      {
        result = Calculate.conjugate(evaluate(expression));
      }
      else if (type == TokenType.RE)
      {
        result = new ComplexNumber(evaluate(expression).getReal(), 0.0);
      }
      else if (type == TokenType.IM)
      {
        result = new ComplexNumber(0.0, evaluate(expression).getImaginary());
      }
      else if (type == TokenType.LOG)
      {
        ComplexNumber operand = evaluate(expression);
        ComplexNumber base = evaluate(expression);

        if (Math.abs(base.getImaginary() - 0.0) > ComplexNumber.EPSILON)
        {
          throw new ExpressionEvaluationException("Base must be real number for log");
        }
        
        if (base.getReal() == 0 && base.getImaginary() == 0)
        {
          throw new ExpressionEvaluationException("Base cannot be 0");
        }

        result = Calculate.log(base.getReal(), operand);
      }
      else if (type == TokenType.NUMBER)
      {
        String[] parts = token.sequence.substring(1, token.sequence.length() - 1).split("(?=[+-])");
        double realPart = 0.0;
        double imaginaryPart = 0.0;

        if (parts.length == 1)
        {
          if (parts[0].charAt(parts[0].length() - 1) == 'i')
          {
            parts[0] = parts[0].replaceAll('i' + "", "");
            imaginaryPart = Double.parseDouble(parts[0]);
          }
          else
          {
            realPart = Double.parseDouble(parts[0]);
          }
        }
        else
        {
          parts[1] = parts[1].replaceAll('i' + "", "");
          imaginaryPart = Double.parseDouble(parts[1]);
          realPart = Double.parseDouble(parts[0]);
        }

        result = new ComplexNumber(realPart, imaginaryPart);
      }
      else if (type == TokenType.POLAR_NUMBER)
      {
        String sequence = token.sequence.substring(1, token.sequence.length() - 1);

        String[] parts = sequence.split("(\\(cos\\()|(°?\\)[+]isin\\()|(°?\\))");

        if (!Objects.equals(parts[1], parts[2]))
        {
          throw new ExpressionEvaluationException(
              String.format("Theta must be equal in cos(%s) and isin(%s)", parts[1], parts[2]));
        }

        result = Calculate.convertPolarToRectangular(
            new PolarComplexNumber(Double.parseDouble(parts[1]), Double.parseDouble(parts[1]),
                Double.parseDouble(parts[0])));
      }
      else if (type == TokenType.ADD)
      {
        result = Calculate.add(evaluate(expression), evaluate(expression));
      }
      else if (type == TokenType.SUBTRACT)
      {
        ComplexNumber right = evaluate(expression);
        ComplexNumber left = evaluate(expression);

        result = Calculate.subtract(left, right);
      }
      else if (type == TokenType.MULTIPLY)
      {
        result = Calculate.multiply(evaluate(expression), evaluate(expression));
      }
      else if (type == TokenType.DIVIDE)
      {
        ComplexNumber right = evaluate(expression);
        ComplexNumber left = evaluate(expression);

        result = Calculate.divide(left, right);
      }
      else if (type == TokenType.EXP)
      {
        ComplexNumber power = evaluate(expression);
        ComplexNumber base = evaluate(expression);

        if (Math.abs(base.getImaginary() - 0.0) > ComplexNumber.EPSILON)
        {
          throw new ExpressionEvaluationException("Power must be real number for exponentiation");
        }

        result = Calculate.exponent(base.getReal(), power);
      }
      else if (type == TokenType.POSITIVE)
      {
        result = evaluate(expression);
      }
      else if (type == TokenType.NEGATIVE)
      {
        result = Calculate.multiply(evaluate(expression), new ComplexNumber(-1.0, 0.0));
      }
      else
      {
        throw new ExpressionEvaluationException("type == " + type);
      }
    }
    catch (ArithmeticException exc)
    {
      throw new ExpressionEvaluationException(exc.getMessage());
    }

    return result;
  }

  private static Deque<Token> order(final Token[] tokens) throws ExpressionEvaluationException
  {
    Deque<Token> output = new ArrayDeque<>();
    Deque<Token> operators = new ArrayDeque<>();

    for (Token token : tokens)
    {
      if (token.type == TokenType.NUMBER)
      {
        output.push(token);
      }
      else if (token.type.isFunction())
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
            throw new ExpressionEvaluationException("Unmatched close parenthesis");
          }
          output.push(operators.pop());
        }

        operators.pop();

        if (!operators.isEmpty() && operators.peek().type.isFunction())
        {
          output.push(operators.pop());
        }
      }
      else
      {
        while (!operators.isEmpty()
            && token.type.getPrecedence() <= operators.peek().type.getPrecedence()
            && operators.peek().type != TokenType.OPEN_PAREN)
        {
          output.push(operators.pop());
        }

        operators.push(token);
      }
    }

    while (!operators.isEmpty())
    {
      Token token = operators.pop();

      if (token.type == TokenType.OPEN_PAREN)
      {
        throw new ExpressionEvaluationException("Unmatched open parenthesis");
      }

      output.push(token);
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
    if (tokens.get(0).type == TokenType.ADD)
    {
      tokens.set(0, new Token(TokenType.POSITIVE, tokens.get(0).sequence));
    }
    else if (tokens.get(0).type == TokenType.SUBTRACT)
    {
      tokens.set(0, new Token(TokenType.NEGATIVE, tokens.get(0).sequence));
    }

    // preprocessing to allow for certain syntax that can't be parsed by the shunting yard algorithm
    for (int i = 0; i < tokens.size() - 1; i++)
    {
      TokenType curType = tokens.get(i).type;

      // Parse + or - to be a positive or negative number
      if (curType != TokenType.NUMBER && curType != TokenType.POLAR_NUMBER
          && curType != TokenType.CLOSE_PAREN && (tokens.get(i + 1).type == TokenType.ADD
          || tokens.get(i + 1).type == TokenType.SUBTRACT))
      {
        if (tokens.get(i + 1).type == TokenType.ADD)
        {
          tokens.set(i + 1, new Token(TokenType.POSITIVE, tokens.get(i + 1).sequence));
        }
        else if (tokens.get(i + 1).type == TokenType.SUBTRACT)
        {
          tokens.set(i + 1, new Token(TokenType.NEGATIVE, tokens.get(i + 1).sequence));
        }
      }

      if ((curType == TokenType.CLOSE_PAREN || curType.isNumber()) && (
          tokens.get(i + 1).type == TokenType.OPEN_PAREN || tokens.get(i + 1).type.isNumber()))
      {
        tokens.add(i + 1, new Token(TokenType.MULTIPLY, "*"));
      }

      if (curType.isFunction() && tokens.get(i + 1).type == TokenType.NUMBER)
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
