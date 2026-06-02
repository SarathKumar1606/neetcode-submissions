class Solution {
      public void reverseRow(int[][] matrix, int row) {

        int left = 0;
        int right = matrix[row].length - 1;

        while(left < right) {

            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;

            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=i+1; j<n; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<m;i++){
            reverseRow(matrix,i);
        }
        
    }
}
