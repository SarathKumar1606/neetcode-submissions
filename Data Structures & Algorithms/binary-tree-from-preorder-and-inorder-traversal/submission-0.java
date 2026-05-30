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
    HashMap<Integer,Integer> mp=new HashMap<>();
    int preIndex=0;
    TreeNode build(int[] preorder, int left, int right){
        if(left>right) return null;
        int rootVal=preorder[preIndex];
        preIndex++;
        int mid=mp.get(rootVal);
        TreeNode node=new TreeNode(rootVal);
        node.left=build(preorder,left,mid-1);
        node.right=build(preorder,mid+1,right);
        return node;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            mp.put(inorder[i],i);  
        }
         return build(preorder,0,preorder.length-1);
        
    }
}
