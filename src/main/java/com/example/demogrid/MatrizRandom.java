package com.example.demogrid;

import java.util.Random;

public class MatrizRandom {


    public static void main(String[] args) {
        // Generar la matriz
        int[][] matriz = generarMatriz();
        // Imprimir la matriz
        imprimirMatriz(matriz);
        // Obtener los arreglos de la suma de las filas y la suma de las columnas
        int[] sumaFilas = obtenerSumaFilas(matriz);
        int[] sumaColumnas = obtenerSumaColumnas(matriz);
        // Imprimir los arreglos de la suma de las filas y la suma de las columnas
        System.out.println("Suma de las filas: ");
        imprimirArreglo(sumaFilas);
        System.out.println("Suma de las columnas: ");
        imprimirArreglo(sumaColumnas);
    }

    // Función para generar una matriz 4x4 con números aleatorios del 0 al 9
    public static int[][] generarMatriz() {
        int[][] matriz = new int[4][4];
        Random rand = new Random();
        // Generar los elementos de la matriz
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = rand.nextInt(10);
            }
        }
        return matriz;
    }

    // Función para obtener la suma de todas las filas de la matriz
    public static int[] obtenerSumaFilas(int[][] matriz) {
        int[] sumaFilas = new int[4];
        // Sumar los elementos de cada fila
        for (int i = 0; i < 4; i++) {
            int sumaFila = 0;
            for (int j = 0; j < 4; j++) {
                sumaFila += matriz[i][j];
            }
            sumaFilas[i] = sumaFila;
        }
        return sumaFilas;
    }

    // Función para obtener la suma de todas las columnas de la matriz
    public static int[] obtenerSumaColumnas(int[][] matriz) {
        int[] sumaColumnas = new int[4];
        // Sumar los elementos de cada columna
        for (int j = 0; j < 4; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < 4; i++) {
                sumaColumna += matriz[i][j];
            }
            sumaColumnas[j] = sumaColumna;
        }
        return sumaColumnas;
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

    // Función para imprimir un arreglo en la consola
    public static void imprimirArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
}
