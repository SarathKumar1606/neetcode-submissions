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
    int ans=0;
    int count=0;
    void inOrder(TreeNode node,int k){
        if(node==null) return;  
        inOrder(node.left,k);
        count++;
        if(count==k){
            ans=node.val;
            return;
        }
        inOrder(node.right,k);

    }
    public int kthSmallest(TreeNode root, int k) {

        if(root==null) return 0;
        inOrder(root,k);
        return ans;
        
    }
}
