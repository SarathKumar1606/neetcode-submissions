class Solution {
    private boolean isValid(int m, int n, int x, int y){
        return x>=0 && x<m && y>=0 && y<n;
    }
    public int uniquePaths(int m, int n) {
            int[][] dp= new int[m][n];
            dp[0][0]=1;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(isValid(m,n,i-1,j)){
                        dp[i][j]+=dp[i-1][j];
                    }
                    if(isValid(m,n,i,j-1)){
                        dp[i][j]+=dp[i][j-1];
                    }
                }
            }
            return dp[m-1][n-1];
        
    }
}
