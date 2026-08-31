/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
     * @param {TreeNode} root
     * @return {number}
     */
    diameterOfBinaryTree(root: TreeNode | null): number {
        let diameter = 0

        const height = (node: TreeNode | null): number => {
            if (!node) {
                return 0
            }

            const l = height(node.left)
            const r = height(node.right)

            diameter = Math.max(diameter, l+r)

            return 1+ Math.max(l, r)
        }

        height(root)

        return diameter
    }
}