class Solution:     
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        R,C=len(matrix),len(matrix[0])

        def isBefore(i:int)->bool:
            row,col=i//C,i%C
            return matrix[row][col]<target
        
        if target<matrix[0][0] or matrix[R-1][C-1]<target:
            return False
        if target==matrix[0][0]:
            return True

        l,r=0,R*C-1
        while (r-l)>1:
            mid=(r+l)//2
            if isBefore(mid):
                l=mid
            else:
                r=mid
        return True if matrix[r//C][r%C]==target else False
        