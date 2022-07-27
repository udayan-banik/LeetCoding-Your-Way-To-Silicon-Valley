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
public class Solution {
    public void flatten(TreeNode root) {
        flat(root);
    }

    private TreeNode flat(TreeNode root){
        if(root == null) return null;

        TreeNode ltail = flat(root.left);
        TreeNode rtail = flat(root.right);
        if(root.left != null){
            ltail.right = root.right;
            root.right = root.left;
            root.left = null;

        }
        if(rtail != null) return rtail;
        if(ltail != null) return ltail;
        return root;
    }
}