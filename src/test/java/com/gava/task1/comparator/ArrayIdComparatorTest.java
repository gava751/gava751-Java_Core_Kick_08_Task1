package com.gava.task1.comparator;

import com.gava.task1.entity.CustomArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayIdComparatorTest {
  private final ArrayIdComparator comparator = new ArrayIdComparator();

  @Test
  void ComparePositive() {
    CustomArray smallCustomArray = new CustomArray(new int[] {1, 2}, 1L);
    CustomArray largeCustomArray = new CustomArray(new int[] {1, 2, 3, 4, 5}, 2L);

    int actual = comparator.compare(smallCustomArray, largeCustomArray);

    Assertions.assertTrue(actual < 0);
  }
}
