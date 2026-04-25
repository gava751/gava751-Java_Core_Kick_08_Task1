package com.gava.task1.comparator;

import com.gava.task1.entity.CustomArray;
import java.util.Comparator;

public class FirstElementComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray firstArray, CustomArray secondArray) {
        int[] firstElements = firstArray.getElements();
        int[] secondElements = secondArray.getElements();

        int firstValue = firstElements.length > 0 ? firstElements[0] : 0;
        int secondValue = secondElements.length > 0 ? secondElements[0] : 0;

        return Integer.compare(firstValue, secondValue);
    }
}