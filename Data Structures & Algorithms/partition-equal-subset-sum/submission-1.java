class Solution {
    private Boolean[][] memo;
    private boolean dp(int i, int currSum , int halfSum, int[] nums){
        if(currSum==halfSum)return true;
        if(i>=nums.length||currSum>halfSum) return false;
        String key=i+","+currSum;
        if(memo[i][currSum]!=null){
            return memo[i][currSum];
        }

        boolean include=false;
        if(currSum+nums[i]<=halfSum){
            include=dp(i+1,currSum+nums[i],halfSum,nums);
        }
        boolean skip=dp(i+1,currSum,halfSum,nums);
        return memo[i][currSum] = include || skip;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num : nums){
            sum+=num;
        }
        if(sum%2!=0) return false;
        int halfSum=sum>>1;
        memo = new Boolean[nums.length][halfSum + 1];
        return dp(0,0,halfSum,nums);
    }
}
