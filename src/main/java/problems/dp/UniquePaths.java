package main.problems.dp;

public class UniquePaths {
    
    public static int returnSolutionToUniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[1][0] = 1;
        for (int i = 1; i<= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(returnSolutionToUniquePaths(3, 7));
        System.out.println(returnSolutionToUniquePaths(3, 2));
    }
}
