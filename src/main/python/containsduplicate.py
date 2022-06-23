class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        d = {}
        for num in nums:
            if num in d:
                return True
            d[num] = 1
        return False

if __name__ == '__main__':
    s = Solution()
    print(s.containsDuplicate([1, 2, 3, 1]))
    print(s.containsDuplicate([1, 2, 3, 4]))
    print(s.containsDuplicate([1, 1, 1, 1]))
    print(s.containsDuplicate([1, 2, 3, 4, 5]))
    print(s.containsDuplicate([1, 2, 3, 4, 5, 1]))
    print(s.containsDuplicate([1, 2, 3, 4, 5, 6]))
    print(s.containsDuplicate([1, 2, 3, 4, 5, 6, 7]))
    