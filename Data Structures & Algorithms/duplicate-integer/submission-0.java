class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length==1|| nums.length==0) return true;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(nums[i])) return true;
            mp.put(nums[i],1);
        }
        return false;
        
    }
}