class Solution(object):
    def valid_parentheses(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) == 0:
            return True
        if len(s) % 2 != 0:
            return False

        mapping = {")": "(", "}": "{", "]": "["}

        stack = []
        for c in s:
            if c == '(':
                stack.append(c)
            elif c == '{':
                stack.append(c)
            elif c == '[':
                stack.append(c)
            else:
                if len(stack) == 0:
                    return False
                if stack.pop() != mapping[c]:
                    return False
        return len(stack) == 0

if __name__ == '__main__':
    s = Solution()
    print(s.valid_parentheses("()"))
    print(s.valid_parentheses("()[]{}"))
    print(s.valid_parentheses("(]"))
    print(s.valid_parentheses("([)]"))
    print(s.valid_parentheses("{[]}"))
