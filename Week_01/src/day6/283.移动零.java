/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null) return;
        int i=0;
        for(int j=0;j<nums.length;j++) {
            if(nums[j]!=0) {
                int tmp=nums[j];
                nums[j]=nums[i];
                nums[i++]=tmp;
            }
        }
    }
}
// @lc code=end

