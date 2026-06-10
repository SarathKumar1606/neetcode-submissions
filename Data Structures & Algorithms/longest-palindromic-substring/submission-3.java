class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1) return s;
        boolean[][] dp = new boolean[n][n];
        for(int i=0; i<n; i++){
            dp[i][i]=true;
        }
        int maxLen=1,start=0;
        for(int len=2; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(j==i+1){
                    dp[i][j]=true;
                    }else if(j>i+1){
                    dp[i][j]=dp[i+1][j-1];
                    }
                    if(dp[i][j]&& len>maxLen){
                        start=i;
                        maxLen=len;
                    }

                }
            }
        }
        return s.substring(start,start+maxLen);
        
    }
}
