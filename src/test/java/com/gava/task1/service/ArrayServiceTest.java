package com.gava.task1.service;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.gava.task1.entity.CustomArray;
import com.gava.task1.service.impl.MinMaxImpl;
import com.gava.task1.service.impl.SortImpl;
import com.gava.task1.service.impl.SumAverImpl;
import java.util.OptionalInt;
import org.junit.jupiter.api.Test;

class ArrayServiceTest {
  private static final int[] INPUT_DATA = {10, 222, 12, 40, 32};
  private static final int[] EXPECTED_SORTED = {10, 12, 32, 40, 222};
  private static final int EXPECTED_SUM = 316;
  private static final int EXPECTED_MIN = 10;

  private final MinMax minMax = new MinMaxImpl();
  private final Sort sort = new SortImpl();
  private final SumAver sumAver = new SumAverImpl();

  @Test
  void testFindMinPositive() {
    CustomArray customArray = new CustomArray(INPUT_DATA, 1);

    OptionalInt min = minMax.findMin(customArray);

    assertAll(() -> assertTrue(min.isPresent()), () -> assertEquals(EXPECTED_MIN, min.getAsInt()));
  }

  @Test
  void testFindSumPositive() {
    CustomArray customArray = new CustomArray(INPUT_DATA, 1);

    OptionalInt sum = sumAver.findSum(customArray);

    assertAll(() -> assertTrue(sum.isPresent()), () -> assertEquals(EXPECTED_SUM, sum.getAsInt()));
  }

  @Test
  void testSortBubblePositive() {
    CustomArray customArray = new CustomArray(INPUT_DATA, 1);

    sort.sortBubble(customArray);

    assertArrayEquals(EXPECTED_SORTED, customArray.getElements());
  }
}
