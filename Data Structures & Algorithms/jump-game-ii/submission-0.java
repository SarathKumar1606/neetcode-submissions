class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int currIndex=0;
        int takenJumps=0;
        while(currIndex<n-1){
             if (currIndex + nums[currIndex] >= n - 1)
                return takenJumps + 1;
            int jumps=nums[currIndex];
            int maxJumpIndex=currIndex+1;
            for(int i=currIndex+1; i<=currIndex+jumps&& i<n;i++){
                 if (i + nums[i] > maxJumpIndex + nums[maxJumpIndex]) {
                    maxJumpIndex = i;
                }
            }
            currIndex=maxJumpIndex;
            takenJumps++;
        }
        return takenJumps;
        
    }
}
