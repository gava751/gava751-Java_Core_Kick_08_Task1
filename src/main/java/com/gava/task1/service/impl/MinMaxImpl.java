package com.gava.task1.service.impl;

import com.gava.task1.entity.CustomArray;
import com.gava.task1.service.MinMax;
import java.util.OptionalInt;

public class MinMaxImpl implements MinMax {
  @Override
  public OptionalInt findMin(CustomArray customArray) {
    return findExtremium(customArray, true);
  }

  @Override
  public OptionalInt findMax(CustomArray customArray) {
    return findExtremium(customArray, false);
  }

  private OptionalInt findExtremium(CustomArray customArray, boolean isMin) {
    int[] elements = customArray.getElements();
    if (elements == null || elements.length == 0) return OptionalInt.empty();
    int result = elements[0];
    for (int element : elements) {
      boolean condition = isMin ? (element < result) : (element > result);
      if (condition) {
        result = element;
      }
    }
    return OptionalInt.of(result);
  }
}
