package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {

  @DisplayName("사칙연산을 수행한다.")
  @ParameterizedTest
  @MethodSource("formulaAndResult")
  void operationTest(int a, String operator, int b, int expected) {
    int result = Calculator.calculate(a, operator, b);

    assertThat(result).isEqualTo(expected);
  }

  private static Stream<Arguments> formulaAndResult() {
    return Stream.of(
        arguments(2, "+", 1, 3),
        arguments(2, "-", 1, 1),
        arguments(2, "*", 1, 2),
        arguments(2, "/", 1, 2));
  }
}
