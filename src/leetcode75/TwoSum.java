package leetcode75;

import java.util.*;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * You can return the answer in any order.
 * 
 * Ex. 1
 * Input: nums = [2,7,11,15], target=9
 * Output: [0,1]
 * 
 * Ex. 2
 * Input: nums = [3,2,4], target=6
 * Output: [1,2]
 * 
 * Ex. 3
 * Input: nums = [3,3], target=6
 * Output: [0,1]
 */
public class TwoSum {
    public static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {};
    }

    public static int[] solution2(int[] nums, int target) {
        // Map of Key: (value seen) -> Value: (index of nums the value was seen at)
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i< nums.length; i ++) {
            int want = target - nums[i];
            if (seen.containsKey(want)) {
                return new int[]{seen.get(want), i};
            }
            seen.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{2,7,11,15};
        int target1 = 9;
        int[] test2 = new int[]{3,2,4};
        int target2 = 6;
        int[] test3 = new int[]{3,3};
        int target3 = 6;

        System.out.println(Arrays.toString(solution1(test1, target1)));
        System.out.println(Arrays.toString(solution1(test2, target2)));
        System.out.println(Arrays.toString(solution1(test3, target3)));

        System.out.println();

        System.out.println(Arrays.toString(solution2(test1, target1)));
        System.out.println(Arrays.toString(solution2(test2, target2)));
        System.out.println(Arrays.toString(solution2(test3, target3)));
    }
}
