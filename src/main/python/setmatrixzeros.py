class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if not matrix:
            return
        m = len(matrix)
        n = len(matrix[0])
        row = [False] * m
        col = [False] * n
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    row[i] = True
                    col[j] = True
        for i in range(m):
            for j in range(n):
                if row[i] or col[j]:
                    matrix[i][j] = 0
        return matrix

if __name__ == '__main__':
    matrix = [[1,1,1],[1,0,1],[1,1,1]]
    print(Solution().setZeroes(matrix))
    matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    print(Solution().setZeroes(matrix))
    matrix = [[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]
    print(Solution().setZeroes(matrix))