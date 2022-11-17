package testing;

import calculation.ComplexNumber;
import org.junit.jupiter.api.Test;
import parse.ExpressionEvaluationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static parse.Evaluation.evaluateExpression;

class EvaluationTest
{

  @Test void testComplexNumber() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(5.0, 4.0), evaluateExpression("(5+4i)"));
  }

  @Test void testComplexNumberNegativeImaginary() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(5.0, -4.0), evaluateExpression("(5-4i)"));
  }

  @Test void testRealNumber() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(0.123, 0.0), evaluateExpression("(0.123)"));
  }

  @Test void testImaginaryNumber() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(0.0, 13098.098), evaluateExpression("(13098.098i)"));
  }

  @Test void testPolarComplexNumber() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(-1.0, 0.0),
        evaluateExpression("(1(cos(" + Math.PI + ") + isin(" + Math.PI + ")))"));
  }

  @Test void testAdd() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(5.2, 3.6), evaluateExpression("(3.6+1.8i)+(1.6+1.8i)"));
  }

  @Test void testAddNegativeNumber() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(2.0, 0.0), evaluateExpression("(3.6+1.8i)+(-1.6-1.8i)"));
  }

  @Test void testAddMultiple() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(-5.1, 2.13),
        evaluateExpression("(5.0+4i)+(6.3-2i)+(-16.4+0.13i)"));
  }

  @Test void testSubtract() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(5.6, 2.3), evaluateExpression("(9.5+4.2i)-(3.9+1.9i)"));
  }

  @Test void testMultipleSubtract() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(15.1, 5.87),
        evaluateExpression("(5.0+4i)-(6.3-2i)-(-16.4+0.13i)"));
  }
}
