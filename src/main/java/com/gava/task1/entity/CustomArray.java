package com.gava.task1.entity;

import com.gava.task1.observer.ArrayEvent;
import com.gava.task1.observer.ArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArray {
    private static final Logger logger = LogManager.getLogger();
    private final long id;
    private final List<ArrayObserver> observers = new ArrayList<>();
    private int[] elements;

    public CustomArray(int[] data, long id) {
        elements = data;
        this.id = id;
        logger.info("Custom array created with id: {}", id);
    }

    public int[] getElements() {
        return elements.clone();
    }

    public void setElements(int[] data) {
        elements = data.clone();
        logger.info("Custom array changed with id: {}. New data:{}", id, Arrays.toString(elements));
    }

    public long getId() {
        return id;
    }

    public int getLength() {
        return elements.length;
    }

    public void attach(ArrayObserver observer) {
        if (observer != null) {
            observers.add(observer);
            logger.debug("Observer attached to array id: {}", id);
        }
    }

    private void notifyObservers() {
        ArrayEvent event = new ArrayEvent(this);
        logger.debug("Notifying observers for array id: {}", id);
        for (ArrayObserver observer : observers) {
            observer.update(event);
        }
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        CustomArray other = (CustomArray) obj;
        return Arrays.equals(elements, other.elements);
    }

    @Override
    public String toString() {
        return "CustomArray [elements=" + Arrays.toString(elements) + "]";
    }
}
