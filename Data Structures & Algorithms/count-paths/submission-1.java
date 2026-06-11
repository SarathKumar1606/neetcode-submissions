class Solution {
    Integer[][] memo;
    private boolean isValid(int x, int y, int m, int n){
        return x>=0 && x<m && y>=0 && y<n;
    }
    private int dp(int i, int j,int m, int n){
        if(i==0 && j==0) return 1;
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        int paths=0;
        if(isValid(i-1,j,m,n)){
            paths+=dp(i-1,j,m,n);
        }
        if(isValid(i,j-1,m,n)){
            paths+=dp(i,j-1,m,n);
        }
        memo[i][j]=paths;
        return memo[i][j];
    }
    public int uniquePaths(int m, int n) {
            memo=new Integer[m][n];
            return dp(m-1,n-1,m,n);
        
    }
}
