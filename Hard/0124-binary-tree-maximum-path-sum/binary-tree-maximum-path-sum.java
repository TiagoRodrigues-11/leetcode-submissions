/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int _ = this.maxSum(root);
        return maxSum;
    }

    public int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSide = Math.max(maxSum(node.left), 0);
        int rightSide = Math.max(maxSum(node.right), 0);

        int sidesSum = leftSide + rightSide + node.val;
        this.maxSum = Math.max(this.maxSum, sidesSum);
        int maxSide = Math.max(leftSide, rightSide);
        return node.val + maxSide;
    }


}