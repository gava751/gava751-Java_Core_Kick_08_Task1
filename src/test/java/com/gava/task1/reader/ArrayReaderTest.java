package com.gava.task1.reader;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.gava.task1.exception.ArrayException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ArrayReaderTest {
  private static final String VALID_PATH = "data/Array.txt";
  private static final String INVALID_PATH = "data/Invalid.txt";

  private final ArrayReader reader = new ArrayReader();

  @Test
  void testReadLinesPositive() throws ArrayException {
    List<String> lines = reader.readLines(VALID_PATH);

    assertAll(() -> assertNotNull(lines), () -> assertFalse(lines.isEmpty()));
  }

  @Test
  void testReadLinesException() {
    assertThrows(ArrayException.class, () -> reader.readLines(INVALID_PATH));
  }
}
