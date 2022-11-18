package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculation.Calculate;
import parse.ExpressionEvaluationException;

class ExpressionEvaluationExceptionTest
{

  @Test
  void testExpressionEvaluationException()
  {
    // the class is passing but the test is failing 
    assertThrows(ExpressionEvaluationException.class, () -> {
      // this just constructs the exception which is why the class is passing
      new ExpressionEvaluationException("goodbye");
    });
  }

}
