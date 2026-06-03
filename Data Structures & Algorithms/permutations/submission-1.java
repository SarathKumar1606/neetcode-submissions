class Solution {
    void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] used){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
       for(int i=0; i<nums.length; i++){
        if(used[i])continue;
        temp.add(nums[i]);
        used[i]=true;
        
        backtrack(nums,temp,res,used);
        
        temp.remove(temp.size()-1);
        used[i]=false;
        }
       
        
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        boolean[] used= new boolean[nums.length];
        backtrack(nums,new ArrayList<>(), res,used);
        return res;
        
    }
}
