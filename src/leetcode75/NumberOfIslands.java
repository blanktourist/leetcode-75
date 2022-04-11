import Utils.GridUtils;
import models.Directions;

public class NumberOfIslands {
    public static int countNumberOfIslands(char[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];

        int count = 0;
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j <grid[0].length; j++) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    count++;
                    fill(seen, grid, i, j);
                }
            }
        }

        return count;
    }

    public static void fill(boolean[][] seen, char[][] grid, int x, int y) {
        if (!GridUtils.isInBounds(grid, x, y)) {
            return;
        }
        else if (seen[x][y] || grid[x][y] != '1') {
            return;
        }
        else {
            seen[x][y] = true;
            for (int[] dir : Directions.DIRECTIONS_ADJACENT_4) {
                fill(seen, grid, x + dir[0], y + dir[1]);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        System.out.println(countNumberOfIslands(grid1));
        System.out.println(countNumberOfIslands(grid2));
    }
}
