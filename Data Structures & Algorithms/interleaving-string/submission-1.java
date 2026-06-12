class Solution {
    Boolean[][] memo;
    private boolean dp(int i, int j,String s1, String s2, String s3){
        if(i==s1.length() && j==s2.length()) return true;
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        boolean match1=false, match2=false;
        if(i<s1.length() && i+j<s3.length() && s1.charAt(i)==s3.charAt(i+j)){
            match1=dp(i+1,j,s1,s2,s3);
        }
         if(j<s2.length() && i+j<s3.length() && s2.charAt(j)==s3.charAt(i+j)){
            match2=dp(i,j+1,s1,s2,s3);
        }
        return memo[i][j]=match1||match2;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        memo= new Boolean[s1.length()+1][s2.length()+1];
        return dp(0,0,s1,s2,s3);
    }
}
