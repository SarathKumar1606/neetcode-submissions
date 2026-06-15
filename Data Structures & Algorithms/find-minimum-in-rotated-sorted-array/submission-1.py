class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        def isBefore(mid:int)->bool:
            return nums[mid]>nums[-1]

        l,r=0,len(nums)-1
        
        while (r-l)>1:
            mid=(l+r)//2
            if isBefore(mid):
                l=mid
            else:
                r=mid
        return min(nums[l],nums[r])
        