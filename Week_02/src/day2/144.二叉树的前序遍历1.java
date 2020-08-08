import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

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
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null || stack.size()>0){
            if(root!=null){
                res.add(root.val);
                stack.add(root);
                root=root.left;
            }
            else{
                TreeNode tmp=stack.pop();
                root=tmp.right;
            }
        }
        return res;

    }

}
// @lc code=end

