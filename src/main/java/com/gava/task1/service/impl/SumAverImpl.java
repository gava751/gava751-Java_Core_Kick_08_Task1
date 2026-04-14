package com.gava.task1.service.impl;

import com.gava.task1.entity.CustomArray;
import com.gava.task1.service.SumAver;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class SumAverImpl implements SumAver {
  @Override
  public OptionalInt findSum(CustomArray customArray) {
    int[] elements = customArray.getElements();
    if (elements != null && elements.length > 0) {
      int sum = 0;
      for (int element : elements) {
        sum += element;
      }
      return OptionalInt.of(sum);
    } else {
      return OptionalInt.empty();
    }
  }

  @Override
  public OptionalDouble findAverage(CustomArray customArray) {
    OptionalInt sum = findSum(customArray);
    if (sum.isPresent()) {
      return OptionalDouble.of((double) sum.getAsInt() / customArray.getLength());
    } else {
      return OptionalDouble.empty();
    }
  }
}
