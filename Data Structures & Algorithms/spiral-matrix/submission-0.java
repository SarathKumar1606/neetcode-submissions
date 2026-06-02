class Solution {
    boolean isValid(int[][]matrix, int x, int y){
        return x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[x][y]!=101;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        int r=0, c=0;
        int d=0;
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m*n; i++){
            res.add(matrix[r][c]);
            matrix[r][c]=101;
            if(!isValid(matrix,r+dirs[d][0],c+dirs[d][1])){
                d=(d+1)%4;
            }
            r=r+dirs[d][0];
            c=c+dirs[d][1];
        }
        return res;
        
    }
}
