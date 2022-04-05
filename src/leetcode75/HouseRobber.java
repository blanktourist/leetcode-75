public class HouseRobber {
    
    public static int returnSolutionToHouseRobber(int[] houses) {
        if (houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];
        if (houses.length == 2) return Math.max(houses[0], houses[1]);

        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < houses.length; i++) {
            dp[i] = Math.max(dp[i-2] + houses[i], dp[i - 1]);
        }

        return dp[dp.length-1];
    }
    
    public static void main(String[] args) {
        int[] test1 = {1,2,3,1};
        int[] test2 = {2,7,9,3,1};

        System.out.println(returnSolutionToHouseRobber(test1));
        System.out.println(returnSolutionToHouseRobber(test2));
    }
}
