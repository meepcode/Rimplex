package testing;

 

import calculation.Calculate;

import calculation.ComplexNumber;

import org.junit.jupiter.api.Test;

import parse.ExpressionEvaluationException;

 

import static org.junit.jupiter.api.Assertions.assertEquals;

import static parse.Evaluation.evaluateExpression;

 

class EvaluationTest

{

<<<<<<< HEAD
 

  @Test

  void testComplexNumber() throws ExpressionEvaluationException

=======
  @Test
  void testComplexNumber() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(15.0, 4.0), evaluateExpression("(15+4i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testComplexNumberNegativeImaginary() throws ExpressionEvaluationException

=======
  @Test
  void testComplexNumberNegativeImaginary() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(5.0, -4.0), evaluateExpression("(5-4i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testRealNumber() throws ExpressionEvaluationException

=======
  @Test
  void testRealNumber() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(0.123, 0.0), evaluateExpression("(0.123)"));

  }

<<<<<<< HEAD
 

  @Test

  void testImaginaryNumber() throws ExpressionEvaluationException

=======
  @Test
  void testImaginaryNumber() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(0.0, 13098.098), evaluateExpression("(13098.098i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testPolarComplexNumber() throws ExpressionEvaluationException

=======
  @Test
  void testPolarComplexNumber() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(-1.0, 0.0),

        evaluateExpression("(1(cos(" + Math.PI + ") + isin(" + Math.PI + ")))"));

  }

<<<<<<< HEAD
 

  @Test

  void testAdd() throws ExpressionEvaluationException

