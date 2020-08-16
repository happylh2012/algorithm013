/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {

    private List<String> res=null;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<String>();
        generate(0,0,n,"");
        return res;
    }
    private void generate(int left,int right,int n,String s) {
        //terminator
        //left 随时可以加，只要别超标
        //right 左个数>右个数
        if(left == n && right == n ) {
            res.add(s);
            return;
        }
        //process
        //drill down 
        if (left < n) {
            generate(left+1,right,n,s+"(");
        }
        if (left > right ) {
            generate(left,right+1,n,s+")");
        }
        //reverse
    }

    /*private void generate(int level,int max,String s) {
        //terminator
        if(level>max) {
            return;
        }
        //process
        //drill down 
        generate(level+1,max,s+"(");
        generate(level+1,max,s+")");
        //reverse
    }*/
}
// @lc code=end

