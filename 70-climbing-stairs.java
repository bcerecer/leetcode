/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */
//1 1+1              1
//2 1+1 2            2
//3 1+1+1 1+2 2+1    3
//4 1+1+1+1 1+       5
// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
// @lc code=end

