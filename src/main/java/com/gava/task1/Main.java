package com.gava.task1;

import com.gava.task1.entity.CustomArray;
import com.gava.task1.exception.ArrayException;
import com.gava.task1.factory.ArrayFactory;
import com.gava.task1.parser.ArrayParser;
import com.gava.task1.reader.ArrayReader;
import com.gava.task1.service.MinMax;
import com.gava.task1.service.Sort;
import com.gava.task1.service.SumAver;
import com.gava.task1.service.impl.MinMaxImpl;
import com.gava.task1.service.impl.SortImpl;
import com.gava.task1.service.impl.SumAverImpl;
import com.gava.task1.validator.ArrayValidator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
  private static final Logger logger = LogManager.getLogger(Main.class);

  public static void main(String[] args) {
    logger.info("Application started!");
    Main main = new Main();
    main.run();
  }

  public void run() {
    ArrayReader reader = new ArrayReader();
    ArrayValidator validator = new ArrayValidator();
    ArrayParser parser = new ArrayParser();
    ArrayFactory factory = new ArrayFactory();
    MinMax minMax = new MinMaxImpl();
    SumAver sumAver = new SumAverImpl();
    Sort sort = new SortImpl();

    String filePath = "data/Array.txt";
    try {
      List<String> lines = reader.readLines(filePath);
      for (String line : lines) {
        if (validator.isStringValid(line)) {
          int[] numbers = parser.parseToArray(line);
          CustomArray customArray = factory.createArray(numbers);
          OptionalDouble avg = sumAver.findAverage(customArray);
          OptionalInt min = minMax.findMin(customArray);
          OptionalInt max = minMax.findMax(customArray);
          if (avg.isPresent()) {
            double average = avg.getAsDouble();
            int minimum = min.getAsInt();
            int maximum = max.getAsInt();
            logger.info(
                "Average for line [{}] is {} and min: {} and max: {}",
                line,
                average,
                minimum,
                maximum);
          }

          sort.sortBubble(customArray);
          logger.info("Sorted array: {}", customArray.getElements());
        } else {
          logger.warn("Invalid line [{}]", line);
        }
      }
    } catch (ArrayException e) {
      logger.error("Critical Error", e);
    }
  }
}
