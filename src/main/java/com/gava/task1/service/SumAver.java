package com.gava.task1.service;

import com.gava.task1.entity.CustomArray;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface SumAver {
  OptionalInt findSum(CustomArray array);

  OptionalDouble findAverage(CustomArray array);
}
