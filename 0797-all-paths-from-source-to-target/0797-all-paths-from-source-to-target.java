class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();

        if (graph == null || graph.length == 0) {
            return res;
        }

        int m = graph.length, n = graph[0].length;

        List<Integer> path = new ArrayList<>();
        path.add(0);
        getPaths(0, graph, path, res);
        return res;
    }

    public void getPaths(int curNode, int[][] graph, List<Integer> path, List<List<Integer>> res) {
        if (curNode == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int nextNode : graph[curNode]) {
            path.add(nextNode);
            getPaths(nextNode, graph, path, res);
            path.remove(path.size() - 1);
        }
    }
}