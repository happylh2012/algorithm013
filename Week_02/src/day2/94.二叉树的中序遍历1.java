import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

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
        List<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while( stack.size()>0 || root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }
            else{
                TreeNode tmp=stack.pop();
                res.add(tmp.val);
                root=tmp.right;
            }
        }
        return res;

    }

}
// @lc code=end

