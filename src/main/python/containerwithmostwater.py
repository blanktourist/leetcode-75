class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        max_area = 0
        left = 0
        right = len(height) - 1
        while left < right:
            max_area = max(max_area, min(height[left], height[right]) * (right - left))
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return max_area

if __name__ == '__main__':
    s = Solution()
    print(s.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]))
    print(s.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7, 9]))
    print(s.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7, 9, 10]))
    print(s.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7, 9, 10, 11]))
    print(s.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7, 9, 10, 11, 12]))