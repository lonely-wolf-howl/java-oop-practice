package org.example;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.example.calculate.PositiveNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositiveNumberTest {

  @ParameterizedTest
  @ValueSource(ints = { 0, -1 })
  void createTest(int value) {
    assertThatCode(() -> new PositiveNumber(value))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("양수만 입력이 가능합니다.");
  }
}
