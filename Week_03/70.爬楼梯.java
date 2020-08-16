/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        //1、递归
        //if(n<=1)return 1;
        //if(n<3)return n;
        //return climbStairs(n-1)+climbStairs(n-2);
        //2、尾递归  如何转换递归->尾递归
        //return recur(n,1,1);
        //3、非递归   递归转循环
        if(n<=1)return 1;
        int[] a=new int[n+1];
        a[1]=1;
        a[2]=2;
        for(int i=3;i<=n;i++){
            a[i]=a[i-1]+a[i-2];
        }
        return a[n];
        
    }
    int recur(int n,int a,int b){
        if(n<=1)return b;
        return recur(n-1,b,a+b);
    }
}
// @lc code=end

