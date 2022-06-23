class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) < 2:
            return 0
        min_price = prices[0]
        max_profit = 0
        for i in range(1, len(prices)):
            max_profit = max(max_profit, prices[i] - min_price)
            min_price = min(min_price, prices[i])
        return max_profit

if __name__ == '__main__':
    s = Solution()
    print(s.maxProfit([7, 1, 5, 3, 6, 4]))
    print(s.maxProfit([7, 6, 4, 3, 1]))
    print(s.maxProfit([7, 1, 5, 3, 6, 4, 2]))
    print(s.maxProfit([7, 1, 5, 3, 6, 4, 2, 0]))
    print(s.maxProfit([7, 1, 5, 3, 6, 4, 2, 0, -1]))
    print(s.maxProfit([7, 1, 5, 3, 6, 4, 2, 0, -1, -2]))
    print(s.maxProfit([7, 1, 5, 3, 6, 4, 2, 0, -1, -2, -3]))