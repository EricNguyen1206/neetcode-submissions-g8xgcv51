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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();

        serDfs(root, res);

        return String.join(",", res);
    }

    private void serDfs(TreeNode root, List<String> res) {
        if (root == null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(root.val));
        serDfs(root.left, res);
        serDfs(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = new int[]{0};
        TreeNode root = desDfs(vals, i);
        return root;
    }

    private TreeNode desDfs(String[] data, int[] i) {
        if (data.length == 0) return null;
        if (data[i[0]].equals("N")) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data[i[0]]));
        i[0]++;
        node.left = desDfs(data, i);
        node.right = desDfs(data, i);
        return node;

    }
}
