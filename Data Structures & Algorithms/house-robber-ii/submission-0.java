class Solution {
     HashMap<Integer,Integer> mp= new HashMap<>();
   private int dp(int i, int n, int[] nums){
        if( i>n) return 0;
        if(mp.containsKey(i)){
            return mp.get(i);
        }
        int res=Math.max(nums[i]+dp(i+2,n,nums),dp(i+1,n,nums));
        mp.put(i,res);
        return res;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 1) return nums[0];
        int range1=dp(0,n-2,nums);
        mp.clear();
        int range2=dp(1,n-1,nums);
        return Math.max(range1,range2);
    }
}
