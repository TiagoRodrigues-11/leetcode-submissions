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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // First element of preorder will always be the root of the tree
        TreeNode node = new TreeNode(preorder[0]); 
        int inorderIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                inorderIndex = i;
                break;
            }
        }

        node.left = buildTree(
            Arrays.copyOfRange(preorder, 1, inorderIndex+1), 
            Arrays.copyOfRange(inorder, 0, inorderIndex)
        );
        node.right = buildTree(
            Arrays.copyOfRange(preorder, inorderIndex + 1, preorder.length), 
            Arrays.copyOfRange(inorder, inorderIndex+1, inorder.length)
        );

        return node;
    }
}