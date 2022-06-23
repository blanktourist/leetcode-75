from ast import List

class Solution(object):
    """
    :type nums: List[int]
        :rtype: List[int]
    """
    def spiralOrder(self, matrix):
        if not matrix:
            return []
        m, n = len(matrix), len(matrix[0])
        res = []
        left, right, top, bottom = 0, n-1, 0, m-1
        while left <= right and top <= bottom:
            for i in range(left, right+1):
                res.append(matrix[top][i])
            for i in range(top+1, bottom+1):
                res.append(matrix[i][right])
            for i in range(right-1, left-1, -1):
                if top < bottom:
                    res.append(matrix[bottom][i])
            for i in range(bottom-1, top, -1):
                if left < right:
                    res.append(matrix[i][left])
            left, right, top, bottom = left+1, right-1, top+1, bottom-1
        return res

if __name__ == '__main__':
    s = Solution()
    print(s.spiralOrder([[1,2,3],[4,5,6],[7,8,9]]))
    print(s.spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]))
    print(s.spiralOrder([[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]))