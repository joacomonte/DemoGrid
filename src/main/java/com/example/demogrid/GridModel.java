package com.example.demogrid;

import java.util.Random;

public class GridModel {

    private final int numberOfCells = 4;
    private final int[][] grid;

    public int[][] expectedNumbers;

    public GridModel() {
        grid = new int[numberOfCells][numberOfCells];
        expectedNumbers = new int[numberOfCells/2][numberOfCells];
    }

    public void setValue(int row, int col, int value) {
        grid[row][col] = value;
    }

    private int[][] rowAndColumNumberGenerator(){
        //initialize list for the desired numbers, it's a 2x4 "grid"
        // expectedNumbers[0][ROW]   and   expectedNumbers[1][COLUMN]
        int[][] expectedNumbers = new int[numberOfCells/2][numberOfCells];
        //TODO Generate the numbers, must follow some math rules
        //TODO esta logica va a ser medio complicada
        return expectedNumbers;
    }

    public void setExpectedNumbers(int[][] expectedNumbers){
        //TODO using rowAndColumNumberGenerator we must make this method to set the numbers on the non-editable cells
        this.expectedNumbers = expectedNumbers;
    }

//    public int getValue(int row, int col) {
//        return grid[row][col];
//    }

    public void generateDesiredNumbers() {
        //TODO just using this next line to test
        expectedNumbers = new int[][]{{5, 5, 5, 5}, {7, 3, 3, 7}};
    }




    public int getRowSum(int row) {
        int sum = 0;
        for (int col = 0; col < numberOfCells; col++) {
            sum += grid[row][col];
        }
        return sum;
    }

    public int getColumnSum(int col) {
        int sum = 0;
        for (int row = 0; row < numberOfCells; row++) {
            sum += grid[row][col];
        }
        return sum;
    }


    // Función para generar una matriz 4x4 con números aleatorios del 0 al 9
    public static int[][] generarMatrizRandom() {
        int[][] matriz = new int[4][4];
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = rand.nextInt(10);
            }
        }
        return matriz;
    }

    // Retorns array of sum of rows
    public static int[] obtenerSumaFilas(int[][] matriz) {
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

    // Retorns array of sum of columns
    public static int[] obtenerSumaColumnas(int[][] matriz) {
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

    public void generateRandomResults(){
        int[][] matrizRandom = generarMatrizRandom();
        expectedNumbers[0]=obtenerSumaFilas(matrizRandom);
        expectedNumbers[1]=obtenerSumaColumnas(matrizRandom);
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