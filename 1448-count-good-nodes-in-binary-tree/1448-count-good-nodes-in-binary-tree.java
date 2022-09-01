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
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        int max = root.val;
        
        countNodes(root, count, max);
        
        return count[0];
    }
    
    private void countNodes(TreeNode root, int[] count, int max) {
        if (root == null) {
            return;
        }
        
        if (root.val >= max) {
            count[0]++;
            max = root.val;
        }
        
        if (root.left != null) {
            countNodes(root.left,count,max);
        }
        
        if (root.right != null) {
            countNodes(root.right,count,max);
        }
    } 
}