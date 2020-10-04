/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = 0;
        int realSum = 0;
        for (int i = 0; i < nums.length; i++) {
            expectedSum += i+1;
            realSum += nums[i];
        }
        return expectedSum - realSum;
    }
}
// @lc code=end

