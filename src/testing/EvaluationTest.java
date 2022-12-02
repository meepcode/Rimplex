package testing;

import calculation.Calculate;
import calculation.ComplexNumber;
import org.junit.jupiter.api.Test;
import parse.ExpressionEvaluationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static parse.Evaluation.evaluateExpression;

/**
 * Tests the Evaluation class.
 */
class EvaluationTest
{

  @Test void testComplexNumber() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(15.0, 4.0), evaluateExpression("(15+4i)"));
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

  @Test void testMixedAddSubtract() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(68.45, -68.69),
        evaluateExpression("(5.0+4i)+(6.3-2i)-(-16.4+0.13i)-(0.6+34.56i)+(41.35-36i)"));
  }

  @Test void testMultiply() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(38.24, 4.42), evaluateExpression("(5.4+3.2i)*(5.6-2.5i)"));
  }

  @Test void testMultiplyNoSymbol() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(38.24, 4.42), evaluateExpression("(5.4+3.2i)(5.6-2.5i)"));
  }

  @Test void testMultiplyMultiple() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(-1303.471, 599.167),
        evaluateExpression("(5.4+3.2i)*(5.6-2.5i)*(-0.1+7.9i)*(2.5+4i)"));
  }

  @Test void testDivide() throws ExpressionEvaluationException
  {
    assertEquals(Calculate.divide(new ComplexNumber(5.4, 3.2), new ComplexNumber(5.6, -2.5)),
        evaluateExpression("(5.4+3.2i)/(5.6-2.5i)"));
  }

  @Test void testMultipleDivide() throws ExpressionEvaluationException
  {
    assertEquals(Calculate.divide(
        Calculate.divide(new ComplexNumber(5.4, 3.2), new ComplexNumber(5.6, -2.5)),
        new ComplexNumber(5.5, 4.7)), evaluateExpression("(5.4+3.2i)/(5.6-2.5i)/(5.5+4.7i)"));
  }

  @Test void testMixedMultiplyDivide() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(100.02523318266418505716, 36.43315767083222547194894),
        evaluateExpression("(3.67-13.9i)*(5.4+3.2i)/(5.6-2.5i)*(5.5+4.7i)"));
  }

  @Test void testAddInFrontOfMultiply() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(45.0, 4.0), evaluateExpression("(5+4i)+(6-2i)*(6+2i)"));
  }

  @Test void testAddInFrontOfDivide() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(5.8, 3.4), evaluateExpression("(5+4i)+(6-2i)/(6+2i)"));
  }

  @Test void testSubtractInFrontOfMultiply() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(-35.0, +4.0), evaluateExpression("(5+4i)-(6-2i)*(6+2i)"));
  }

  @Test void testSubtractInFrontOfDivide() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(4.2, 4.6), evaluateExpression("(5+4i)-(6-2i)/(6+2i)"));
  }

  @Test void testMultiplyInFrontOfAdd() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(44.0, 16.0), evaluateExpression("(5+4i)*(6-2i)+(6+2i)"));
  }

  @Test void testDivideInFrontOfAdd() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(6.55, 2.85), evaluateExpression("(5+4i)/(6-2i)+(6+2i)"));
  }

  @Test void testMultiplyInFrontOfSubtract() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(32.0, 12.0), evaluateExpression("(5+4i)*(6-2i)-(6+2i)"));
  }

  @Test void testDivideInFrontOfSubtract() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(-5.45, -1.15), evaluateExpression("(5+4i)/(6-2i)-(6+2i)"));
  }

  @Test void testArithmeticExpressionsNoParens() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(-7.45, -39.75),
        evaluateExpression("(5+4i)/(6-2i)-(6+2i)*(3+5i)+(-4.6i)"));
  }

  @Test void testParens() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(0.0, 6.5), evaluateExpression("((6.5i))"));
  }

  @Test void testParensAddInFrontOfMultiply() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(62.0, 34.0), evaluateExpression("((5+4i)+(6-2i))*(6+2i)"));
  }

  @Test void testParensAddInFrontOfDivide() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(1.75, -0.25), evaluateExpression("((5+4i)+(6-2i))/(6+2i)"));
  }

  @Test void testParensSubtractInFrontOfMultiply() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(-18.0, +34.0), evaluateExpression("((5+4i)-(6-2i))*(6+2i)"));
  }

  @Test void testParensSubtractInFrontOfDivide() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(0.15, 0.95), evaluateExpression("((5+4i)-(6-2i))/(6+2i)"));
  }

  @Test void testParensMultiplyInFrontOfAdd() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(44.0, 16.0), evaluateExpression("((5+4i)*(6-2i))+(6+2i)"));
  }

  @Test void testParensDivideInFrontOfAdd() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(6.55, 2.85), evaluateExpression("((5+4i)/(6-2i))+(6+2i)"));
  }

  @Test void testParensMultiplyInFrontOfSubtract() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(32.0, 12.0), evaluateExpression("((5+4i)*(6-2i))-(6+2i)"));
  }

  @Test void testParensDivideInFrontOfSubtract() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(-5.45, -1.15), evaluateExpression("((5+4i)/(6-2i))-(6+2i)"));
  }

  @Test void testAddInFrontOfParensMultiply() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(45.0, 4.0), evaluateExpression("(5+4i)+((6-2i)*(6+2i))"));
  }

  @Test void testAddInFrontOfParensDivide() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(5.8, 3.4), evaluateExpression("(5+4i)+((6-2i)/(6+2i))"));
  }

  @Test void testSubtractInFrontOfParensMultiply() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(-35.0, +4.0), evaluateExpression("(5+4i)-((6-2i)*(6+2i))"));
  }

  @Test void testSubtractInFrontOfParensDivide() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(4.2, 4.6), evaluateExpression("(5+4i)-((6-2i)/(6+2i))"));
  }

  @Test void testMultiplyInFrontOfParensAdd() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(60.0, 48.0), evaluateExpression("(5+4i)*((6-2i)+(6+2i))"));
  }

  @Test void testDivideInFrontOfParensAdd() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(5.0 * (1.0 / 12.0), 4.0 * (1.0 / 12.0)),
        evaluateExpression("(5+4i)/((6-2i)+(6+2i))"));
  }

  @Test void testMultiplyInFrontOfParensSubtract() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(16.0, -20.0), evaluateExpression("(5+4i)*((6-2i)-(6+2i))"));
  }

  @Test void testDivideInFrontOfParensSubtract() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(-1.0, +1.25), evaluateExpression("(5+4i)/((6-2i)-(6+2i))"));
  }

  @Test void testArithmeticExpressionParens() throws ExpressionEvaluationException
  {
    assertEquals(
        new ComplexNumber(-0.48082332245228172829982784733915955635412648987309620793783689,
            -1.2677279611668751940245152914836172754724790923885946510380899),
        evaluateExpression("(5+4i)/((6-2i)-(6+2i)*(9)) + (4-6i)/((3.6)-(4.7i) + (9i))"));
  }

  @Test void testLog() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(
            1.499999999999999999999999999999999999999999999999999999999999999999999999999999,
            1.133090035456798452406920736429166702542965366930948896046504136985150238),
        evaluateExpression("(2)log(2+2i)"));
  }

  @Test void testLogOnAdditionExpressions() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(
            1.499999999999999999999999999999999999999999999999999999999999999999999999999999,
            1.133090035456798452406920736429166702542965366930948896046504136985150238),
        evaluateExpression("((2)+(0))Log((2)+(0+.5i)+(1.5i))"));
  }

  @Test void testInverse() throws ExpressionEvaluationException
  {
    assertEquals(new ComplexNumber(0.25, -0.25), evaluateExpression("Inv(2+2i)"));
  }
}
