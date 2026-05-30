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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        TreeNode prev=root;
        while(!q.isEmpty()){
            int levelSize=q.size();
            for(int i=0; i<levelSize; i++){
                prev=q.poll();
                if(i==levelSize-1) res.add(prev.val);
                if(prev.left!=null) q.add(prev.left);
                if(prev.right!=null) q.add(prev.right);
            }
        }
        return res;
        
    }
}
