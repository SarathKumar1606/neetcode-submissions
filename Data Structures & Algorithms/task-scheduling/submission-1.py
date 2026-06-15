class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq={}
        for task in tasks:
            if task in freq:
                freq[task]+=1
            else:
                freq[task]=1
        maxFreq=max(freq.values())

        numMaxFreqTasks=0
        for count in freq.values():
            if count==maxFreq:
                numMaxFreqTasks+=1
        return max(
            len(tasks),
            (maxFreq-1)*(n+1)+numMaxFreqTasks
        )

        
        