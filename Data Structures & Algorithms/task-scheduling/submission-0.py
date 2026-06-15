class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq={}
        for task in tasks:
            if task in freq:
                freq[task]+=1
            else:
                freq[task]=1
        minheap=[]
        for i in freq.values():
            heapq.heappush(minheap,-i)
        
        cooldown=deque()
        currentTime=0
        while minheap or cooldown:
            currentTime+=1
            if minheap:
                remtoExecute=heapq.heappop(minheap)
                remtoExecute+=1
                if remtoExecute!=0:
                    cooldown.append((remtoExecute,currentTime+n))
            
            if cooldown and cooldown[0][1]==currentTime:
                remExecutions,_=cooldown.popleft()
                heapq.heappush(minheap,remExecutions)
        return currentTime

        
        