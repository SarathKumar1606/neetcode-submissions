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
    public int good=0;
    public void count(TreeNode node, int max){
        if(node==null) return;
        if(node.val>=max) good++;
        max=Math.max(max,node.val);
        count(node.left,max);
        count(node.right,max);

    }
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        count(root,root.val);
        return good;
    }
}
