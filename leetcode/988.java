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

    String pathToString(Stack<Integer> path) {
        var sb = new StringBuilder();
        path.forEach(i -> sb.append((char)(i + 'a')));
        return sb.reverse().toString();
    }

    String dfs(TreeNode node, Stack<Integer> path) {
        if (node == null) return null;
        path.push(node.val);
        if (node.left == null && node.right == null) {
            var res = pathToString(path);
            path.pop();
            return res;
        } else {
            var p1 = dfs(node.left, path);
            var p2 = dfs(node.right, path);
            path.pop();
            if (p1 == null) return p2;
            if (p2 == null) return p1;
            if (p1.compareTo(p2) > 0) {
                return p2;
            }
            return p1;
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, new Stack<Integer>());
    }
}