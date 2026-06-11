class Solution {
    Integer[][] memo;
    private int dp(int i, boolean buying,int[] prices){
        if(i>=prices.length) return 0;
        int pos= buying? 1 : 0;
        if(memo[i][pos]!=null){
            return memo[i][pos];
        }
        if(buying){
            memo[i][pos]=Math.max(dp(i+1,false,prices)
            -prices[i],dp(i+1,true,prices));
        }else{
            memo[i][pos]=Math.max(dp(i+2,true,prices)
            +prices[i],dp(i+1,false,prices));
        }
        return memo[i][pos];
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        memo = new Integer[n][2];
        return dp(0,true,prices);
    }
}
