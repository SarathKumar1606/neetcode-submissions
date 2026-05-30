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
        maxlen=Math.max(maxlen,height(root.left)+height(root.right));
        return Math.max(height(root.left),height(root.right))+1;
    }
    int maxlen=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxlen;
        
    }
}
