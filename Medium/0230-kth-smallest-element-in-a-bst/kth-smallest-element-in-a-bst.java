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
    public int kthSmallest(TreeNode root, int k) {
        int[] kN = new int[2];
        kN[0] = k;
        dfs(root, kN);
        return kN[1];
    }

    public void dfs(TreeNode node, int[] kN) {
        if (node == null) {
            return;
        }

        dfs(node.left, kN);
        kN[0]--;

        if (kN[0] == 0) {
            kN[1] = node.val;
            return;
        }

        dfs(node.right, kN);
    }
}