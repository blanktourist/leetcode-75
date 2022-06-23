class Solution(object):
    def is_valid_palindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        i, j = 0, len(s) - 1

        while i < j:
            while i < j and not s[i].isalnum():
                i += 1
            while i < j and not s[j].isalnum():
                j -= 1

            if s[i].lower() != s[j].lower():
                return False

            i += 1
            j -= 1

        return True

if __name__ == '__main__':
    s = Solution()
    print(s.is_valid_palindrome(""))
    print(s.is_valid_palindrome("a"))
    print(s.is_valid_palindrome("aa"))
    print(s.is_valid_palindrome("ab"))
    print(s.is_valid_palindrome("abc"))
    print(s.is_valid_palindrome("aba"))


