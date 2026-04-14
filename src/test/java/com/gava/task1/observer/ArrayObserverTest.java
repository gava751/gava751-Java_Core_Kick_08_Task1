package com.gava.task1.observer;

import com.gava.task1.entity.ArrayStatistics;
import com.gava.task1.entity.CustomArray;
import com.gava.task1.observer.impl.ArrayObserverImpl;
import com.gava.task1.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayObserverTest {
  @Test
  void ObserverUpdateWarehousse() {
    CustomArray customArray = new CustomArray(new int[] {1, 2, 3}, 200L);
    ArrayObserver arrayObserver = new ArrayObserverImpl();
    customArray.attach(arrayObserver);
    customArray.setElements(new int[] {10, 20, 30});
    ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
    ArrayStatistics actualStats = warehouse.get(200L);
    Assertions.assertAll(
        () -> Assertions.assertNotNull(actualStats),
        () -> Assertions.assertEquals(60, actualStats.getSum()));
  }
}
