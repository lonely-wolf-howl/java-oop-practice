package org.example;

import java.util.List;

import org.example.calculate.ArithmeticOperatorInterface;
import org.example.calculate.AdditionOperator;
import org.example.calculate.DivisionOperator;
import org.example.calculate.MultiplicationOperator;
import org.example.calculate.PositiveNumber;
import org.example.calculate.SubtractionOperator;

public class Calculator {
  private static final List<ArithmeticOperatorInterface> arithmeticOperators = List.of(
      new AdditionOperator(),
      new SubtractionOperator(),
      new MultiplicationOperator(),
      new DivisionOperator());

  public static int calculate(PositiveNumber a, String operator, PositiveNumber b) {
    return arithmeticOperators.stream()
        .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
        .map(arithmeticOperator -> arithmeticOperator.calculate(a, b))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
  }
}
