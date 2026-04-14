package com.gava.task1.warehouse;

import com.gava.task1.entity.ArrayStatistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayWarehouseTest {
  @Test
  void SingletonInstance() {
    ArrayWarehouse firstInstance = ArrayWarehouse.getInstance();

    ArrayWarehouse secondInstance = ArrayWarehouse.getInstance();

    Assertions.assertEquals(firstInstance, secondInstance);
  }

  @Test
  void PutAndGetPositive() {
    ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
    ArrayStatistics expectedStatus = new ArrayStatistics(50, 20, 5, 12.5);
    warehouse.put(100L, expectedStatus);
    ArrayStatistics actualStatus = warehouse.get(100L);
    Assertions.assertAll(
        () -> Assertions.assertNotNull(actualStatus),
        () -> Assertions.assertEquals(expectedStatus, actualStatus));
  }
}
