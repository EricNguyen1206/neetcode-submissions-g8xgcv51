# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []

        def dfs(node: Ootpional[TreeNode], k: int):
            if not node:
                return
            
            if len(stack) >= k:
                return
            
            if node.left:
                dfs(node.left, k)

            stack.append(node.val)

            if node.right:
                dfs(node.right, k)
        
        dfs(root, k)

        
        return stack[k-1]
        
            

        
        