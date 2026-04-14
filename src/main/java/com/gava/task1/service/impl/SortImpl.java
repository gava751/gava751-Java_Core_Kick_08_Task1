package com.gava.task1.service.impl;

import com.gava.task1.entity.CustomArray;
import com.gava.task1.service.Sort;

public class SortImpl implements Sort {
  @Override
  public void sortBubble(CustomArray customArray) {
    int[] elements = customArray.getElements();
    for (int i = 0; i < elements.length - 1; i++) {
      for (int j = 0; j < elements.length - i - 1; j++) {
        if (elements[j] > elements[j + 1]) {
          int temp = elements[j];
          elements[j] = elements[j + 1];
          elements[j + 1] = temp;
        }
      }
    }
    customArray.setElements(elements);
  }

  @Override
  public void sortInsertion(CustomArray customArray) {
    int[] elements = customArray.getElements();
    for (int i = 0; i < elements.length; i++) {
      int key = elements[i];
      int j = i - 1;
      while (j >= 0 && elements[j] > key) {
        elements[j + 1] = elements[j];
        j = j - 1;
      }
      elements[j + 1] = key;
    }
    customArray.setElements(elements);
  }
}
