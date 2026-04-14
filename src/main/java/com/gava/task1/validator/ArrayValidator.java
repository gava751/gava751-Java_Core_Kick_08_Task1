package com.gava.task1.validator;

public class ArrayValidator {
  private static final String ARRAY_PATTERN = "^[0-9\\s,;\\-]+$";

  public boolean isStringValid(String line) {
    return line != null && line.matches(ARRAY_PATTERN);
  }
}
