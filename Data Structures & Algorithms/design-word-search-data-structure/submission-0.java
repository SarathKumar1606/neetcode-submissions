class WordDictionary {
    class Node{
        Node[] children;
        boolean isEnd;
        Node(){
            children= new Node[26];
            isEnd=false;
            for(int i=0; i<26; i++){
                children[i]=null;
            }
        }
    }
    Node root;

    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node curr=root;
        for(char c : word.toCharArray()){
            int idx=c-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.isEnd=true;
        
    }
    boolean dfs(Node curr, String word, int idx){
        if(curr==null) return false;
        if(idx==word.length()) return curr.isEnd;
        
        char c=word.charAt(idx);
        if(c=='.'){
            for(Node child : curr.children){
                if(child!=null && dfs(child,word,idx+1)){
                    return true;
                }
            }
            return false;
        }
            return dfs(curr.children[c-'a'],word,idx+1);
        
    }
    
    public boolean search(String word) {
        return dfs(root,word,0);
        
    }
}