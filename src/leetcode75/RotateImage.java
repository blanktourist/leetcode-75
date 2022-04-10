import java.util.Arrays;

public class RotateImage {

    // arr is assumed to be a square matrix
    public static void rotate(int[][] arr) {
        int n = arr.length;

        for (int i = 0; i < (n+ 1)/2; i++) {
            for (int j = 0; j<n/2;j++) {
                int tmp = arr[n - 1 - j][i];
                arr[n-1-j][i] = arr[n - 1 - i][n - 1 - j];
                arr[n-1-i][n-1- j] = arr[j][n - 1 -i];
                arr[j][n - 1 - i] = arr[i][j];
                arr[i][j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] test1 = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(test1);
        int[][] test2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(test2);

        System.out.println(Arrays.deepToString(test1));
        System.out.println(Arrays.deepToString(test2));
    }
}
