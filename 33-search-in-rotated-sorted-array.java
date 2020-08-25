/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 * 
 * Complexity:
 *  Runtime: O(logn)
 *  Space: O(1)
 */
// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int l = 0;
        int r = nums.length - 1;
        int shift = findMinIndex(nums);
        
        if (target > nums[r]) {
            r = shift - 1;
        } else {
            l = shift;
        }
        
        return binarySearch(nums, l, r, target);
    }
    
    public int findMinIndex(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l < r) {
            int mid = l + (r -l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
    
    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) /2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

