package main.problems.dp;

public class CombinationSumIV {
    
    public static int numSolutions;

    public static int returnSolutionToCombinationSumIV(int[] arr, int target) {
        numSolutions = 0;

        dp(arr, target);

        return numSolutions;
    }


    public static void dp(int[] arr, int remaining) {
        if (remaining == 0) {
            numSolutions++;
        }

        for (int choice : arr) {
            if (choice <= remaining) {
                dp(arr, remaining - choice);
            }
        }
    }

    public static void main(String[] args) {
        int[] testArr1 = {1,2,3};
        int target1 = 4;
        int[] testArr2 = {9};
        int target2 = 3;

        System.out.println(returnSolutionToCombinationSumIV(testArr1, target1));
        System.out.println(returnSolutionToCombinationSumIV(testArr2, target2));
    }
}