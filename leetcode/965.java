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

    private boolean isUnival(TreeNode node, int val) {
        return val == node.val 
            && (node.left == null || isUnival(node.left, val)) 
            && (node.right == null || isUnival(node.right, val));
    }

    public boolean isUnivalTree(TreeNode root) {
        return isUnival(root, root.val);
    }
}