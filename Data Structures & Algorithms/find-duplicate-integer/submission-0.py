class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        low=1
        high=len(nums)-1
        while(low<high):
            mid=(low+high)//2

            numsTillMid=sum(1 for num in nums if num<=mid)
            if numsTillMid>mid:
                high=mid
            else:
                low=mid+1
            
        return low
        