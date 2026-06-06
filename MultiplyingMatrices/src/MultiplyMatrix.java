/**
Name: Ramos, Alfred Francis P.
Student #: 24-13090
Section: 3011
Date: April 8, 2025
*/

import java.util.Scanner;

public class MultiplyMatrix {

    // Function to accept matrix input
    public static int[][] inputMatrix(int rows, int cols, Scanner scanner, String matrixName) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements for " + matrixName + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrixName + "[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Function to multiply two matrices
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // print matrix
    public static void printMatrix(int[][] matrix, String name) {
        System.out.println(name + ":");
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept matrix dimensions
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        // Input matrices
        int[][] matrixA = inputMatrix(rows, cols, scanner, "Matrix A");
        int[][] matrixB = inputMatrix(rows, cols, scanner, "Matrix B");

        // Display matrices
        printMatrix(matrixA, "Matrix A");
        printMatrix(matrixB, "Matrix B");

        // For multiplication, columns of A must equal rows of B
        System.out.print("Enter number of columns for Matrix B (for multiplication): ");
        int colsB = scanner.nextInt();

        // Input matrix B again for multiplication
        int[][] matrixB2 = inputMatrix(cols, colsB, scanner, "Matrix B (for multiplication)");

        int[][] product = multiplyMatrices(matrixA, matrixB2);
        printMatrix(product, "Product of Matrices");

        scanner.close();
    }
}
