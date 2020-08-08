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
        Stack<TreeNode> stack=new Stack<>();
        while(stack.size()>0 || root!=null){
            if(root!=null){
                stack.push(root);
                root=root.right;
            }
            else{
                TreeNode tmp=stack.pop();
                root=tmp.left;
                res.add(root.val);
            }
        }
        return res;

    }
   
}
// @lc code=end

