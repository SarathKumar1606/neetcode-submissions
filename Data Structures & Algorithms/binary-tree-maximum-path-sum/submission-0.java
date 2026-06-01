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
    public int res=Integer.MIN_VALUE;
    public int helper(TreeNode node, int maxi){
        if(node==null) return 0;
        int leftmax=Math.max(0,helper(node.left,res));
        int rightmax=Math.max(0,helper(node.right,res));
        int curr=node.val+leftmax+rightmax;
        res=Math.max(curr,res);
        return node.val+Math.max(leftmax,rightmax);

    }
    public int maxPathSum(TreeNode root) {
         helper(root,res);
         return res;
        
    }
}
