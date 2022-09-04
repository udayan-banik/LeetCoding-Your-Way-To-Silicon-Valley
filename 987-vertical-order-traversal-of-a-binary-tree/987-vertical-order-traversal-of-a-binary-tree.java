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
  List < List < Integer >> verticalTraversal(TreeNode root) {

    if (root == null) return Collections.emptyList();

    List<List<Node>> posList = new ArrayList<>();
    List<List<Node>> negList = new ArrayList<>();
    dfs(root, 0, 0, negList, posList);
    return mergeAndSort(negList, posList);
  }

  class Node {
    int val;
    int row;
    
    public Node(int val, int row) {
        this.val = val;
        this.row = row;
    }  
  }

  void dfs(TreeNode node, int row, int col, List<List<Node>> negList, List<List<Node>> posList) {

    if (node == null) return;

    if (col >= 0) {
      if (posList.size() == col) {
        posList.add(new ArrayList < >());
      }
      posList.get(col).add(new Node(node.val, row));

    } else {
      int posCol = -col - 1;
      if (negList.size() == posCol) {
        negList.add(new ArrayList<>());
      }
      negList.get(posCol).add(new Node(node.val, row));
    }

    // (row + 1, col - 1) left
    dfs(node.left, row + 1, col - 1, negList, posList);

    // and (row + 1, col + 1) right
    dfs(node.right, row + 1, col + 1, negList, posList);

  }

  List<List<Integer>> mergeAndSort(List<List<Node>> negList, List<List<Node>> posList) {
    List<List<Integer>> res = new ArrayList<>();

    for (int i = negList.size() - 1; i >= 0; i--) {
      List<Node> colList = negList.get(i);
      colList.sort((a, b) -> a.row == b.row ? a.val - b.val : a.row - b.row);
      res.add(buildList(colList)); 
    }

    for (int i = 0; i < posList.size(); i++) {
      List<Node> colList = posList.get(i);
      colList.sort((a, b) -> a.row == b.row ? a.val - b.val : a.row - b.row);
      res.add(buildList(colList)); 
    }

    return res;
  }
    
  List<Integer> buildList(List<Node> list) {
      return list.stream().map(a -> a.val).collect(Collectors.toList());
  }  
}