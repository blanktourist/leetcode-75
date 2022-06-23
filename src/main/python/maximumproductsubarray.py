class Solution(object):
    def maxProduct(self, nums):
        """
        Given an integer array nums, find a contiguous non-empty subarray 
        within the array that has the largest product, and return the product.

        Example 1: Input: [2,3,-2,4] Output: 6
        Example 2: Input: [-2,0,-1] Output: 0
        Example 3: Input: [2,3,-2,4,-1] Output: 24

        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0

        max_so_far = nums[0]
        min_so_far = nums[0]
        result = max_so_far

        for i in range(1, len(nums)):
            curr = nums[i]
            temp_max = max(curr, max_so_far * curr, min_so_far * curr)
            min_so_far = min(curr, max_so_far * curr, min_so_far * curr)

            max_so_far = temp_max

            result = max(max_so_far, result)

        return result

if __name__ == '__main__':
    s = Solution()
    print(s.maxProduct([2,3,-2,4]))
    print(s.maxProduct([-2,0,-1]))
    print(s.maxProduct([2,3,-2,4,-1]))