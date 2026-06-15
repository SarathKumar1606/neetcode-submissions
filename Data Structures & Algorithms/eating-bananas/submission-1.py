class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        maxarr=max(piles)

        def totaltime(rate:int)->bool:
            total=0
            for i in piles:
                total+=math.ceil(i/rate)
            return total
        
        def isBefore(i:int)->bool:
            return totaltime(i)>h
        
        l,r=1,maxarr
        while (r-l)>1:
            mid=(l+r)//2
            if(isBefore(mid)):
                l=mid
            else:
                r=mid
        if not isBefore(l):
            return l
        return r