package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PasswordValidatorTest {
  @DisplayName("No exception is thrown for password between 8 and 12 characters long.")
  @Test
  void validatePasswordTestOne() {
    // given
    PasswordValidator passwordValidator = new PasswordValidator();
    String password = "abcdefgh";

    // when, then
    assertThatCode(() -> passwordValidator.validateOne(password))
        .doesNotThrowAnyException();
  }

  @DisplayName("IllegalArgumentException is thrown for password under 8 or over 12 characters.")
  @ParameterizedTest
  @ValueSource(strings = { "a", "abcdefghijklm" })
  void validatePasswordTestTwo(String value) {
    // given
    PasswordValidator passwordValidator = new PasswordValidator();

    // when, then
    assertThatCode(() -> passwordValidator.validateOne(value))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Password must be between 8 and 12 characters.");
  }

  @DisplayName("No exception is thrown for password between 8 and 12 characters long.")
  @Test
  void validatePasswordTestThree() {
    // given
    PasswordValidator passwordValidator = new PasswordValidator();

    // when, then
    assertThatCode(() -> passwordValidator.validateTwo(new CorrectPasswordGenerator()))
        .doesNotThrowAnyException();
  }

  @DisplayName("IllegalArgumentException is thrown for password under 8 or over 12 characters.")
  @Test
  void validatePasswordTestFour() {
    // given
    PasswordValidator passwordValidator = new PasswordValidator();

    // when, then
    assertThatCode(() -> passwordValidator.validateTwo(new WrongPasswordGenerator()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Password must be between 8 and 12 characters.");
  }
}