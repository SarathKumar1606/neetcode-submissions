class Solution {
  public int dp(int start, int end,int[] nums) {
        int n=nums.length;
        if(start>end) return 0;
        int prev2=0, prev1=0;
        for(int i=start;i<=end; i++){
            int current=Math.max(nums[i]+prev2,prev1);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 1) return nums[0];
        int range1=dp(0,n-2,nums);
        int range2=dp(1,n-1,nums);
        return Math.max(range1,range2);
    }
}
