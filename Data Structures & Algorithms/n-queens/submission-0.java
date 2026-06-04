class Solution {
    private boolean isSafe(List<String> board, int row, int col){
        int n=board.size(); 
        for(int r=0; r<row; r++){
            if(board.get(r).charAt(col)=='Q') return false;
        }
        for(int r=row, c=col; r>=0 && c>=0; r--, c--){
            if(board.get(r).charAt(c)=='Q') return false;
        }
        for(int r=row, c=col; r>=0 && c<n; r--, c++){
            if(board.get(r).charAt(c)=='Q') return false;
        }
        return true;
    }

    private void backtrack(List<String>board,List<List<String>> res,int row, int n){
        if(row==n){
            res.add(new ArrayList<>(board));
            return;
        }
        for(int col=0; col<n; col++){
            if(isSafe(board,row,col)){

                String currentRow = board.get(row);
                String queenRow = currentRow.substring(0, col) + "Q" + currentRow.substring(col + 1);
                board.set(row,queenRow);
                backtrack(board,res,row+1,n);
                board.set(row,currentRow);
            }
        }

    }
    
    
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringBuilder row = new StringBuilder();
            for(int j=0; j<n; j++){
                row.append(".");
            }
            board.add(row.toString());
        }
        List<List<String>> res =new ArrayList<>();
        backtrack(board,res,0,n);
        return res;

        
    }
}
