import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        traversal(root,result);
        return result;

    }
    void traversal(TreeNode root,List<Integer> result){
        if(root==null)return;
        traversal(root.left,result);
        result.add(root.val);
        traversal(root.right,result);
    }
}
// @lc code=end

