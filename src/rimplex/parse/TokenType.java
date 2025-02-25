package rimplex.parse;

import java.util.regex.Pattern;

/**
 * The types of tokens allowed.
 * 
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
public enum TokenType
{
  INV("[Ii]nv", "INV", -1), SQRT("[Ss]qrt", "SQRT", -1), CONJ("[Cc]onj", "CONJ", 4),
  RE("[Rr]e", "RE", -1), IM("[Ii]m", "IM", -1), LOG("[Ll]og", "LOG", 3), NUMBER(
      "\\([+-]?((\\d{1,3}(,\\d{3})*|[0-9]*)(\\.\\d*)?|[.][0-9]+)((\\s*[+-]\\s*((\\d{1,3}(,\\d{3})"
          + "*|[0-9]*)(\\.\\d*)?|[.][0-9]+)|[.][0-9]+)𝘪|𝘪)?\\)", "NUMBER", -1), POLAR_NUMBER(
      "\\([+-]?((\\d{1,3}(,\\d{3})*|[0-9]*)(\\.\\d*)?|[.][0-9]+)\\(cos\\([+-]?(\\d{1,3}(,\\d{3})*"
          + "(\\.\\d*)?|[.][0-9]+)°?\\)\\s*[+]\\s*𝘪sin\\([+-]?((\\d{1,3}(,\\d{3})*|[0-9]*)(\\.\\d*)"
          + "?|[.][0-9]+)°?\\)\\)\\)",
      "POLAR_NUMBER", -1), OPEN_PAREN("[(]", "OPEN_PAREN", Integer.MAX_VALUE),
    CLOSE_PAREN("[)]", "CLOSE_PAREN", Integer.MAX_VALUE), ADD("[+]", "ADD", 0),
    SUBTRACT("[-]", "SUBTRACT", 0), MULTIPLY("[*]", "MULTIPLY", 1), DIVIDE("[/]", "DIVIDE", 1),
    EXP("\\^", "EXP", 2), POSITIVE(null, "POSITIVE", -1), NEGATIVE(null, "NEGATIVE", -1);

  private final Pattern pattern;
  private final String type;
  private final int precedence;

  //language=RegExp
  TokenType(final String regex, final String type, final int precedence)
  {
    this.precedence = precedence;
    if (regex != null)
    {
      this.pattern = Pattern.compile("^(" + regex + ")");
    }
    else
    {
      this.pattern = Pattern.compile("^\\b$");
    }
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

  /**
   * ToString.
   * @return type.
   */
  @Override public String toString()
  {
    return type;
  }

  /**
   * Returns true if this TokenType is a type of unary function or operator.
   *
   * @return true if this TokenType is a type of unary function or operator
   */
  public boolean isFunction()
  {
    return this == INV || this == CONJ || this == SQRT || this == IM || this == RE
        || this == POSITIVE || this == NEGATIVE;
  }

  /**
   * Returns true iff this TokenType represents a number of any sort.
   *
   * @return true iff this TokenType represents a number of any sort
   */
  public boolean isNumber()
  {
    return this == NUMBER || this == POLAR_NUMBER;
  }

  /**
   * Accessor method for the precedence.
   *
   * @return the precedence
   */
  public int getPrecedence()
  {
    return precedence;
  }
}
