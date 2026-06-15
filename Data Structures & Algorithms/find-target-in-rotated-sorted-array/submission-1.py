class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def isBefore(mid:int)->bool:
            if nums[l]<=nums[mid]:
                return nums[l]<=target and target<nums[mid]
            else:
                return not(nums[mid]<target and target<=nums[-1])
        
        l,r=0,len(nums)-1
        while (r-l)>1:
            mid=(l+r)//2
            if isBefore(mid):
                r=mid
            else:
                l=mid

        if nums[l]==target:
             return l
        if nums[r]==target:
             return r
        return -1
        