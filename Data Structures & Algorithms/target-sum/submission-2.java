class Solution {
    Integer[][] memo;
    private int _S;
    private int dp(int i, int j, int[] nums, int target){
        if(i==nums.length && j==target) return 1;
        if(i==nums.length && j!=target) return 0;
        if(memo[i][j+_S]!=null){
            return memo[i][j+_S];
        }
         memo[i][j+_S]=0;
    
            memo[i][j+_S]=dp(i+1,j+nums[i],nums,target)+dp(i+1,j-nums[i],nums,target);
    
        return memo[i][j+_S];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int i : nums) sum+=i;
        _S=sum;
        memo=new Integer[n][2*sum+1];
        return dp(0,0,nums,target);
    }
}