=======
  @Test
  void testAdd() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(5.2, 3.6), evaluateExpression("(3.6+1.8i)+(1.6+1.8i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testAddNegativeNumber() throws ExpressionEvaluationException

=======
  @Test
  void testAddNegativeNumber() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(2.0, 0.0), evaluateExpression("(3.6+1.8i)+(-1.6-1.8i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testAddMultiple() throws ExpressionEvaluationException

=======
  @Test
  void testAddMultiple() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(-5.1, 2.13),

        evaluateExpression("(5.0+4i)+(6.3-2i)+(-16.4+0.13i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testSubtract() throws ExpressionEvaluationException

=======
  @Test
  void testSubtract() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(5.6, 2.3), evaluateExpression("(9.5+4.2i)-(3.9+1.9i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testMultipleSubtract() throws ExpressionEvaluationException

=======
  @Test
  void testMultipleSubtract() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(15.1, 5.87),

        evaluateExpression("(5.0+4i)-(6.3-2i)-(-16.4+0.13i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testMixedAddSubtract() throws ExpressionEvaluationException

=======
  @Test
  void testMixedAddSubtract() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(68.45, -68.69),

        evaluateExpression("(5.0+4i)+(6.3-2i)-(-16.4+0.13i)-(0.6+34.56i)+(41.35-36i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testMultiply() throws ExpressionEvaluationException

=======
  @Test
  void testMultiply() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(38.24, 4.42), evaluateExpression("(5.4+3.2i)*(5.6-2.5i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testMultiplyNoSymbol() throws ExpressionEvaluationException

=======
  @Test
  void testMultiplyNoSymbol() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(38.24, 4.42), evaluateExpression("(5.4+3.2i)(5.6-2.5i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testMultiplyMultiple() throws ExpressionEvaluationException

=======
  @Test
  void testMultiplyMultiple() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(-1303.471, 599.167),

        evaluateExpression("(5.4+3.2i)*(5.6-2.5i)*(-0.1+7.9i)*(2.5+4i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testDivide() throws ExpressionEvaluationException

=======
  @Test
  void testDivide() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(Calculate.divide(new ComplexNumber(5.4, 3.2), new ComplexNumber(5.6, -2.5)),

        evaluateExpression("(5.4+3.2i)/(5.6-2.5i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testMultipleDivide() throws ExpressionEvaluationException

=======
  @Test
  void testMultipleDivide() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(Calculate.divide(

        Calculate.divide(new ComplexNumber(5.4, 3.2), new ComplexNumber(5.6, -2.5)),

        new ComplexNumber(5.5, 4.7)), evaluateExpression("(5.4+3.2i)/(5.6-2.5i)/(5.5+4.7i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testMixedMultiplyDivide() throws ExpressionEvaluationException

=======
  @Test
  void testMixedMultiplyDivide() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(100.02523318266418505716, 36.43315767083222547194894),

        evaluateExpression("(3.67-13.9i)*(5.4+3.2i)/(5.6-2.5i)*(5.5+4.7i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testAddInFrontOfMultiply() throws ExpressionEvaluationException

=======
  @Test
  void testAddInFrontOfMultiply() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(45.0, 4.0), evaluateExpression("(5+4i)+(6-2i)*(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testAddInFrontOfDivide() throws ExpressionEvaluationException

=======
  @Test
  void testAddInFrontOfDivide() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(5.8, 3.4), evaluateExpression("(5+4i)+(6-2i)/(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testSubtractInFrontOfMultiply() throws ExpressionEvaluationException

=======
  @Test
  void testSubtractInFrontOfMultiply() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(-35.0, +4.0), evaluateExpression("(5+4i)-(6-2i)*(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testSubtractInFrontOfDivide() throws ExpressionEvaluationException

=======
  @Test
  void testSubtractInFrontOfDivide() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(4.2, 4.6), evaluateExpression("(5+4i)-(6-2i)/(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testMultiplyInFrontOfAdd() throws ExpressionEvaluationException

=======
  @Test
  void testMultiplyInFrontOfAdd() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(44.0, 16.0), evaluateExpression("(5+4i)*(6-2i)+(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testDivideInFrontOfAdd() throws ExpressionEvaluationException

=======
  @Test
  void testDivideInFrontOfAdd() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(6.55, 2.85), evaluateExpression("(5+4i)/(6-2i)+(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testMultiplyInFrontOfSubtract() throws ExpressionEvaluationException

=======
  @Test
  void testMultiplyInFrontOfSubtract() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(32.0, 12.0), evaluateExpression("(5+4i)*(6-2i)-(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testDivideInFrontOfSubtract() throws ExpressionEvaluationException

=======
  @Test
  void testDivideInFrontOfSubtract() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(-5.45, -1.15), evaluateExpression("(5+4i)/(6-2i)-(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testArithmeticExpressionsNoParens() throws ExpressionEvaluationException

=======
  @Test
  void testArithmeticExpressionsNoParens() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(-7.45, -39.75),

        evaluateExpression("(5+4i)/(6-2i)-(6+2i)*(3+5i)+(-4.6i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testParens() throws ExpressionEvaluationException

=======
  @Test
  void testParens() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(0.0, 6.5), evaluateExpression("((6.5i))"));

  }

<<<<<<< HEAD
 

  @Test

  void testParensAddInFrontOfMultiply() throws ExpressionEvaluationException

=======
  @Test
  void testParensAddInFrontOfMultiply() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(62.0, 34.0), evaluateExpression("((5+4i)+(6-2i))*(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testParensAddInFrontOfDivide() throws ExpressionEvaluationException

=======
  @Test
  void testParensAddInFrontOfDivide() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(1.75, -0.25), evaluateExpression("((5+4i)+(6-2i))/(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testParensSubtractInFrontOfMultiply() throws ExpressionEvaluationException

=======
  @Test
  void testParensSubtractInFrontOfMultiply() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(-18.0, +34.0), evaluateExpression("((5+4i)-(6-2i))*(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testParensSubtractInFrontOfDivide() throws ExpressionEvaluationException

=======
  @Test
  void testParensSubtractInFrontOfDivide() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(0.15, 0.95), evaluateExpression("((5+4i)-(6-2i))/(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testParensMultiplyInFrontOfAdd() throws ExpressionEvaluationException

=======
  @Test
  void testParensMultiplyInFrontOfAdd() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(44.0, 16.0), evaluateExpression("((5+4i)*(6-2i))+(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testParensDivideInFrontOfAdd() throws ExpressionEvaluationException

=======
  @Test
  void testParensDivideInFrontOfAdd() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(6.55, 2.85), evaluateExpression("((5+4i)/(6-2i))+(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testParensMultiplyInFrontOfSubtract() throws ExpressionEvaluationException

=======
  @Test
  void testParensMultiplyInFrontOfSubtract() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(32.0, 12.0), evaluateExpression("((5+4i)*(6-2i))-(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testParensDivideInFrontOfSubtract() throws ExpressionEvaluationException

=======
  @Test
  void testParensDivideInFrontOfSubtract() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(-5.45, -1.15), evaluateExpression("((5+4i)/(6-2i))-(6+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testAddInFrontOfParensMultiply() throws ExpressionEvaluationException

=======
  @Test
  void testAddInFrontOfParensMultiply() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(45.0, 4.0), evaluateExpression("(5+4i)+((6-2i)*(6+2i))"));

  }

<<<<<<< HEAD
 

  @Test

  void testAddInFrontOfParensDivide() throws ExpressionEvaluationException

=======
  @Test
  void testAddInFrontOfParensDivide() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(5.8, 3.4), evaluateExpression("(5+4i)+((6-2i)/(6+2i))"));

  }

<<<<<<< HEAD
 

  @Test

  void testSubtractInFrontOfParensMultiply() throws ExpressionEvaluationException

=======
  @Test
  void testSubtractInFrontOfParensMultiply() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(-35.0, +4.0), evaluateExpression("(5+4i)-((6-2i)*(6+2i))"));

  }

<<<<<<< HEAD
 

  @Test

  void testSubtractInFrontOfParensDivide() throws ExpressionEvaluationException

=======
  @Test
  void testSubtractInFrontOfParensDivide() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(4.2, 4.6), evaluateExpression("(5+4i)-((6-2i)/(6+2i))"));

  }

<<<<<<< HEAD
 

  @Test

  void testMultiplyInFrontOfParensAdd() throws ExpressionEvaluationException

=======
  @Test
  void testMultiplyInFrontOfParensAdd() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(60.0, 48.0), evaluateExpression("(5+4i)*((6-2i)+(6+2i))"));

  }

<<<<<<< HEAD
 

  @Test

  void testDivideInFrontOfParensAdd() throws ExpressionEvaluationException

=======
  @Test
  void testDivideInFrontOfParensAdd() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(5.0 * (1.0 / 12.0), 4.0 * (1.0 / 12.0)),

        evaluateExpression("(5+4i)/((6-2i)+(6+2i))"));

  }

<<<<<<< HEAD
 

  @Test

  void testMultiplyInFrontOfParensSubtract() throws ExpressionEvaluationException

=======
  @Test
  void testMultiplyInFrontOfParensSubtract() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(16.0, -20.0), evaluateExpression("(5+4i)*((6-2i)-(6+2i))"));

  }

<<<<<<< HEAD
 

  @Test

  void testDivideInFrontOfParensSubtract() throws ExpressionEvaluationException

=======
  @Test
  void testDivideInFrontOfParensSubtract() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(new ComplexNumber(-1.0, +1.25), evaluateExpression("(5+4i)/((6-2i)-(6+2i))"));

  }

<<<<<<< HEAD
 

  @Test

  void testArithmeticExpressionParens() throws ExpressionEvaluationException

=======
  @Test
  void testArithmeticExpressionParens() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

    assertEquals(

        new ComplexNumber(-0.48082332245228172829982784733915955635412648987309620793783689,

            -1.2677279611668751940245152914836172754724790923885946510380899),

        evaluateExpression("(5+4i)/((6-2i)-(6+2i)*(9)) + (4-6i)/((3.6)-(4.7i) + (9i))"));

  }

<<<<<<< HEAD
 

  @Test

  void testLog() throws ExpressionEvaluationException

=======
  @Test
  void testLog() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {
<<<<<<< HEAD

    assertEquals(

        new ComplexNumber(

=======
    assertEquals(
        new ComplexNumber(
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
            1.499999999999999999999999999999999999999999999999999999999999999999999999999999,

            1.133090035456798452406920736429166702542965366930948896046504136985150238),

        evaluateExpression("(2)log(2+2i)"));

  }

<<<<<<< HEAD
 

  @Test

  void testLogOnAdditionExpressions() throws ExpressionEvaluationException

=======
  @Test
  void testLogOnAdditionExpressions() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {
<<<<<<< HEAD

    assertEquals(

        new ComplexNumber(

            1.499999999999999999999999999999999999999999999999999999999999999999999999999999,

            1.133090035456798452406920736429166702542965366930948896046504136985150238),

=======
    assertEquals(
        new ComplexNumber(
            1.499999999999999999999999999999999999999999999999999999999999999999999999999999,
            1.133090035456798452406920736429166702542965366930948896046504136985150238),
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
        evaluateExpression("((2)+(0))Log((2)+(0+.5i)+(1.5i))"));
<<<<<<< HEAD
=======
  }

  @Test
  void testLogBeforeAddition() throws ExpressionEvaluationException
  {
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD

  }

<<<<<<< HEAD
 

  @Test

  void testLogBeforeAddition() throws ExpressionEvaluationException

=======
  @Test
  void testInverse() throws ExpressionEvaluationException
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  {

 

  }

 

  @Test

  void testInverse() throws ExpressionEvaluationException

  {

    assertEquals(new ComplexNumber(0.25, -0.25), evaluateExpression("Inv(2+2i)"));

  }
<<<<<<< HEAD

}
=======
}
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
