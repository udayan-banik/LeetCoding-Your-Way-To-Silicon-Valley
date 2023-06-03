class Solution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                result = Math.max(result, check(manager, informTime, i));
            }
        }
        return result;
    }

    public int check(int[] manager, int[] informTime, int source) {
        if (manager[source] != -1) {
            informTime[source] = informTime[source] + check(manager, informTime, manager[source]);
        }
        manager[source] = -1;
        return informTime[source];
    }
}