package com.gava.task1.observer;

import com.gava.task1.entity.CustomArray;
import java.util.EventObject;

public class ArrayEvent extends EventObject {
  public ArrayEvent(CustomArray source) {
    super(source);
  }

  @Override
  public CustomArray getSource() {
    return (CustomArray) super.getSource();
  }
}
