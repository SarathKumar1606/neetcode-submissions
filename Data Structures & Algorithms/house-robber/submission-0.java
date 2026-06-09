class Solution {
    HashMap<Integer,Integer> mp= new HashMap<>();
   private int dp(int i, int n, int[] nums){
        if(i<0 || i>=n) return 0;
        if(mp.containsKey(i)){
            return mp.get(i);
        }
        int res=Math.max(nums[i]+dp(i+2,n,nums),dp(i+1,n,nums));
        mp.put(i,res);
        return res;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        return dp(0,n,nums);
    }
}
