package com.gava.task1.repository.spec;

import com.gava.task1.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.function.Predicate;

public class SizeEqualsSpecification implements Predicate<CustomArray> {
    private static final Logger logger = LogManager.getLogger();
    private final int expectedSize;

    public SizeEqualsSpecification(int expectedSize) {
        this.expectedSize = expectedSize;
        logger.debug("SizeEqualsSpecification created with expected size: " + expectedSize);
    }

    @Override
    public boolean test(CustomArray array) {
        int[] elements = array.getElements();
        int size = elements.length;
        return size == expectedSize;
    }
}