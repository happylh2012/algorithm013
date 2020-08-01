import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
           int tmp=target-nums[i];
           if(map.containsKey(tmp)) 
              return new int[]{map.get(tmp),i};
           map.put(nums[i],i);
        }
        return null;
    }
}
// @lc code=end

