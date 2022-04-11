import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    
    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * 
     * Notice that the solution set must not contain duplicate triplets.
     * 
     * Ex. 1
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * 
     * Ex. 2
     * Input: nums = []
     * Output: []
     * 
     * Ex. 3
     * Input: nums = [0]
     * Output: []
     * 
     * @param arr
     * @return
     */
    public static List<List<Integer>> returnTriplets(int[] arr) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i< arr.length && arr[i] <= 0; i++) {
            if (i == 0 || arr[i - 1] != arr[i]) {
                twoSumII(arr, i, results);
            }
        }

        return results;
    }

    public static void twoSumII(int[] arr, int index, List<List<Integer>> results) {
        int l = index + 1;
        int r = arr.length - 1;
        while (l < r) {
            int sum = arr[index] + arr[l] + arr[r];
            if (sum < 0) {
                l ++;
            } else if (sum > 0) {
                r --;
            } else {
                results.add(Arrays.asList(arr[index], arr[l], arr[r]));
                l++;
                r--;
                while (l < r && arr[l] == arr[l - 1]) {
                    l++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] test1 = {-1,0,1,2,-1,-4};
        int[] test2 = {};
        int[] test3 = {0};

        System.out.println(returnTriplets(test1));
        System.out.println(returnTriplets(test2));
        System.out.println(returnTriplets(test3));
    }
}
