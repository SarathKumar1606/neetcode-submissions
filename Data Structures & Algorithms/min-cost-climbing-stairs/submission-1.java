class Solution {
    HashMap<Integer,Integer> mp = new HashMap<>();
    int dp(int i, int[] cost,int n){
        if(i>=n) return 0;
        if(mp.containsKey(i))
            return mp.get(i);
        int res=cost[i]+Math.min(dp(i+1,cost,n),dp(i+2,cost,n));
        mp.put(i,res);
        return res;
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        return Math.min(dp(0,cost,n),dp(1,cost,n));
        

        
    }
}
