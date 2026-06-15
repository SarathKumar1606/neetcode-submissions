class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        minheap=[]
        for i in range(len(points)):
            x=points[i][0]
            y=points[i][1]
            dist=math.sqrt(x**2+y**2)
            heapq.heappush(minheap,(-dist,i))
            if len(minheap)>k:
                heapq.heappop(minheap)
        res=[]
        while minheap:
            res.append(points[minheap[0][1]])
            heapq.heappop(minheap)
        return res
        