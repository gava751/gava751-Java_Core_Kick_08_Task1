package com.gava.task1.reader;

import com.gava.task1.exception.ArrayException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ArrayReader {

  public List<String> readLines(String filePath) throws ArrayException {
    Path path = Paths.get(filePath);
    if (!Files.exists(path)) {
      throw new ArrayException("File not found" + filePath);
    }
    try {
      return Files.readAllLines(path);
    } catch (IOException e) {
      throw new ArrayException("Error reading file", e);
    }
  }
}
