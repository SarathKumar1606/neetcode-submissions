class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    private int dp(int currAmount, int[] coins){
        if(currAmount==0) return 0;
        else if(currAmount<0) return Integer.MAX_VALUE;
        if(memo.containsKey(currAmount)){
            return memo.get(currAmount);
        }
        int minimum=Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int res= dp(currAmount-coins[i],coins);
            if(res!=Integer.MAX_VALUE){
                minimum=Math.min(minimum,1+res);
            }
        }
        memo.put(currAmount,minimum);
        return minimum;
    }
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int ans=dp(amount,coins);
        return ans==Integer.MAX_VALUE ? -1 : ans;
        
    }
}
