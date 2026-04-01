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
        List<Integer> travel = new ArrayList<>();
        dfs(root, k, travel);
        int res = -1;
        if (travel.size() < k) {
            return res;
        }
        Collections.sort(travel);
        return travel.get(k-1);
    }

    public void dfs(TreeNode root, int k, List<Integer> travel) {
        if (root == null) return;
        travel.add(root.val);
        dfs(root.left, k, travel);
        dfs(root.right, k, travel);
    }
}
