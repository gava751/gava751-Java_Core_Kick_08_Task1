package com.gava.task1.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayValidatorTest {
  private static final String VALID_LINE = "1, 2, 3, 4";
  private static final String INVALID_LINE = "1, 2, x3, 4";

  private final ArrayValidator arrayValidator = new ArrayValidator();

  @Test
  void testisValidPositive() {
    boolean isValid = arrayValidator.isStringValid(VALID_LINE);

    Assertions.assertTrue(isValid);
  }

  @Test
  void testIsValidNegative() {
    boolean isValid = arrayValidator.isStringValid(INVALID_LINE);
    Assertions.assertFalse(isValid);
  }
}
