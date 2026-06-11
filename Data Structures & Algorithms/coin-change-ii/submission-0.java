class Solution {
    Integer[][] memo;
    private int dp(int i, int amt, int[] coins){
        if(amt==0) return 1;
        if(amt<0 || i>=coins.length) return 0;
        if(memo[i][amt]!=null) {
            return memo[i][amt];
        }
        memo[i][amt]=dp(i+1,amt,coins)+dp(i,amt-coins[i],coins);
        return memo[i][amt];
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        memo= new Integer[n][amount+1];
        return dp(0,amount,coins);
    }
}
