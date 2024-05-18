package org.example.calculate;

public class SubtractionOperator implements ArithmeticOperatorInterface {
  @Override
  public boolean supports(String operator) {
    return "-".equals(operator);
  }

  @Override
  public int calculate(PositiveNumber a, PositiveNumber b) {
    return a.toInt() - b.toInt();
  }
}
