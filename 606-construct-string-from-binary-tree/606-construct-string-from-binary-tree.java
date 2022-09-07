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
    
    void visit(TreeNode node, StringBuilder str) {
        str.append(node.val);
        
        if (node.left == null && node.right == null) return;
        
        if (node.left != null) {
            str.append("(");
            visit(node.left, str);
            str.append(")");
        } else {
            str.append("()");
        }
        
        if (node.right != null) {
            str.append("(");
            visit(node.right, str);
            str.append(")");
        }
    }
    
    public String tree2str(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        visit(root, builder);
        return builder.toString();
    }
}