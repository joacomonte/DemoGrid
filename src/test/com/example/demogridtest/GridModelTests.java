package com.example.demogridtest;


import com.example.demogrid.GridModel;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridModelTests {

    private GridModel gridModel;

    @BeforeEach
    public void setUp() {
        gridModel = new GridModel();
    }

    @Test
    public void testSetValue() {
        gridModel.setValue(0, 0, 5);
        assertEquals(5, gridModel.getRowSum(0));
        assertEquals(5, gridModel.getColumnSum(0));
    }

    @Test
    public void testGetRowSum() {
        gridModel.setValue(0, 0, 2);
        gridModel.setValue(0, 1, 3);
        assertEquals(5, gridModel.getRowSum(0));
    }

    @Test
    public void testGetColumnSum() {
        gridModel.setValue(0, 0, 4);
        gridModel.setValue(1, 0, 6);
        assertEquals(10, gridModel.getColumnSum(0));
    }

    @Test
    public void testGenerateRandomResults() {
        gridModel.generateRandomResults();
        assertNotNull(gridModel.expectedNumbers);
    }

    @Test
    public void testGetRowDesireNumber() {
        gridModel.generateRandomResults();
        int[] rowDesireNumbers = gridModel.expectedNumbers[0];
        assertNotNull(rowDesireNumbers);
        assertEquals(4, rowDesireNumbers.length);
    }

    @Test
    public void testGetColumnDesireNumber() {
        gridModel.generateRandomResults();
        int[] columnDesireNumbers = gridModel.expectedNumbers[1];
        assertNotNull(columnDesireNumbers);
        assertEquals(4, columnDesireNumbers.length);
    }

    @Test
    public void testIsRowSumAchieved() {
        assertTrue(gridModel.isRowSumAchieved(10, 10));
        assertFalse(gridModel.isRowSumAchieved(5, 10));
    }

    @Test
    public void testIsColSumAchieved() {
        assertTrue(gridModel.isColSumAchieved(15, 15));
        assertFalse(gridModel.isColSumAchieved(8, 15));
    }

}