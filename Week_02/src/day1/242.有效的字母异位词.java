
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
       char[] cs,ts;
       Arrays.sort(cs=s.toCharArray());
       Arrays.sort(ts=t.toCharArray());
       return Arrays.equals(cs, ts);
    }
}
// @lc code=end

