class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        int res = n;
        Arrays.sort(edges, (e1, e2) -> Integer.compare(Math.max(vals[e1[0]], vals[e1[1]]), Math.max(vals[e2[0]], vals[e2[1]])));
        int[] group = new int[n];
        int[] maxValue = new int[n];
        int[] maxValueCount = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
            maxValue[i] = vals[i];
            maxValueCount[i] = 1;
        }

        for (int[] edge: edges) {
            int g1 = getGroup(edge[0], group);
            int g2 = getGroup(edge[1], group);
            if (g1 != g2) {
                group[g2] = g1;
                if (maxValue[g1] < maxValue[g2]) {
                    maxValueCount[g1] = 0;
                } else if (maxValue[g1] > maxValue[g2]) {
                    maxValueCount[g2] = 0;
                }
                res += maxValueCount[g1] * maxValueCount[g2];
                maxValue[g1] = Math.max(maxValue[g1], maxValue[g2]);
                maxValueCount[g1] = maxValueCount[g1] + maxValueCount[g2];
            }
        }

        return res;
    }

    private int getGroup(int node, int[] group) {
        if (group[node] != node) {
            group[node] = getGroup(group[node], group);
        }
        return group[node];
    }
}