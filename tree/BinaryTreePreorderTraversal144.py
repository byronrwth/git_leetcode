# Definition for a binary tree node.
class TreeNode:
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None

class Solution1:
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        self.dfs(root, res)
        return res
    
    def dfs(self, root, res):
        if root:
            res.append(root.val)
            self.dfs(root.left, res)
            self.dfs(root.right, res)

class Solution2:
    """docstring for Solution"""
    def __init__(self, arg):
        super(Solution2,self).__init__()
        self.arg = arg
    
    # iteratively
    def preorderTraversal(self, root):
        stack, res = [root], []
        while stack:
            node = stack.pop()
            if node:
                res.append(node.val)
                stack.append(node.right)
                stack.append(node.left)
        return res






class Guide():
    def __init__(self, ope, node):
        #self.node = TreeNode.__init__(self)
        self.ope = ope
        self.node = node
        
class Solution3:
    def preorderTraversal(self, root):
        stack, res = [Guide(0, root)], []
        while stack:
            new_guide= stack.pop()

            
            if new_guide.node != None:
                if new_guide.ope == 1:
                    res.append(new_guide.node.val)
                else:
                
                    stack.append(Guide(0, new_guide.node.right))
                    stack.append(Guide(0, new_guide.node.left))
                    stack.append(Guide(1, new_guide.node))
        return res