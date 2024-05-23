package rimplex.testing;

import org.junit.jupiter.api.Test;
import rimplex.parse.ExpressionEvaluationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * ExpressionEvaluationExceptionTests.
 * 
 * @author TeamD
 * @version 12/9/22 This work complies with the JMU Honor Code.
 */
class ExpressionEvaluationExceptionTest
{
  
  /**
   * Test the exception.
   */
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
