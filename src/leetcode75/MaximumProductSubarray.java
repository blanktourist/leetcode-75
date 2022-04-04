package leetcode75;

public class MaximumProductSubarray {
    
    /**
     * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
     * 
     * The test cases are generated so that the answer will fit in a 32-bit integer.
     * 
     * A subarray is a contiguous subsequence of the array.
     * 
     * Ex. 1
     * Input: nums = [2,3,-2,4]
     * Output: 6
     * Explanation: [2,3] has the largest product 6.
     * 
     * Ex. 2
     * Input: nums = [-2,0,-1]
     * Output: 0
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     * 
     * @param arr
     * @return
     */
    public static int returnMaximumProductSubarray(int[] arr) {
        int rollingMin = arr[0];
        int rollingMax = arr[0];
        int globalMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int tmpMax = Math.max(curr, Math.max(rollingMax * curr, rollingMin * curr));
            rollingMin = Math.min(curr, Math.min(rollingMax * curr, rollingMin * curr));
            rollingMax = tmpMax;

            globalMax = Math.max(globalMax, rollingMax);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] test1 = {2,3,-2,4};
        int[] test2 = {-2,0,-1};

        System.out.println(returnMaximumProductSubarray(test1));
        System.out.println(returnMaximumProductSubarray(test2));
    }
}
