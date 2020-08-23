import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1512 lang=java
 *
 * [1512] Number of Good Pairs
 */

// @lc code=start
class Solution {
    public int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;

        for (int num : nums) {
            int currentMatches = map.getOrDefault(num, 0);
            
            map.put(num, currentMatches+1);
        }
        return counter;
    }
}
// @lc code=end

