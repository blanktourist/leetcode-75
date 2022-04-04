/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * Ex. 1
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * Ex. 2
 * Input: nums = [1]
 * Output: 1
 * 
 * Ex. 3
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 */
public class MaximumSubarray {
    public static int returnSumOfMaxSubarray(int[] arr) {
        int globalMax = 0;
        int rollingMax = 0;
        for (int i = 0; i < arr.length; i++) {
            rollingMax = Math.max(Math.max(rollingMax + arr[i], arr[i]), 0);
            globalMax = Math.max(globalMax, rollingMax);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int[] test1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] test2 = { 1 };
        int[] test3 = { 5, 4, -1, 7, 8 };

        System.out.println(returnSumOfMaxSubarray(test1));
        System.out.println(returnSumOfMaxSubarray(test2));
        System.out.println(returnSumOfMaxSubarray(test3));
    }
}
