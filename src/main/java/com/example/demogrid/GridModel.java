package com.example.demogrid;

// Model

public class GridModel {
    private final int[] values;

    public GridModel(int[] values) {
        this.values = values;
    }

    public int getValue(int index) {
        return values[index];
    }

    public void setValue(int index, int value) {
        values[index] = value;
    }

    public int getSum() {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}



