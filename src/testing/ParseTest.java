package testing;

import org.junit.jupiter.api.Test;

import parse.ExpressionEvaluationException;
import parse.Parse;

import static org.junit.jupiter.api.Assertions.*;

class ParseTest
{

  @Test void testBasicExpression() throws ExpressionEvaluationException
  {
    assertNull(Parse.evaluateExpression("(e+2i)"));
  }
}
