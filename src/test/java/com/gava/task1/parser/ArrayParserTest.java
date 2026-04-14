package com.gava.task1.parser;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class ArrayParserTest {
  private static final String INPUT_STRING = "1, 2; 3 - 4 5";
  private static final int[] EXPECTED_ARRAY = {1, 2, 3, 4, 5};

  private final ArrayParser arrayParser = new ArrayParser();

  @Test
  void testParseToArrayPositive() {
    int[] actual = arrayParser.parseToArray(INPUT_STRING);

    assertArrayEquals(EXPECTED_ARRAY, actual);
  }
}
