/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        postTraversal(root,res);
        return res;

    }
    void postTraversal(TreeNode root, List<Integer> res){
        if(root==null)return;
        postTraversal(root.left,res);
        postTraversal(root.right,res);
        res.add(root.val);
    }
}
// @lc code=end

