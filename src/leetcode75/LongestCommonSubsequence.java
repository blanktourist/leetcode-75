public class LongestCommonSubsequence {
    
    public static int returnLengthOfLongestCommonSubsequence(String s, String t) {
        
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i< s.length(); i++) {
            for (int j = 0; j< t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
    
    public static void main(String[] args) {
        String test1s = "abcde";
        String test1t = "ace";
        String test2s = "abc";
        String test2t = "abc";
        String test3s = "abc";
        String test3t = "def";

        System.out.println(returnLengthOfLongestCommonSubsequence(test1s, test1t));
        System.out.println(returnLengthOfLongestCommonSubsequence(test2s, test2t));
        System.out.println(returnLengthOfLongestCommonSubsequence(test3s, test3t));
    }
}
