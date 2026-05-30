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
    private boolean balanced=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        height(root);
        return balanced;
    }
    public int height(TreeNode root){
        if(root==null||!balanced) return 0;
        int lefth=height(root.left);
        int righth=height(root.right);
        if(Math.abs(lefth-righth)>1) balanced =false;

        return Math.max(lefth,righth)+1;
    }
}
