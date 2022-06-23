class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = {}
        for i, num in enumerate(nums):
            if target - num in d:
                return [d[target - num], i]
            d[num] = i


if __name__ == '__main__':
    s = Solution()
    print(s.twoSum([2, 7, 11, 15], 9))
    print(s.twoSum([3, 2, 4], 6))
    print(s.twoSum([3, 3], 6))
    print(s.twoSum([-3, 4, 3, 90], 0))
    print(s.twoSum([-3, 4, 3, 90], -6))
    print(s.twoSum([-3, 4, 3, 90], 6))