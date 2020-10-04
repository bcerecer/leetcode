import java.util.Arrays;

/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 */

// @lc code=start
/*
Explanation:
This problem is solved by turning the value in the index of visited. 

For example:
[4,3,2,7,8,2,3,1]

The first loop will generate:
[4,3,2,-7,8,2,3,1]
Because index for is seen. If there was another 4, it would stay negative. However,
if the number is not there, the value of its array's index will stay

*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
// @lc code=end

