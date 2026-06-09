class Solution {
    HashMap<Integer,Integer> mp = new HashMap<>();
    private int dp(int i,int n){

        if(i>n) return 0;
        if(mp.containsKey(i))
            return mp.get(i);
        int res=dp(i+1,n)+dp(i+2,n);
        mp.put(i,res);
        return res;
    }
    public int climbStairs(int n) {
        return dp(0,n);
    }
}
