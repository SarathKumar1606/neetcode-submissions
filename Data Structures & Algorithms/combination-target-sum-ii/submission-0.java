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
                backtrack(candidates,curr,currsum+candidates[pos],pos+1,res,target);
                curr.remove(curr.size()-1);

                int next=pos+1;
                while(next<candidates.length && candidates[next]==candidates[pos]){
                    next++;//this is duplicate prevention logic
                }
                backtrack(candidates,curr,currsum,next,res,target);
            
            
        }
    

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
       List<List<Integer>> res= new ArrayList<>();
       backtrack(candidates,new ArrayList<>(),0,0, res,target);
       return res; 
    }
}
