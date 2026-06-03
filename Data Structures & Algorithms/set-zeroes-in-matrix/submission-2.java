class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        boolean firstRowZero=false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;//setting first row fully zero if any first row element is zero
                    if(i>0){
                        matrix[i][0]=0;// setting first column fully zero if i>0
                    }else{
                        firstRowZero=true; // if i==0 setting the flag as first row zero
                    }
                }
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){//if first col is zero
            for(int i=0; i<m; i++){
                matrix[i][0]=0;
            }
        }
        if(firstRowZero==true){
            for(int j=0; j<n; j++){
                matrix[0][j]=0;
            }
        }

        
        
    }
}
