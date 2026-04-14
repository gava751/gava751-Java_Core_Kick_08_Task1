package com.gava.task1.factory;

import com.gava.task1.entity.CustomArray;
import com.gava.task1.observer.impl.ArrayObserverImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFactory {
  private static final Logger logger = LogManager.getLogger();
  private static long idCounter = 1;

  public CustomArray createArray(int[] elements) {
    logger.info("Factory is creating new array");
    CustomArray array = new CustomArray(elements, idCounter++);
    array.attach(new ArrayObserverImpl());

    new ArrayObserverImpl().update(new com.gava.task1.observer.ArrayEvent(array));
    logger.info("Factory is created new array");
    return array;
  }
}
