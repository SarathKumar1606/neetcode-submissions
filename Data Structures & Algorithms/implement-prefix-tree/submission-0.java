class PrefixTree{
    class Node{
        Node[] children;
        boolean isEnd;
        Node(){
            children=new Node[26];
            for(int i=0; i<26;i++){
                children[i]=null;
            }
            isEnd=false;
        }
    }
    Node root;

    public PrefixTree() {
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
        curr.isEnd=true;
        
    }
    
    public boolean search(String word) {
        Node curr=root;
        for(char c : word.toCharArray()){
            int idx=c-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        Node curr=root;
        for(char c : prefix.toCharArray()){
            int idx=c-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
        
    }
}

