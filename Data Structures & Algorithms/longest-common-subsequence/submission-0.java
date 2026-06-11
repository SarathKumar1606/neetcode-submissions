class Solution {
    Integer[][] memo;
    private int dp(int i, int j, String s1, String s2){
        if(i>=s1.length()||j>=s2.length()) return 0;
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            memo[i][j]=1+dp(i+1,j+1,s1,s2);
        }else{
            memo[i][j]=Math.max(dp(i+1,j,s1,s2),dp(i,j+1,s1,s2));
        }
        return memo[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length(), n2= text2.length();
        memo= new Integer[n1][n2];
        return dp(0,0,text1,text2);
    }
}
