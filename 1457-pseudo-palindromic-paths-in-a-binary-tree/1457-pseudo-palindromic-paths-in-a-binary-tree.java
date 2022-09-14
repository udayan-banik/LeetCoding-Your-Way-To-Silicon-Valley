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
    public int pseudoPalindromicPaths (TreeNode root) {
        /* Record all traversed paths, and count the nodes passed by the path, and put the same together to calculate * Then count the number of nodes in each path %2, if you want to form a palindrome, there can only be at most one remainder 1 * Finally count all paths to get the result */
        ArrayList<HashMap<Integer, Integer>> paths = new ArrayList<>();
        HashMap<Integer, Integer> path = new HashMap<>();
        path.put(root.val, 1);
        DFS(paths, path, root);
        /* log all pseudo-palindromes */
        int count = 0;
        for(HashMap<Integer, Integer> oldPath : paths) {
            int single = 0;
            for(int val : oldPath.keySet()) {
                if(oldPath.get(val)%2 == 1) {
                    single++;
                }
            }
            /* At most one singular number (remainder 1) */
            if(single <= 1)count++; 
        }
        return count;
    }
    
    /* iterate over all paths */
    public void DFS(ArrayList<HashMap<Integer, Integer>> paths, HashMap<Integer, Integer> path, TreeNode root) {
        if(root.left != null) {
            HashMap<Integer, Integer> newPath = new HashMap<>(path);
            if(newPath.containsKey(root.left.val)) {
                newPath.put(root.left.val, newPath.get(root.left.val)+1);
            } else {
                newPath.put(root.left.val, 1);
            }
            DFS(paths, newPath, root.left);
        }
        if(root.right != null) {
            HashMap<Integer, Integer> newPath = new HashMap<>(path);
            if(newPath.containsKey(root.right.val)) {
                newPath.put(root.right.val, newPath.get(root.right.val)+1);
            } else {
                newPath.put(root.right.val, 1);
            }
            DFS(paths, newPath, root.right);
        }
        if(root.left == null && root.right == null) {
            paths.add(path);
        }
    }
}