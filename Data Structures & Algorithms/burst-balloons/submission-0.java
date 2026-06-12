class Solution {
    Integer[][] memo;
    private int dp(int left, int right, int[] coins){
        if(right-left==1) return 0;
    
    if(memo[left][right]!=null){
        return memo[left][right];
    }
    memo[left][right]=0;
    for(int k=left+1; k<right; k++){
        memo[left][right]=Math.max(memo[left][right],dp(left,k,coins)
        +dp(k,right,coins)+coins[left]*coins[k]*coins[right]);
    }
    return memo[left][right];
}
    
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] temp=new int[n+2];
        memo= new Integer[n+2][n+2];
        temp[0]=1;
        temp[n+1]=1;
        for(int i=1; i<n+1; i++) temp[i]=nums[i-1];
        return dp(0,temp.length-1,temp);
        
    }
}
