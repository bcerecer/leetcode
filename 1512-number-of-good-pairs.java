import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1512 lang=java
 *
 * [1512] Number of Good Pairs
 * 
 * Complexity:
 *  Runtime: O(n)
 *  Space: O(n)
 */

// @lc code=start
class Solution {
    public int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int counter = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int occurrences = map.getOrDefault(num, 0);
            counter += occurrences;
            map.put(num, occurrences+1);
        }

        return counter;
    }
}
// @lc code=end

