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

class Solution {
    public int height(TreeNode root){
        if(root==null) return 0;
        int leftlen=height(root.left),rightlen=height(root.right);
        int currlen=leftlen+rightlen;
        maxlen=Math.max(maxlen,currlen);
        return Math.max(leftlen,rightlen)+1;
    }
    int maxlen=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxlen;
        
    }
}
