import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=1315 lang=java
 *
 * [1315] Sum of Nodes with Even-Valued Grandparent
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     boolean isEven;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * Complexity:
 *  Runtime: O(n)
 *  Space: O(n)
 */
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        int result = 0;

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode grandPa = q.poll();
            boolean isGrandPaValid = grandPa.val % 2 == 0 ? true : false;

            if (grandPa.left != null) {
                q.add(grandPa.left);

                if (isGrandPaValid) {
                    if (grandPa.left.left != null) {
                        result += grandPa.left.left.val;
                    }
                    if (grandPa.left.right != null) {
                        result += grandPa.left.right.val;
                    }
                }
            }

            if (grandPa.right != null) {
                q.add(grandPa.right);

                if (isGrandPaValid) {
                    if (grandPa.right.left != null) {
                        result += grandPa.right.left.val;
                    }
                    if (grandPa.right.right != null) {
                        result += grandPa.right.right.val;
                    }
                }
            }            
        }
        return result;
    }
}
// @lc code=end

