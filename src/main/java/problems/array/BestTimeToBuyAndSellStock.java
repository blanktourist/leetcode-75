package main.problems.array;

/**
 * You are given an array prices where prices[i] is the price of 
 * a given stock on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy 
 * one stock and choosing a different day in the future to sell that 
 * stock.
 * 
 * Return the maximum profit you can achieve from this transaction. 
 * If you cannot achieve any profit, return 0.
 * 
 * Ex. 1
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * 
 * Ex. 2
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 */
public class BestTimeToBuyAndSellStock {

    public static int best(int[] nums) {
        int min = nums[0];
        int bestProfit = 0;

        for (int i = 1; i < nums.length; i++) {
            bestProfit = Math.max(bestProfit, nums[i] - min);
            min = Math.min(min, nums[i]);
        }

        return bestProfit;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{7,1,5,3,6,4};
        int[] test2 = new int[]{7,6,4,3,1};

        System.out.println(best(test1));
        System.out.println(best(test2));
    }
}
