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
   

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         if(root == null) return "#,";
        String res="";
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
             TreeNode node=q.poll();
             if(node==null){
                res+="#,";
                continue;
             }
             res+=node.val+",";
             q.offer(node.left);
             q.offer(node.right);
        }
        return res;
             
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
         String[] values=data.split(",");
        if(values[0].equals("#")) return null;
        Queue<TreeNode> q=new LinkedList<>();
       
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for(int i=1; i<values.length;i++){
            TreeNode parent=q.poll();
            if(!values[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left=left;
                q.offer(left);
            }
            if(i<values.length && !values[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                q.offer(right);
            }
        }
        return root;
        
    }
}
