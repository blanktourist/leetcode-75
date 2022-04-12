package main.problems.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> returnSolutionToSpiralMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int u = 0;
        int d = rows - 1;
        int l = 0;
        int r = cols - 1;

        while (result.size() < rows * cols) {
            // L -> R
            for (int col = l; col <= r; col++) {
                result.add(matrix[u][col]);
            }

            // U -> D
            for (int row = u + 1; row <= d; row++) {
                result.add(matrix[row][r]);
            }

            // R -> L
            if (u != d) {
                for (int col = r - 1; col >= l; col--) {
                    result.add(matrix[d][col]);
                }
            }

            // D -> U
            if (l != r) {
                // Traverse upwards.
                for (int row = d - 1; row > u; row--) {
                    result.add(matrix[row][l]);
                }
            }

            // Push bounds in
            l++;
            u++;
            r--;
            d--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] test1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] test2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(returnSolutionToSpiralMatrix(test1));
        System.out.println(returnSolutionToSpiralMatrix(test2));
    }
}
