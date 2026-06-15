class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        maxarea=0
        stack=[]
        n=len(heights)

        for i in range(n):
            start=i
            while stack and heights[stack[-1]]>heights[i]:
                element=heights[stack[-1]]
                stack.pop()

                nse=i
                pse=stack[-1] if stack else -1
                maxarea=max(maxarea, element*(nse-pse-1))
            stack.append(i)

        while stack:
            nse=n
            element=heights[stack[-1]]
            stack.pop()
            pse= stack[-1] if stack else -1
            maxarea=max(maxarea, element*(nse-pse-1))
        
        return maxarea
            