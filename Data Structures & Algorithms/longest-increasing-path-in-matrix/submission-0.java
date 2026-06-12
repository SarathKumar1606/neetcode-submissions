class Solution {
    Integer[][] memo;
    boolean isValid(int[][] matrix, int x, int y, int prev){
        return x>=0 && x<matrix.length && y>=0 && y<matrix[0].length
        && matrix[x][y]>prev;
    }
    int[][] dirs={{-1,0},{0,-1},{1,0},{0,1}};
    int dfs(int[][] matrix, int r, int c){
        if(memo[r][c]!=null){
            return memo[r][c];
        }
        memo[r][c]=0;
        for(int[] dir : dirs){
            int nr=r+dir[0], nc=c+dir[1];
            if(isValid(matrix,nr,nc,matrix[r][c])){
                memo[r][c]=Math.max(memo[r][c],dfs(matrix,nr,nc));
            }
        }
        memo[r][c]+=1;
        return memo[r][c];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length, n= matrix[0].length;
        memo=new Integer[m][n];
        int res=0;
       for(int i=0; i<m;i++){
        for(int j=0; j<n; j++){
            res=Math.max(res,dfs(matrix,i,j));
        }
       } return res;
    }
}
