package utilities;

import java.util.Deque;

/**
 * Represents a component of an expression.
 *
 * @author TeamD
 * @version 2022-11-04
 */
public interface Evaluatable
{
  /**
   * Evaluates the current node given the current expression.
   *
   * @param expression the current expression
   * @return the ComplexNumber based on this nodes value and the state of the expression.
   */
  ComplexNumber evaluate(final Deque<Evaluatable> expression);
}
