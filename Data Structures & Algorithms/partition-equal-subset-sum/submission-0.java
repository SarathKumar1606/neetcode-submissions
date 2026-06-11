class Solution {
    HashMap<String,Boolean> memo = new HashMap<>();
    private boolean dp(int i, int currSum , int halfSum, int[] nums){
        if(currSum==halfSum)return true;
        if(i>=nums.length||currSum>halfSum) return false;
        String key=i+","+currSum;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        boolean include=false;
        if(currSum+nums[i]<=halfSum){
            include=dp(i+1,currSum+nums[i],halfSum,nums);
        }
        boolean skip=dp(i+1,currSum,halfSum,nums);
        boolean res=include||skip;
        memo.put(key,res);
        return res;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num : nums){
            sum+=num;
        }
        if(sum%2!=0) return false;
        return dp(0,0,sum/2,nums);
    }
}
