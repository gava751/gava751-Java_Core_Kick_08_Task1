package com.gava.task1.parser;

public class ArrayParser {
  private static final String DELIMITER_REGEX = "[,;\\s\\-]+";

  public int[] parseToArray(String line) {
    String trimmedLine = line.strip();
    String[] tokens = trimmedLine.split(DELIMITER_REGEX);
    int[] array = new int[tokens.length];
    for (int i = 0; i < tokens.length; i++) {
      array[i] = Integer.parseInt(tokens[i]);
    }
    return array;
  }
}
