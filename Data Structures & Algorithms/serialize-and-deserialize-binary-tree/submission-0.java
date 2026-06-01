/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    String inorder="", preorder="",res="";
    public void inorder(TreeNode root){
        if(root==null) {
            return;
        }
        inorder(root.left);
        inorder+=root.val+",";
        inorder(root.right);
    }
    public void preorder(TreeNode root){
        if(root==null) {
            return;
        }
        preorder+=root.val+",";
        preorder(root.left);
        preorder(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        inorder(root);
        preorder(root);
        return inorder+"|"+preorder;
        
    }

    HashMap<Integer,Integer> mp=new HashMap<>();
    int preIndex=0;
    
    TreeNode build(String[] preorder, int left, int right){
        if(left>right) return null;
        int rootVal=Integer.parseInt(preorder[preIndex]);
        preIndex++;
        int mid=mp.get(rootVal);
        TreeNode root=new TreeNode(rootVal);
        root.left=build(preorder,left,mid-1);
        root.right=build(preorder,mid+1,right);
        return root;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("|")) {
        return null;
    }
        String[] parts=data.split("\\|");
        String[] inorder=parts[0].split(",");
        String[] preorder=parts[1].split(",");
        mp.clear();
        for(int i=0; i<inorder.length;i++){
            if(!inorder[i].isEmpty()){
                mp.put(Integer.parseInt(inorder[i]),i);
            }
        }
        return build(preorder,0,inorder.length-1);
    }
}
