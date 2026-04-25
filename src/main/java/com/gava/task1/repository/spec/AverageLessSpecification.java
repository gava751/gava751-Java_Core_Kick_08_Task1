package com.gava.task1.repository.spec;

import com.gava.task1.entity.CustomArray;
import com.gava.task1.warehouse.ArrayWarehouse;
import com.gava.task1.entity.ArrayStatistics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.function.Predicate;

public class AverageLessSpecification implements Predicate<CustomArray> {
    private static final Logger logger = LogManager.getLogger();
    private final double threshold;

    public AverageLessSpecification(double threshold) {
        this.threshold = threshold;
        logger.debug("AverageLessSpecification created with threshold: " + threshold);
    }

    @Override
    public boolean test(CustomArray array) {
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        long id = array.getId();
        ArrayStatistics stats = warehouse.get(id);
        double average = stats.average();

        return average < threshold;
    }
}