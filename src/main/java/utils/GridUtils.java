package main.utils;

public class GridUtils {
    
    public static boolean isInBounds(Object[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length; 
    }

    public static boolean isInBounds(char[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length; 
    }

    public static boolean isInBounds(boolean[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length; 
    }
}
