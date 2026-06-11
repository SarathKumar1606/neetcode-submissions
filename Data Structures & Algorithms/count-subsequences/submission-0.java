class Solution {
    Integer[][] memo;
    private int dp(int i, int j, String s, String t){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        if(s.charAt(i)!=t.charAt(j)){
            memo[i][j]=dp(i+1,j,s,t);
        }else{
            memo[i][j]=dp(i+1,j+1,s,t)+dp(i+1,j,s,t);
        }
        return memo[i][j];
    }
    public int numDistinct(String s, String t) {
        int m=s.length() , n=t.length();
        memo = new Integer[m+1][n+1];
        return dp(0,0,s,t);
    }
}
