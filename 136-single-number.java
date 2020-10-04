import java.util.Arrays;

/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 *
 * Explanation:
 * A binary xor with itself is always 0
 * For example: 
 * 2 xor 2 = 0
 * 0010 xor 0010 = 0
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }
}
// @lc code=end

