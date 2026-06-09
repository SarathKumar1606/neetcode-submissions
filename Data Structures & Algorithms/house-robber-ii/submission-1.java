class Solution {
  public int dp(int start, int end,int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp= new int[n];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end; i++){
            dp[i]=Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[end];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 1) return nums[0];
        int range1=dp(0,n-2,nums);
        int range2=dp(1,n-1,nums);
        return Math.max(range1,range2);
    }
}
