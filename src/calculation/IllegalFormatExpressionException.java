package calculation;

/**
 * Throws when an expression is formatted improperly.
 */
public class IllegalFormatExpressionException extends RuntimeException
{
  /**
   * Throws the exception with the message.
   *
   * @param message
   *     the message to throw with
   */
  public IllegalFormatExpressionException(final String message)
  {
    super(message);
  }

  /**
   * Throws the exception.
   */
  @SuppressWarnings("unused")
  public IllegalFormatExpressionException()
  {
    super();
  }
}
