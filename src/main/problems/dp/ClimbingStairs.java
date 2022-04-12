package main.problems.dp;

public class ClimbingStairs {
    
    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     * 
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * 
     * Ex. 1
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * 
     * Ex. 2
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     * 
     * @param n
     * @return
     */
    public static int returnSolutionToClimbingStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int prev = 1;
        int curr = 2;
        for (int i = 3; i<= n; i++) {
            int tmp = prev + curr;
            prev = curr;
            curr = tmp;
        }
        return curr;
    }

    public static void main(String[] args) {
        int test1 = 2;
        int test2 = 3;
        int test3 = 14;

        System.out.println(returnSolutionToClimbingStairs(test1));
        System.out.println(returnSolutionToClimbingStairs(test2));
        System.out.println(returnSolutionToClimbingStairs(test3));
    }
}