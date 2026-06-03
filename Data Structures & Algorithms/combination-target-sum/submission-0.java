class Solution {
     void backtrack(int[] candidates,List<Integer> curr, int currsum,int pos, List<List<Integer>> res, int target){
        if(currsum==target){
                res.add(new ArrayList<>(curr));
                return;
            }
        if(pos==candidates.length||currsum>target){
            return;
        }
                curr.add(candidates[pos]);
                backtrack(candidates,curr,currsum+candidates[pos],pos,res,target);
                curr.remove(curr.size()-1);
                backtrack(candidates,curr,currsum,pos+1,res,target);
            
            
        }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
         List<List<Integer>> res= new ArrayList<>();
       backtrack(nums,new ArrayList<>(),0,0, res,target);
       return res;
        
    }
}
