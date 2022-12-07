package parse;

/**
 * Throws when an expression is formatted improperly.
 * 
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
public class ExpressionEvaluationException extends Exception
{
  /**
   * Throws the exception with the message.
   *
   * @param message
   *          the message to throw with
   */
  public ExpressionEvaluationException(final String message)
  {
    super(message);
  }
}
