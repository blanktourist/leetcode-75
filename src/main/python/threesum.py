class Solution(object):
    def get_triplets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) < 3:
            return []
        nums.sort()
        # print(nums)
        triplets = []
        for i in range(len(nums)-2):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i-1]:
                continue
            l = i + 1
            r = len(nums) - 1
            while l < r:
                # print(nums[i], nums[l], nums[r])
                sum = nums[i] + nums[l] + nums[r]
                if sum == 0:
                    triplets.append([nums[i], nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while l < r and nums[l] == nums[l-1]:
                        l += 1
                    while l < r and nums[r] == nums[r+1]:
                        r -= 1
                elif sum < 0:
                    l += 1
                    while l < r and nums[l] == nums[l-1]:
                        l += 1
                else:
                    r -= 1
                    while l < r and nums[r] == nums[r+1]:
                        r -= 1
        return triplets

if __name__ == '__main__':
    s = Solution()
    print(s.get_triplets([-1,0,1,2,-1,-4]))