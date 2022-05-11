package main.problems.dp;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange {
    
    public static int returnSolutionToCoinChange(Integer[] denominations, int amount) {
        
        Arrays.sort(denominations, Collections.reverseOrder());
        return dp(denominations, amount, 0, 0);
    }

    public static int dp(Integer[] denominations, int amountRemaining, int minAcceptableIndex, int numCoins) {
        if (amountRemaining == 0) {
            return numCoins;
        }

        for (int i = minAcceptableIndex; i < denominations.length; i++) {
            if (denominations[i] <= amountRemaining) {
                int ans = dp(denominations, amountRemaining - denominations[i], i, numCoins + 1);
                if (ans != -1) {
                    return ans;
                }
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        Integer[] test1coins = {1,2,5};
        int target1 = 11;
        Integer[] test2coins = {2};
        int target2 = 3;
        Integer[] test3coins = {1};
        int target3 = 0;

        System.out.println(returnSolutionToCoinChange(test1coins, target1));
        System.out.println(returnSolutionToCoinChange(test2coins, target2));
        System.out.println(returnSolutionToCoinChange(test3coins, target3));
    }
}
