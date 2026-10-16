/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func invertTree(root *TreeNode) *TreeNode {
    // Base case: if the root is nil, we are done
    if root == nil {
        return nil
    }
    
    // Swap the left and right pointers (Go allows clean tuple assignment)
    root.Left, root.Right = root.Right, root.Left
    
    // Recursively invert the left and right subtrees
    invertTree(root.Left)
    invertTree(root.Right)
    
    return root
}