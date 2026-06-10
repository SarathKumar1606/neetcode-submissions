class Solution {
    public int lengthOfLIS(int[] nums) {
        memo.clear();
        int n=nums.length;
        int[] dp = new int[n];
        dp[0]=1;
        int maxLIS=0;
        for(int i=1; i<n; i++){
             dp[i]=1;
            for(int j=0;j<i; j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        return maxLIS;
    }
}
