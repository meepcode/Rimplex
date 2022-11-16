package testing;

import org.junit.jupiter.api.Test;
<<<<<<< HEAD

import parse.ExpressionEvaluationException;
import parse.Parse;

import static org.junit.jupiter.api.Assertions.*;

class ParseTest
{

  @Test void testBasicExpression() throws ExpressionEvaluationException
  {
    assertNull(Parse.evaluateExpression("(e+2i)"));
=======
import parse.Evaluation;
import parse.ExpressionEvaluationException;

import static org.junit.jupiter.api.Assertions.assertNull;

class ParseTest
{

  @Test
  void testBasicExpression() throws ExpressionEvaluationException
  {
    assertNull(Evaluation.evaluateExpression("((.1 + 2i) * (3i))"));
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  }
}
