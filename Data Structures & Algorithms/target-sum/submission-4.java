class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int i : nums) sum+=i;
        int[][] dp = new int[n+1][2*sum+1];
        int _S=sum;
        if(Math.abs(target)>sum) return 0;
        dp[n][target+_S]=1;
        for(int i=n-1; i>=0;i--){
            for(int j=-sum; j<=sum; j++){
                int addPath=0;
                int subPath=0;
                if(j+nums[i]<=sum){
                    addPath+=dp[i+1][j+nums[i]+_S];
                }
                if(j-nums[i]>=-sum){
                    subPath+=dp[i+1][j-nums[i]+_S];
                }
                dp[i][j+_S]=addPath+subPath;
            }
        }
        return dp[0][0+_S];

    }
}
