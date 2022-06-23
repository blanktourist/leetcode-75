class Solution(object):
    def maximumSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        left = [0] * len(nums)
        left[0] = nums[0]
        for i in range(1, len(nums)):
            left[i] = max(left[i-1] + nums[i], nums[i])
        return max(left)

if __name__ == '__main__':
    s = Solution()
    print(s.maximumSubarray([-2,1,-3,4,-1,2,1,-5,4]))
    print(s.maximumSubarray([1]))
    print(s.maximumSubarray([5,4,-1,7,8]))
    
