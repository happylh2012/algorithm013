import java.util.List;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        preTraversal(root,res);
        return res;

    }

    void preTraversal(TreeNode root,List<Integer> res){
        if(root==null)return;
        res.add(root.val);
        preTraversal(root.left,res);
        preTraversal(root.right,res);
    }
}
// @lc code=end

