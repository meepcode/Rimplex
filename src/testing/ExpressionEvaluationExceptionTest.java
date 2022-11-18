package testing;

import org.junit.jupiter.api.Test;
import parse.ExpressionEvaluationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionEvaluationExceptionTest
{

  @Test void testExpressionEvaluationException()
  {
    // the class is passing but the test is failing 
    assertThrows(ExpressionEvaluationException.class, () ->
    {
      // this just constructs the exception which is why the class is passing
      throw new ExpressionEvaluationException("goodbye");
    });
  }

}
