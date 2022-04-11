package Utils;

public class GridUtils {
    public static boolean isInBounds(Object[][] array, int i, int j) {
        return 0 <= i && i < array.length && 0 <= j && j < array[0].length; 
    }

    public static boolean isInBounds(char[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length; 
    }
}
