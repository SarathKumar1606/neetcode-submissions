class Solution {
    Integer[][] memo;
    private int dp(int i, int j, String s1, String s2){
        if(i==s1.length()){
            return s2.length()-j;
        }
        else if(j==s2.length()){
            return s1.length()-i;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            memo[i][j]=dp(i+1,j+1,s1,s2);
        }else{
            memo[i][j]=1+Math.min(dp(i,j+1,s1,s2),
            Math.min(dp(i+1,j,s1,s2),dp(i+1,j+1,s1,s2)));
        }
        return memo[i][j];

    }
    public int minDistance(String word1, String word2) {
        int m=word1.length(), n= word2.length();
        memo = new Integer[m+1][n+1];
        return dp(0,0,word1,word2);
    }
}
