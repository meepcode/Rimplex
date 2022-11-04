<<<<<<< HEAD
package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilities.Calculate;
import utilities.ComplexNumber;

class CalculateTest
{
  private final ComplexNumber comp1 = new ComplexNumber(6.0, 4.0);
  private final ComplexNumber comp2 = new ComplexNumber(3.0, 2.0);
  
  @Test
  void calculateTest()
  {
    // subtract
    assertEquals(new ComplexNumber(3.0, 2.0), Calculate.subtract(comp1, comp2));
    // add
    assertEquals(new ComplexNumber(9.0, 6.0), Calculate.add(comp1, comp2));
    // divide  
    assertEquals(new ComplexNumber(2.0, 2.0), Calculate.divide(comp1, comp2));
    // multiply
    assertEquals(new ComplexNumber(18.0, 8.0), Calculate.multiply(comp1, comp2));
    
  }

}
=======
package testing;

import org.junit.jupiter.api.Test;

class CalculateTest
{

  @Test
  void addTest()
  {

  }

  @Test
  void subtractTest()
  {

  }

  @Test
  void multiplyTest()
  {

  }

  @Test
  void divideTest()
  {

  }
}
>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
