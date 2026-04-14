package com.gava.task1.entity;

public record ArrayStatistics(int sum, int max, int min, double average) {
  public int getSum() {
    return sum;
  }
}
