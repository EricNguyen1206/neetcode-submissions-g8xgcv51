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
        List<TreeNode> potentialNode = new ArrayList<>();
        dfs(root, subRoot.val, potentialNode);

        if (potentialNode.size() == 0) return false;

        for (TreeNode item : potentialNode) {
            if (isSameTree(item, subRoot)) return true;
        }

        return false;
    }

    public void dfs(TreeNode root, int target, List<TreeNode> res) {
        if (root == null) return;
        if (root.val == target) res.add(root);
        dfs(root.left, target, res);
        dfs(root.right, target, res);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
