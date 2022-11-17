package testing;

import org.junit.jupiter.api.Test;
import parse.Evaluation;
import parse.ExpressionEvaluationException;

import static org.junit.jupiter.api.Assertions.assertNull;

class EvaluationTest
{

  @Test
  void testBasicExpression() throws ExpressionEvaluationException
  {
    assertNull(Evaluation.evaluateExpression("(5+.12i)"));
  }
}
