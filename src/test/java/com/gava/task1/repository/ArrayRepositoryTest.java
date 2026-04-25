package com.gava.task1.repository;

import com.gava.task1.entity.CustomArray;
import com.gava.task1.repository.impl.ArrayRepositoryImpl;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayRepositoryTest {
  @Test
  void AddAndQuery() {
    ArrayRepositoryImpl arrayRepository = ArrayRepositoryImpl.getInstance();
    CustomArray customArray = new CustomArray(new int[] {5, 5, 5}, 400L);
    arrayRepository.addArray(customArray);
    List<CustomArray> actualList = arrayRepository.queryArrays(array -> array.getId() == 400L);
    Assertions.assertAll(
        () -> Assertions.assertFalse(actualList.isEmpty()),
        () -> Assertions.assertEquals(400L, actualList.getFirst().getId()));
  }
}
