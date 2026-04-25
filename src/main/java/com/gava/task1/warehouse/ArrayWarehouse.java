package com.gava.task1.warehouse;

import com.gava.task1.entity.ArrayStatistics;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayWarehouse {
  public static ArrayWarehouse instance;
  private static Logger logger = LogManager.getLogger();
  private final Map<Long, ArrayStatistics> map = new HashMap<>();

  private ArrayWarehouse() {}

  public static ArrayWarehouse getInstance() {
    if (instance == null) {
      instance = new ArrayWarehouse();
    }
    return instance;
  }

  public void put(long id, ArrayStatistics statistics) {
    map.put(id, statistics);
    logger.info("Statistics saved/updated in Warehouse for array id: {}", id);
  }

  public ArrayStatistics get(long id) {
    logger.info("Fetching statistics from Warehouse for array id: {}", id);
    return map.get(id);
  }
}
