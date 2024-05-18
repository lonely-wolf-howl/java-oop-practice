package org.example.calculate;

public class PositiveNumber {
  private final int value;

  public PositiveNumber(int value) {
    validate(value);
    this.value = value;
  }

  private void validate(int value) {
    if (isNegativeNumber(value)) {
      throw new IllegalArgumentException("양수만 입력이 가능합니다.");
    }
  }

  private boolean isNegativeNumber(int value) {
    return value <= 0;
  }

  public int toInt() {
    return value;
  }
}
