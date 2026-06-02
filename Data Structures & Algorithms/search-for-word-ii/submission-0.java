class Solution {
       class Node{
        Node[] children;
        String word;
        Node(){
            children=new Node[26];
            for(int i=0; i<26;i++){
                children[i]=null;
            }
            word=null;
        }
    }
    
class Trie{
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node curr=root;
        for(char c : word.toCharArray()){
            int idx=c-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.word=word;
        
    }
}   
   
    boolean isValid(char[][]board, int x, int y){
        int m=board.length;
        int n=board[0].length;
        return x>=0 && x<m && y>=0 && y<n;
    }
    int[][] dirs={{-1,0},{0,-1},{1,0},{0,1}};


    void dfs(char[][] board, int x, int y, Node curr, List<String> ans){
        char c=board[x][y];
        if(c=='#') return;
        curr=curr.children[c-'a'];
        if(curr==null) return;
        
        if(curr.word!=null){
            ans.add(curr.word);
            curr.word=null;
        }
        board[x][y]='#';
        for(int[] dir : dirs){
            int nx=x+dir[0],ny=y+dir[1];
            if(isValid(board,nx,ny)){
                dfs(board,nx,ny,curr,ans);
            }
        }
        board[x][y]=c;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie t=new Trie();
        for(String word : words){
            t.insert(word);
        }
        List<String> ans=new ArrayList<>();
        int m=board.length;
        int n=board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(t.root.children[board[i][j]-'a']!=null){
                    dfs(board,i,j,t.root, ans);
                }
            }
        }
        return ans;
        

        
    }
}