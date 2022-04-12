package main.problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.models.Directions;
import main.utils.GridUtils;

public class PacificAtlanticWaterFlow {
    
    public static List<int[]> returnPacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            fill(heights, pacific, i, 0);
            fill(heights, atlantic, i, heights.length-1);
        }
        
        for (int j = 0; j < heights[0].length; j++) {
            fill(heights, pacific, 0, j);
            fill(heights, atlantic, heights.length-1, j);
        }

        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i,j});
                }
            }
        }
        return result;
    }

    public static void fill(int[][] heights, boolean[][] state, int i, int j) {
        state[i][j] = true;

        for (int[] dir : Directions.DIRECTIONS_ADJACENT_4) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (GridUtils.isInBounds(state, x, y)) {
                if (!state[x][y]) {
                    if (heights[x][y] >= heights[i][j]) {
                        fill(heights, state, x, y);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights1 = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        int[][] heights2 = {{2,1},{1,2}};

        System.out.println(Arrays.deepToString(returnPacificAtlantic(heights1).toArray()));
        System.out.println(Arrays.deepToString(returnPacificAtlantic(heights2).toArray()));
    }
}
