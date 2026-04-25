package com.gava.task1.comparator;

import com.gava.task1.entity.CustomArray;
import com.gava.task1.warehouse.ArrayWarehouse;
import com.gava.task1.entity.ArrayStatistics;
import java.util.Comparator;

public class ArraySumComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray firstArray, CustomArray secondArray) {
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();

        long firstId = firstArray.getId();
        ArrayStatistics firstStats = warehouse.get(firstId);
        int firstSum = firstStats.sum();

        long secondId = secondArray.getId();
        ArrayStatistics secondStats = warehouse.get(secondId);
        int secondSum = secondStats.sum();

        return Integer.compare(firstSum, secondSum);
    }
}