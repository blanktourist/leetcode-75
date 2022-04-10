package Utils;

public class GridUtils {
    public static boolean isInBounds(Object[][] array, int i, int j) {
        return 0 <= i && i < array.length && 0 <= j && j < array[0].length; 
    }
}
