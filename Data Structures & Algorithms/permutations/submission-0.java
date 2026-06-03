class Solution {
    void backtrack(int[] nums, int pos, List<Integer> temp, List<List<Integer>> res, boolean[] used){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(pos>=nums.length) return;
        if(!used[pos]){
        temp.add(nums[pos]);
        used[pos]=true;
        
        backtrack(nums,0,temp,res,used);
        
        temp.remove(temp.size()-1);
        used[pos]=false;
        }
        backtrack(nums,pos+1,temp,res,used);
        
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        boolean[] used= new boolean[nums.length];
        backtrack(nums,0,new ArrayList<>(), res,used);
        return res;
        
    }
}
