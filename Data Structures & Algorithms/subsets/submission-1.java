class Solution {
    public void backtrack(int[] nums,List<Integer> curr,int pos, List<List<Integer>> res){
        if(pos==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[pos]);
        backtrack(nums,curr,pos+1,res);
        curr.remove(curr.size()-1);
        backtrack(nums,curr,pos+1,res);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(nums,new ArrayList<>(), 0,res);
        return res;
        
    }
}
