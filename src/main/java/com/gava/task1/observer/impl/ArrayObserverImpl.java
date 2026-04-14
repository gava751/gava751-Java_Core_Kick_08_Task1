package com.gava.task1.observer.impl;

import com.gava.task1.entity.ArrayStatistics;
import com.gava.task1.entity.CustomArray;
import com.gava.task1.observer.ArrayEvent;
import com.gava.task1.observer.ArrayObserver;
import com.gava.task1.service.MinMax;
import com.gava.task1.service.SumAver;
import com.gava.task1.service.impl.MinMaxImpl;
import com.gava.task1.service.impl.SumAverImpl;
import com.gava.task1.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayObserverImpl implements ArrayObserver {
  public static final Logger logger = LogManager.getLogger();

  @Override
  public void update(ArrayEvent event) {
    CustomArray source = event.getSource();
    long id = source.getId();
    logger.info("Observer triggered for array id: {}. Recalculating statistics...", id);
    MinMax minMax = new MinMaxImpl();
    SumAver sumAver = new SumAverImpl();

    int sum = sumAver.findSum(source).orElse(0);
    int min = minMax.findMin(source).orElse(0);
    int max = minMax.findMax(source).orElse(0);
    double avg = sumAver.findAverage(source).orElse(0);

    ArrayStatistics stats = new ArrayStatistics(sum, max, min, avg);
    ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
    warehouse.put(source.getId(), stats);

    logger.info("Statistics successfully added to the array id: {}.", id);
  }
}
