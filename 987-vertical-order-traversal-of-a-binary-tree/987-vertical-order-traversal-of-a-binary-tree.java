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
    
    int maxL = 0;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<List<Integer>>> tree = new ArrayList();
        dfs(root, 0, 0, tree);
        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < tree.size(); ++i) {
            List<Integer> temp = new ArrayList();
            for (List<Integer> row : tree.get(i))
                for (int val : row)
                    temp.add(val);
            
            res.add(temp);
        }
        
        return res;
    }
    
    void dfs(TreeNode node, int r, int c, List<List<List<Integer>>> res) {
        if (node == null)
            return;
        
        if (c < maxL)
            res.add(0, new ArrayList());
            
        maxL = Math.min(maxL, c);
        dfs(node.left, r+1, c-1, res);
        
        int col = c - maxL;
        while (col >= res.size())
            res.add(new ArrayList());
        
        int row = r / 2;
        while (row >= res.get(col).size())
            res.get(col).add(new ArrayList());
        
        int ind = getIndex(res.get(col).get(row), node.val);
        res.get(col).get(row).add(ind, node.val);

        dfs(node.right, r+1, c+1, res);
    }
    
    int getIndex(List<Integer> list, int val) {
        int ind = Collections.binarySearch(list, val);
        if (ind < 0)
            ind = Math.abs(ind) - 1;
        
        return ind;
    }
}