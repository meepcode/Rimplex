package calculation.parse;

import java.util.regex.Pattern;

/**
 * The types of tokens allowed.
 */
public enum TokenType
{
  UNARY_FUNCTION("[Ii]nv|[Ii]m|[Rr]e|[Cc]onj|[Ss]qrt", "UNARY_FUNCTION"), BINARY_FUNCTION("^[Ll]og",
    "BINARY_FUNCTION"), OPEN_PAREN("[(]", "OPEN_PAREN"), CLOSE_PAREN("[)]",
    "CLOSE_PAREN"), PLUS_MINUS("[+-]", "PLUS_MINUS"), MULT_DIV("[*/]", "MULT_DIV"), NUMBER(
    "e|([0-9]+([.][0-9]*)?|[.][0-9]+)((\\s*[+-]\\s*([0-9]+([.][0-9]*)?|[.][0-9]+))i|i)?", "NUMBER");

  private final Pattern pattern;
  private final String type;

  TokenType(final String regex, final String type)
  {
    this.pattern = Pattern.compile("^(" + regex + ")");
    this.type = type;
  }

  /**
   * Accessor method for the pattern.
   *
   * @return the pattern
   */
  public Pattern getPattern()
  {
    return pattern;
  }

  @Override public String toString()
  {
    return type;
  }
}
