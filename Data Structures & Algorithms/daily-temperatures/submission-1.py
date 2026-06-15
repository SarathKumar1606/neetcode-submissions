class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n=len(temperatures)
        res=[0]*n
        stack=[]
        
        for i in range(n-1,-1,-1):
            curr_temp=temperatures[i]

            while stack and stack[-1][0]<=curr_temp:
                stack.pop()
            
            if stack:
                res[i]=stack[-1][1]-i
            
            stack.append([curr_temp,i])
            
        return res
        