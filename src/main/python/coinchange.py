class Solution(object):
    def min_num_coins(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [0] * (amount + 1)
        for i in range(1, amount + 1):
            dp[i] = amount + 1
            for j in range(len(coins)):
                if i >= coins[j]:
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1)
        return dp[amount] if dp[amount] != amount + 1 else -1

if __name__ == '__main__':
    s = Solution()
    print(s.min_num_coins([1, 2, 5], 11))
    print(s.min_num_coins([2], 3))
    print(s.min_num_coins([1, 2, 5], 100))
