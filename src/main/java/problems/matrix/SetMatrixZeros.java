package main.problems.matrix;

import java.util.Arrays;

public class SetMatrixZeros {
    public static void setMatrixZeros(int[][] matrix) {
        boolean firstColZero = false;
        
        // Use the 0th row and col to mark if the corresponding row/col should be 0
        for (int i = 0; i < matrix.length; i++) {

            // matrix[0][0] represents both. Define it to represent row. 
            // Use additional firstColZero boolean to track 0th col.
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
            
            for (int j = 0; j <matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Mark all grids besides 0th row and col
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Mark 0th row
        if (matrix[0][0] == 0) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // Mark 0th col
        if (firstColZero) {
            for (int i = 0; i <matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] test1 = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] test2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        setMatrixZeros(test1);
        setMatrixZeros(test2);

        System.out.println(Arrays.deepToString(test1));
        System.out.println(Arrays.deepToString(test2));
    }
}
