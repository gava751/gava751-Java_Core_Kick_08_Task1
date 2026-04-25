package com.gava.task1.repository.spec;

import com.gava.task1.entity.CustomArray;
import com.gava.task1.warehouse.ArrayWarehouse;
import java.util.function.Predicate;

public class SumGreaterSpecification implements Predicate<CustomArray> {
  private final int treshold;

  public SumGreaterSpecification(int treshold) {
    this.treshold = treshold;
  }

  @Override
  public boolean test(CustomArray customArray) {
    ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
    int currentSum = warehouse.get(customArray.getId()).getSum();
    return currentSum > treshold;
  }
  //TODO more
}
