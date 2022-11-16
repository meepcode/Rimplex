package parse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseTest
{

  @Test void testBasicExpression() throws ExpressionEvaluationException
  {
    assertNull(Parse.evaluateExpression("(e+2i)"));
  }
}
