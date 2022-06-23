class Solution(object):
    def rotate_image(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        if len(matrix) == 0:
            return
        n = len(matrix)
        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        for i in range(n):
            matrix[i].reverse()
        return matrix

if __name__ == '__main__':
    s = Solution()
    print(s.rotate_image([[1,2,3],[4,5,6],[7,8,9]]))
    print(s.rotate_image([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]))