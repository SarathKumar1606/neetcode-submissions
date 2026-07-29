/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    string serialize(TreeNode* root){
        if(!root) return ",#";
        string res=",";
        res+=(char)root->val+'0';
        res+=serialize(root->left);
        res+=serialize(root->right);
        return res;
    }
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        if(!root) return false;
        string main=serialize(root);
        string sub=serialize(subRoot);
        return main.contains(sub);
    }
};
