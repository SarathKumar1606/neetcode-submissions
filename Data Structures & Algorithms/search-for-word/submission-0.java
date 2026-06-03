class Solution {
    int[][] dirs={{-1,0},{0,-1},{1,0},{0,1}};
    private boolean backtrack(char[][]board, int r, int c, String word, int pos){
        if(pos==word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(pos)) {
            return false;
        }
        char temp=board[r][c];
        board[r][c]='#';
      
        for(int[] dir : dirs){
            int nr=r+dir[0], nc=c+dir[1];
            
                if(backtrack(board,nr,nc,word,pos+1)) return true;
            
        }
        board[r][c]=temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m=board.length, n=board[0].length;
        char first=word.charAt(0);
        for(int r=0;r<m;r++){
            for(int c=0; c<m; c++){
                    if(board[r][c]==first){
                     return   backtrack(board,r,c,word,0);
                    }
            }
        }
        return true;
         
    }
}
