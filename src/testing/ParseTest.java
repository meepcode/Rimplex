package testing;

import org.junit.jupiter.api.Test;
import parse.Evaluation;
import parse.ExpressionEvaluationException;

import static org.junit.jupiter.api.Assertions.assertNull;

class ParseTest
{

  @Test
  void testBasicExpression() throws ExpressionEvaluationException
  {
    assertNull(Evaluation.evaluateExpression("((.1 + 2i) * (3i))"));
  }
}
