package com.gava.task1.repository.impl;

import com.gava.task1.entity.CustomArray;
import com.gava.task1.repository.ArrayRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayRepositoryImpl implements ArrayRepository {
  private static final Logger logger = LogManager.getLogger();
  private static ArrayRepositoryImpl instance;
  private final List<CustomArray> arrays = new ArrayList<>();

  private ArrayRepositoryImpl() {}

  public static ArrayRepositoryImpl getInstance() {
    if (instance == null) {
      instance = new ArrayRepositoryImpl();
    }
    return instance;
  }

  @Override
  public void addArray(CustomArray customArray) {
    arrays.add(customArray);
    long id = customArray.getId();
    logger.info("{} add array", id);
  }

  @Override
  public void removeArray(CustomArray customArray) {
    arrays.remove(customArray);
    long id = customArray.getId();
    logger.info("{} remove array", id);
  }

  @Override
  public List<CustomArray> queryArrays(Predicate<CustomArray> predicate) {
    logger.debug("Query arrays");
    List<CustomArray> result = arrays.stream().filter(predicate).toList();
    int size=result.size();
    logger.info("Querry executed. Found {} arrays", size);
    return result;
  }

  @Override
  public void sortArrays(Comparator<CustomArray> comparator) {
    logger.info("Sort arrays");
    arrays.sort(comparator);
    logger.debug("Sorted successfully");
  }
}
