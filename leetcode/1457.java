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

    int dfs(TreeNode node, int parity) {
        if (node == null) return 0;
        //dbg(parity, node.val);
        parity ^= 1 << node.val;
        if (node.left != null || node.right != null) 
            return dfs(node.left, parity) + dfs(node.right, parity);
        else 
            return (parity & (parity - 1)) == 0 ? 1 : 0;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, 0);
    }

}