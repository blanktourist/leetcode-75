class Solution(object):
    def does_grid_contain_word(self, grid, word):
        """
        :type grid: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if len(word) == 0:
            return True
        if len(grid) == 0:
            return False
        if len(grid[0]) == 0:
            return False
        if len(word) > len(grid) * len(grid[0]):
            return False
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if self.does_grid_contain_word_helper(grid, word, i, j):
                    return True
        return False
    
    def does_grid_contain_word_helper(self, grid, word, i, j):
        """
        :type grid: List[List[str]]
        :type word: str
        :type i: int
        :type j: int
        :rtype: bool
        """
        if len(word) == 0:
            return True
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]):
            return False
        if grid[i][j] != word[0]:
            return False
        temp = grid[i][j]
        grid[i][j] = '#'
        res = self.does_grid_contain_word_helper(grid, word[1:], i + 1, j) or \
            self.does_grid_contain_word_helper(grid, word[1:], i - 1, j) or \
                self.does_grid_contain_word_helper(grid, word[1:], i, j + 1) or \
                    self.does_grid_contain_word_helper(grid, word[1:], i, j - 1)
        grid[i][j] = temp
        return res

if __name__ == '__main__':
    s = Solution()
    grid = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ]
    print(s.does_grid_contain_word(grid, "ABCCED"))
    print(s.does_grid_contain_word(grid, "SEE"))
    print(s.does_grid_contain_word(grid, "ABCB"))
    print(s.does_grid_contain_word(grid, "ABCE"))