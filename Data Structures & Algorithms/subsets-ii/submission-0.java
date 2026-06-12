class Solution {
     public void backtrack(int[] nums,List<Integer> curr,int pos, HashSet<List<Integer>> res){
        if(pos==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[pos]);
        backtrack(nums,curr,pos+1,res);
        curr.remove(curr.size()-1);
        backtrack(nums,curr,pos+1,res);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
         HashSet<List<Integer>> res=new HashSet<>();
        backtrack(nums,new ArrayList<>(), 0,res);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> s : res){
                ans.add(s);
        }
        return ans;
    }
}