package com.gava.task1.repository;

import com.gava.task1.entity.CustomArray;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface ArrayRepository {
  void addArray(CustomArray customArray);

  void removeArray(CustomArray customArray);

  List<CustomArray> queryArrays(Predicate<CustomArray> predicate);

  void sortArrays(Comparator<CustomArray> comparator);
}
