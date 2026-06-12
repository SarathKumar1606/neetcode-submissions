class Solution {
    Boolean[][] memo;
    boolean match(int i, int j,String s, String p){
       return i<s.length() && ( s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'); 
    }
    private boolean dp(int i, int j, String s, String p){
        if(i==s.length() && j==p.length()) return true;
        if(j==p.length() && i<s.length()) return false;
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            memo[i][j]=dp(i,j+2,s,p)||
            (match(i,j,s,p)&&dp(i+1,j,s,p));
        }else{
            memo[i][j]=match(i,j,s,p)&&dp(i+1,j+1,s,p);
        }
        return memo[i][j];
    }
    public boolean isMatch(String s, String p) {
        int m=s.length(), n=p.length();
        memo= new Boolean[m+1][n+1];
        return dp(0,0,s,p);
    }
}
