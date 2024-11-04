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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (sameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

    protected boolean sameTree(TreeNode tree1, TreeNode tree2)  {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.val == tree2.val) {
            return sameTree(tree1.right, tree2.right) && sameTree(tree1.left, tree2.left);
        }
        return false;

    }
}