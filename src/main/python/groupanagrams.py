class Solution(object):
    def group_anagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        dic = {}
        for s in strs:
            key = ''.join(sorted(s))
            if key not in dic:
                dic[key] = [s]
            else:
                dic[key].append(s)
        return list(dic.values())

if __name__ == '__main__':
    s = Solution()
    print(s.group_anagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
    print(s.group_anagrams([""]))
    print(s.group_anagrams(["a"]))
    