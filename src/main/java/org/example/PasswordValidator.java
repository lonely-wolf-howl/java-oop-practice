package org.example;

public class PasswordValidator {
  public void validateOne(String password) {
    int length = password.length();

    if (length < 8 || length > 12) {
      throw new IllegalArgumentException("Password must be between 8 and 12 characters.");
    }
  }

  public void validateTwo(PasswordGeneratePolicy passwordGeneratePolicy) {
    String password = passwordGeneratePolicy.generatePassword();
    int length = password.length();

    if (length < 8 || length > 12) {
      throw new IllegalArgumentException("Password must be between 8 and 12 characters.");
    }
  }
}
