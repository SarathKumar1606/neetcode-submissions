class Solution:
    def prevSmaller(self,heights:List[int])->int:
        n=len(heights)
        pse=[-1]*n
        stack=[]
        for i in range(n):
            while stack and heights[stack[-1]]>=heights[i]:
                stack.pop()
            if stack:
                pse[i]=stack[-1]
            stack.append(i)
        return pse
    
    def nextSmaller(self,heights:List[int])->int:
        n=len(heights)
        nse=[n]*n
        stack=[]
        for i in range(n-1,-1,-1):
            while stack and heights[stack[-1]]>=heights[i]:
                stack.pop()
            if stack:
                nse[i]=stack[-1]
            stack.append(i)
        return nse

    def largestRectangleArea(self, heights: List[int]) -> int:
        pse=self.prevSmaller(heights)
        nse=self.nextSmaller(heights)
        maxArea=0

        for i in range(len(heights)):
            width=nse[i]-pse[i]-1
            area=heights[i]*width
            maxArea=max(maxArea,area)
        
        return maxArea
            