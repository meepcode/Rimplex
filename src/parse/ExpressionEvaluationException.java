package parse;

/**
 * Throws when an expression is formatted improperly.
 */
public class ExpressionEvaluationException extends Exception
{
  /**
   * Throws the exception with the message.
   *
   * @param message
   *     the message to throw with
   */
  public ExpressionEvaluationException(final String message)
  {
    super(message);
  }
}
