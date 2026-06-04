class Solution {
    void backtrack(int n, List<String> res, int closed, int open, StringBuilder curr){
        if(curr.length()==2*n){
            res.add(curr.toString());
            return;
        }
        if(closed>open|| curr.length()>2*n){
            return;
        }
        if(open<n){
            open++;
            curr.append("(");
            backtrack(n,res,closed,open,curr);
            open--;
            curr.deleteCharAt(curr.length()-1);
        }
            closed++;
            curr.append(")");
            backtrack(n,res,closed,open,curr);
            closed--;
            curr.deleteCharAt(curr.length()-1);
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        backtrack(n,res,0,0,new StringBuilder());
        return res;
        
    }
}
