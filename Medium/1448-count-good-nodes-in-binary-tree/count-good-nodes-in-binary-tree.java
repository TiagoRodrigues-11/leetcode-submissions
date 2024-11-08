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
    public int goodNodes(TreeNode root) {
        return 1 + checkGoodNodes(root.left, root.val) +  checkGoodNodes(root.right, root.val);
    }
    public int checkGoodNodes(TreeNode node, int greaterValue) {
        if (node == null){
            return 0;
        }

        int checkGoodNodesLeft = checkGoodNodes(node.left, Math.max(node.val, greaterValue));
        int checkGoodNodesRight = checkGoodNodes(node.right, Math.max(node.val, greaterValue));

        if (greaterValue <= node.val) {
            return 1 + checkGoodNodesLeft + checkGoodNodesRight;
        } else {
            return checkGoodNodesLeft + checkGoodNodesRight;
        }

    }
}