class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int globalMax=nums[0], currMax=nums[0], currMin=nums[0];
        for(int i=1; i<n; i++){
            int num=nums[i];
            if(num<0){
                int temp=currMax;
                currMax=currMin;
                currMin=temp;
            }
            currMin=Math.min(num, currMin*num);
            
            currMax=Math.max(num,currMax*num);
            globalMax=Math.max(currMax,globalMax);
        }
        return globalMax;
        
    }
}
