package com.gava.task1.service;

import com.gava.task1.entity.CustomArray;
import java.util.OptionalInt;

public interface MinMax {
  OptionalInt findMin(CustomArray array);

  OptionalInt findMax(CustomArray array);
}
