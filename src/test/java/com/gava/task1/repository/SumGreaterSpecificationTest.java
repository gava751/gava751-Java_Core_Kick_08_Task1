package com.gava.task1.repository;

import com.gava.task1.entity.ArrayStatistics;
import com.gava.task1.entity.CustomArray;
import com.gava.task1.repository.spec.SumGreaterSpecification;
import com.gava.task1.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SumGreaterSpecificationTest {
  private SumGreaterSpecification specification;
  private CustomArray customArray;

  @BeforeEach
  void setUp() {
    specification = new SumGreaterSpecification(50);
    customArray = new CustomArray(new int[] {}, 300L);
    ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
    ArrayStatistics stats = new ArrayStatistics(100, 0, 0, 0);
    warehouse.put(300L, stats);
  }

  @Test
  void SpecifyPositive() {
    boolean actual = specification.test(customArray);
    Assertions.assertTrue(actual);
  }
}
