package main.problems.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    
    public static int returnLengthOfLongestIncreasingSubsequence(int[] arr) {
        int[] dpSolns = new int[arr.length];
        Arrays.fill(dpSolns, 1);
        int globalMax = 0;

        for (int i = 0; i< arr.length; i++ ) {
            
            for (int j = 0; j< i; j++) {
                if (arr[i] > arr[j]) {
                    dpSolns[i] = Math.max(dpSolns[i], dpSolns[j] + 1);
                }
            }
            globalMax = Math.max(globalMax, dpSolns[i]);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] test1 = {10,9,2,5,3,7,101,18};
        int[] test2 = {0,1,0,3,2,3};
        int[] test3 = {7,7,7,7,7,7,7};
        int[] test4 = {1,99,2,98,3,97,4,96,5,95,6,94,7,93};

        System.out.println(returnLengthOfLongestIncreasingSubsequence(test1));
        System.out.println(returnLengthOfLongestIncreasingSubsequence(test2));
        System.out.println(returnLengthOfLongestIncreasingSubsequence(test3));
        System.out.println(returnLengthOfLongestIncreasingSubsequence(test4));
    }
}
