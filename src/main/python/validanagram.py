class Solution(object):
    def is_anagram(self, s1, s2):
        if len(s1) != len(s2):
            return False
        d = {}
        for c in s1:
            if c in d:
                d[c] += 1
            else:
                d[c] = 1
        for c in s2:
            if c in d:
                d[c] -= 1
            else:
                d[c] = -1
        for v in d.values():
            if v != 0:
                return False
        return True

if __name__ == '__main__':
    s = Solution()
    print(s.is_anagram('anagram', 'nagaram'))
    print(s.is_anagram('rat', 'car'))
    
