package com.example.demogrid;

import java.util.Random;

public class GridModel {

    private final int gridSize = 4;
    private final int[][] grid;

    public int[][] expectedNumbers;

    public GridModel() {
        grid = new int[gridSize][gridSize];
        expectedNumbers = new int[gridSize /2][gridSize];
    }

    public void setValue(int row, int col, int value) {
        grid[row][col] = value;
    }

    public int getRowSum(int row) {
        int sum = 0;
        for (int col = 0; col < gridSize; col++) {
            sum += grid[row][col];
        }
        return sum;
    }

    public int getColumnSum(int col) {
        int sum = 0;
        for (int row = 0; row < gridSize; row++) {
            sum += grid[row][col];
        }
        return sum;
    }

    // generates and sets the result row and col sums
    public void generateRandomResults(){
        int[][] randomMatrix = generateRandomMatrix();
        expectedNumbers[0]= getRowsSumFromMatrix(randomMatrix);
        expectedNumbers[1]= getColsSumFromMatrix(randomMatrix);
    }

    public int getRowDesireNumber(int row) {
        return expectedNumbers[0][row];
    }

    public int getColumnDesireNumber(int col) {
        return expectedNumbers[1][col];
    }

    public boolean isRowSumAchieved(int sum, int desiredSum) {
        return (sum == desiredSum);
    }

    public boolean isColSumAchieved(int sum, int desiredSum) {
        return (sum == desiredSum);
    }


    //AUXILIARES

    // Generates random matrix
    public static int[][] generateRandomMatrix() {
        int[][] matriz = new int[4][4];
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = rand.nextInt(10);
            }
        }
        return matriz;
    }

    // Returns array of sum of rows
    public static int[] getRowsSumFromMatrix(int[][] matriz) {
        int[] sumaFilas = new int[4];
        for (int i = 0; i < 4; i++) {
            int sumaFila = 0;
            for (int j = 0; j < 4; j++) {
                sumaFila += matriz[i][j];
            }
            sumaFilas[i] = sumaFila;
        }
        return sumaFilas;
    }

    // Returns array of sum of columns
    public static int[] getColsSumFromMatrix(int[][] matriz) {
        int[] sumaColumnas = new int[4];
        for (int j = 0; j < 4; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < 4; i++) {
                sumaColumna += matriz[i][j];
            }
            sumaColumnas[j] = sumaColumna;
        }
        return sumaColumnas;
    }


    // Función para imprimir un arreglo en la consola
    public static void imprimirArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    // Función para imprimir una matriz en la consola
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }



}